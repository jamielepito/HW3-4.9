package pack;

public class ReadWriteLock {
	private int readHold = 0; // tell number readers holding
	private int writeHold = 0; // tell number writers hold
	private int writeWait = 0;


	public synchronized void writeLock(String threadName) throws InterruptedException {
		
		while (readHold > 0 || writeHold > 0) {
			System.out.println("writer " + threadName + " tries to acquire lock, cannot, waits");
			writeWait++;
			wait(); // waits when object in use
		}
		writeWait--;
		writeHold++; // inc writers holds
		System.out.println("writer " + threadName + " is writing");

	}

	public synchronized void readLock(String threadName) throws InterruptedException {
		//readHold++;
			while (writeHold > 0 || writeWait > 0) {
				System.out.println("reader " + threadName + " tries to acquire lock, cannot, waits");
				wait(); // waits when writer using
			}
			readHold++;
			System.out.println("reader " + threadName + " is reading");

	}
	public synchronized void writeUnlock(String threadName){
		writeHold--;
		System.out.println("writer " + threadName + " is done");
		notifyAll(); // wake up when available to use
	}
	
	public synchronized void readUnlock(String threadName){
		readHold--;
		System.out.println("reader " + threadName + " is done");

		if (readHold == 0) {
			notifyAll(); // allow to use when no writer using
		}
	}


}
