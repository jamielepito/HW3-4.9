package pack;

public class Writer extends Thread {
	private String threadName;
	private FileEditor fileEditor;
	

	public Writer(String name, FileEditor fe){
		fileEditor = fe;
		//give same version of class to all threads
		threadName = name;
	}

	public void run() {
		fileEditor.writeFile(threadName);
	}
}
