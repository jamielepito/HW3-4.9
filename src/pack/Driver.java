package pack;

public class Driver {

	public static void main(String[] args) throws InterruptedException{
		FileEditor fe = new FileEditor(10);
		Writer write = new Writer("W0", fe);
		Reader read = new Reader("R0", fe);
		Reader read1 = new Reader("R1", fe);
		Reader read2 = new Reader("R2", fe);
		Writer write1 = new Writer("W1", fe);
		Writer write2 = new Writer("W2", fe);
		Reader read3 = new Reader("R3", fe);
		Reader read4 = new Reader("R4", fe);
		Reader read5 = new Reader("R5", fe);
		Writer write3 = new Writer("W3", fe);
		
		write.start();
		read.start();
		read1.start();
		write1.start();
		read2.start();
		write2.start();
		read3.start();
		read4.start();
		write3.start();
		read5.start();
		
	}


}
