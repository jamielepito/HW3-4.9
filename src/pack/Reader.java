package pack;

public class Reader extends Thread{
	private String readThread;
	private final ReadWriteLock lock;
	
//	Reader(String name){
//		readThread = name; //allow to create instance of thread
//	}
	public Reader(ReadWriteLock lock){
		//give same version of class to all threads
		this.lock = lock;
	}
	
	public void run(){
		try {
			//calls lock with value 3
			for (int i = 0; i <= 10; i++) {
				lock.reader();
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	
}
