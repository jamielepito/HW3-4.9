package pack;

import java.util.Random;

public class FileEditor {
	
	private int[] array;
	private int index_in;
	private int index_out;
	
	private ReadWriteLock lock = new ReadWriteLock();
	
	public FileEditor (int arraySize){
		array = new int[arraySize];
		index_in = 0;
		index_out = 0;
	}
	public void readFile(String threadName){
		try {
			//reader holds the file
			lock.readLock(threadName);
			int num = array[index_out];
			System.out.println("Reader " + threadName + " read " + num + 
					" from array index " + index_out);
			index_out = (++index_out % array.length);
			lock.readUnlock(threadName);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public void writeFile(String threadName){
		try {
			//reader holds the file
			lock.writeLock(threadName);
			Random rand = new Random();
			int num = rand.nextInt(10);
			array[index_in] = num;
			System.out.println("Writer " + threadName + " wrote " + num + 
					" in array index " + index_in);
			index_in = (++index_in) % array.length;
			lock.writeUnlock(threadName);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
