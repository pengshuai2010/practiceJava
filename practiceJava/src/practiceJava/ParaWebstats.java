package practiceJava;
/*
Original Author: Jeff Cope
Maintaining Author: Amit Jain
Class: CS 453


*/

import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class ParaWebstats
{
	private final int MAX_LINE_SIZE = 4096;
	private final int MAX_NUM_FIELDS = 40;
	private final int HTTP_STATUS_CODE_FIELD = 8;
	private final int BYTES_DOWNLOADED_FIELD = 9;
	
	/**
	 * @return the local_bytes
	 */
	protected synchronized double getLocal_bytes() {
		return local_bytes;
	}

	/**
	 * @return the total_bytes
	 */
	protected synchronized double getTotal_bytes() {
		return total_bytes;
	}

	/**
	 * @return the local_gets
	 */
	protected synchronized double getLocal_gets() {
		return local_gets;
	}

	/**
	 * @return the total_gets
	 */
	protected synchronized double getTotal_gets() {
		return total_gets;
	}

	/**
	 * @return the failed_gets
	 */
	protected synchronized double getFailed_gets() {
		return failed_gets;
	}

	/**
	 * @return the local_failed_gets
	 */
	protected synchronized double getLocal_failed_gets() {
		return local_failed_gets;
	}

	/**
	 * @return the requests
	 */
	protected synchronized int getRequests() {
		return requests;
	}

	/**
	 * @param local_bytes the local_bytes to set
	 */
	protected synchronized void setLocal_bytes(double local_bytes) {
		this.local_bytes = local_bytes;
	}

	/**
	 * @param total_bytes the total_bytes to set
	 */
	protected synchronized void setTotal_bytes(double total_bytes) {
		this.total_bytes = total_bytes;
	}

	/**
	 * @param local_gets the local_gets to set
	 */
	protected synchronized void setLocal_gets(double local_gets) {
		this.local_gets = local_gets;
	}

	/**
	 * @param total_gets the total_gets to set
	 */
	protected synchronized void setTotal_gets(double total_gets) {
		this.total_gets = total_gets;
	}

	/**
	 * @param failed_gets the failed_gets to set
	 */
	protected synchronized void setFailed_gets(double failed_gets) {
		this.failed_gets = failed_gets;
	}

	/**
	 * @param local_failed_gets the local_failed_gets to set
	 */
	protected synchronized void setLocal_failed_gets(double local_failed_gets) {
		this.local_failed_gets = local_failed_gets;
	}

	/**
	 * @param requests the requests to set
	 */
	protected synchronized void setRequests(int requests) {
		this.requests = requests;
	}


	private double local_bytes;
	private double total_bytes;
	private double local_gets;
	private double total_gets;
	private double failed_gets;
	private double local_failed_gets;
	private String url;
	private int requests;
	private String program_name;
	/**
	 * @param local_bytes the local_bytes to set
	 */
	protected synchronized void increaseLocal_bytes(double local_bytes) {
		this.local_bytes += local_bytes;
	}

	/**
	 * @param total_bytes the total_bytes to set
	 */
	protected synchronized void increaseTotal_bytes(double total_bytes) {
		this.total_bytes += total_bytes;
	}


	/**
	 * @param local_gets the local_gets to set
	 */
	protected synchronized void increaseLocal_gets(double local_gets) {
		this.local_gets += local_gets;
	}


	/**
	 * @param total_gets the total_gets to set
	 */
	protected synchronized void increaseTotal_gets(double total_gets) {
		this.total_gets += total_gets;
	}
	
	/**
	 * @param failed_gets the failed_gets to set
	 */
	protected synchronized void increaseFailed_gets(double failed_gets) {
		this.failed_gets += failed_gets;
	}

	/**
	 * @param local_failed_gets the local_failed_gets to set
	 */
	protected synchronized void increaseLocal_failed_gets(double local_failed_gets) {
		this.local_failed_gets += local_failed_gets;
	}

	/**
	 * @param requests the requests to set
	 */
	protected synchronized void increaseRequests(int requests) {
		this.requests += requests;
	}


	
	/**
	  parse_line(): Parse one line into String tokens separated by the given delimiters.
	  @param line A character array containing the current server log entry line
	  @param delim: A character array containing the delimiters to be used to separate fields in the line
	  @return The number of tokens found in the line.
	*/
	private int parse_line(String line, String delim, String field[])
	{
		String next;
		int cnt = 0;
		StringTokenizer strtok = new StringTokenizer(line, delim);
		while (strtok.hasMoreTokens())
		{
			next = strtok.nextToken();
			if (cnt == MAX_NUM_FIELDS-1) break;
			field[cnt++] = next;
		}
		field[cnt] = null; /* make the field array be null-terminated */
		return cnt;
	}

	/*
	   free_tokens(): Clears spaces allocated for tokens in parse_line
	   @param num An int representing number of tokens in array of strings named field.
	   @param field An array of Strings
	   @return none.
	*/
	private void free_tokens(int num, String field[])
	{
		for (int i = 0; i < num; i++)
		{
			field[i] = "";
		}
	}
	
	/**
	  Webstats(): Initializes the webstats structure.
	  @param new_program_name This programs name.
	  @return none
	*/
	public ParaWebstats(String new_program_name)
	{
		program_name = new_program_name;
		local_bytes = 0;
		total_bytes = 0;
		local_gets = 0;
		total_gets = 0;
		failed_gets = 0;
		local_failed_gets = 0;
	}


	/*
	  update_webstats(): Updates the webstats structure based on the input fields of current line.
	  @param num The number of fields in the current webserver log entry
	  @param field An array of num Strings representing the log entry
	  @return none
	*/
	private void update_webstats(int num, String field[])
	{
		int bytes_downloaded = 0;
		try {
			bytes_downloaded = Integer.parseInt(field[BYTES_DOWNLOADED_FIELD]);
		} catch (NumberFormatException e) {
			//skip lines without downloaded bytes field
		}
		//total_gets++;
		this.increaseTotal_gets(1);
		//total_bytes += bytes_downloaded;
		this.increaseTotal_bytes(bytes_downloaded);
		if (field[HTTP_STATUS_CODE_FIELD].equals("404")) {
			//failed_gets++;
			this.increaseFailed_gets(1);
		}
			

		if ((field[0].indexOf("boisestate.edu") != -1) || (field[0].indexOf("132.178") != -1)) {
			//local_gets++;
			this.increaseLocal_gets(1);
			//local_bytes += bytes_downloaded;
			this.increaseLocal_bytes(bytes_downloaded);
			if (field[HTTP_STATUS_CODE_FIELD].equals("404")) {
				//local_failed_gets++;
				this.increaseLocal_failed_gets(1);
			}
				
		}
	}

	/*
	  print_webstats(): Print out webstats on standard output.
	  @return none
	*/
	protected void print_webstats()
	{
		System.out.printf("%10s %15s   %15s  %15s\n", "TYPE", "gets","failed gets", "MB transferred");

		System.out.printf("%10s  %15.0f  %15.0f  %15.0f\n", "local", local_gets, local_failed_gets, 
													(double) local_bytes/(1024*1024));
		System.out.printf("%10s  %15.0f  %15.0f  %15.0f\n", "total", total_gets, failed_gets, 
													(double) total_bytes/(1024*1024));

	}
	
	/**
	  process_file(): The main function that processes one log file
	  @param ptr Pointer to log file name.
	  @return none
	  output: none
 	*/
	public void process_file(Object ptr)
	{
		String filename = (String) ptr;
		String linebuffer;
		String field[] = new String[MAX_NUM_FIELDS]; 
		String end_date = "";

		System.err.println(program_name + ": processing log file " + filename);
		try {
			BufferedReader fin = new BufferedReader(new FileReader(new File(filename)));
			try {
				linebuffer = fin.readLine();
				if (linebuffer != null) {
					int num = parse_line(linebuffer, " []\"", field);
					update_webstats(num, field);
					System.out.println("Starting date: " + field[3]);
					free_tokens(num, field);
					
					while ((linebuffer = fin.readLine()) != null) {
						num = parse_line(linebuffer, " []\"", field);
						end_date = field[3];
						update_webstats(num, field);
						free_tokens(num, field);
						linebuffer = "";
					}
					System.out.println("Ending date: "+ end_date);
				}
			} catch (IOException e) {
				System.err.println("Cannot read from file "+ filename);
				System.exit(1);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Cannot open file "+ filename);
			System.exit(1);
		}
	}


	public static void main(String argv[]) throws InterruptedException
	{
		if (argv.length < 1)
		{
			System.err.println("Usage: java ParaWebstats <access_log_file> {<access_log_file>}");
			System.exit(1);
		}
		
		ParaWebstats ws = new ParaWebstats("ParaWebstats.java");
		List<Thread> threads = new ArrayList<Thread>();
		for (int i = 0; i < argv.length; i++)
		{
			threads.add(new Thread(new ProcessFile(ws, argv[i])));
			threads.get(i).start();
		}
		for (int i = 0; i < argv.length; i++)
		{
			threads.get(i).join();
		}
		
		ws.print_webstats();
		System.exit(0);
	}
}



/* vim: set ts=4: */
