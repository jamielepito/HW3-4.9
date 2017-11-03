package pack;

public class Writer extends Thread {
	private String writeThread;
	// instance of lock class
	private final ReadWriteLock lock;

	public Writer(ReadWriteLock lock) {
		// give same version of class to all threads
		this.lock = lock;
	}

	public void run() {
		try {
			// calls lock with value 3
			for (int i = 0; i <= 10; i++) {
				lock.writer(i);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
