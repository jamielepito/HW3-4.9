package pack;

public class ReadWriteLock {
	private int readHold = 0; // tell number readers holding
	private int writeHold = 0; // tell number writers hold
	private int numbers = 0;


	public synchronized void writeLock(String threadName) throws InterruptedException {
		
		while (readHold > 0 || writeHold > 0) {
			System.out.println("writer " + threadName + " tries to acquire lock, cannot, waits");
			wait(); // waits when object in use

		}
		writeHold++; // inc writers holds
		System.out.println("writer " + threadName + " is writing");

	}

	public synchronized void readLock(String threadName) throws InterruptedException {
		//readHold++;
			while (writeHold > 0) {
				System.out.println("reader " + threadName + " tries to acquire lock, cannot, waits");
				wait(); // waits when writer using
			}
//			while (numbers <= 0){
//				System.out.println("file is empty so reader " + threadName + " waits");
//				wait();
//			}
			readHold++;
			System.out.println("reader " + threadName + " is reading");

	}
	public synchronized void writeUnlock(String threadName){
		writeHold--;
		numbers++;
		System.out.println("writer " + threadName + " is done");
		notifyAll(); // wake up when available to use
	}
	
	public synchronized void readUnlock(String threadName){
		readHold--;
		numbers--;
		System.out.println("reader " + threadName + " is done");

		if (readHold == 0) {
			notifyAll(); // allow to use when no writer using
		}
	}


}
