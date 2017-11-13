package pack;

public class Reader extends Thread{
	private String threadName;
	private FileEditor fileEditor;
	
	public Reader(String name, FileEditor fe){
		fileEditor = fe;
		//give same version of class to all threads
		threadName = name;
	}
	
	public void run(){
		fileEditor.readFile(threadName);
	}
	
	
}
