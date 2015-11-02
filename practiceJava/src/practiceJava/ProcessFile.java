package practiceJava;

public class ProcessFile implements Runnable {
	private ParaWebstats webstats;
	private String fileName;
	public ProcessFile(ParaWebstats webstats, String fileName) {
		this.webstats = webstats;
		this.fileName = fileName;
	}
	public void run() {
		webstats.process_file(fileName);
	}
}
