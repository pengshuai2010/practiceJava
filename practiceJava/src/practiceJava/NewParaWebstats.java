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

public class NewParaWebstats extends ParaWebstats
{
	
	/**
	  Webstats(): Initializes the webstats structure.
	  @param new_program_name This programs name.
	  @return none
	*/
	public NewParaWebstats(String new_program_name)
	{
		super(new_program_name);
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
		ParaWebstats ws = new ParaWebstats(filename);
		ws.process_file(filename);
	}
	
	private void merge_webstats(ParaWebstats ws) {
//		webstats.failed_gets += webstats_ptr->failed_gets;
//		webstats.local_bytes += webstats_ptr->local_bytes;
//		webstats.local_failed_gets += webstats_ptr->local_failed_gets;
//		webstats.local_gets += webstats_ptr->local_gets;
//		webstats.total_bytes += webstats_ptr->total_bytes;
//		webstats.total_gets += webstats_ptr->total_gets;
		super.increaseFailed_gets(ws.getFailed_gets());
		super.increaseLocal_bytes(ws.getLocal_bytes());
		super.increaseLocal_failed_gets(ws.getLocal_failed_gets());
		super.increaseLocal_gets(ws.getLocal_gets());
		super.increaseTotal_bytes(ws.getTotal_bytes());
		super.increaseTotal_gets(ws.getTotal_gets());
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

