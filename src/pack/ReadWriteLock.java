package pack;

//code from last project, should just need some minor edits to work for this iteration
public class ReadWriteLock {
	private Object[] array = new Object[20]; //Array of arbitrary size
	private int readHold = 0; //tell number readers holding
	private int writeHold = 0; //tell number writers hold
	private int index_in = 0;
	private int index_out = 0;
	
	public synchronized void producer(Object o) throws InterruptedException{
		
		while (readHold > 0 || writeHold > 0){
			wait(); //waits when object in use
		}
		writeHold++; //inc writers hold
		//run
		writeHold--;
		notifyAll(); //wake up when available to use
	}
	
	public synchronized Object consumer() throws InterruptedException{
		
		while (writeHold > 0){
			wait(); //waits when writer using
		}
		readHold++; 
		//run
		readHold--;
		while (readHold == 0){
			notifyAll(); //allow to use when no writer using
		}
		return array[readHold+writeHold]; //returns object in array at index of however many threads hold it
	}
}
