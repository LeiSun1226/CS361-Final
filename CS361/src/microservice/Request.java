package microservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Request {
	public static void main (String args[]) {
		File request = new File("req-service.txt");
		File receive = new File("rcv-service.txt");
		writeFile("", receive);
		writeFile("Bread", request);
		System.out.printf("Recipe for Bread is %s\n", readFile("Bread", receive));
	}
	
	private static String readFile(String name, File file) {
	    try
	    {
	    	BufferedReader br = new BufferedReader(new FileReader(file));
	    	String s = br.readLine();
	    	if (s == null) {
		        try
		        {
		            Thread.sleep(200); // Sleep a bit
		            return readFile(name, file); // Try again
		        }
		        catch (InterruptedException err2)
		        {
		           return readFile(name, file); // Could not sleep, try again anyway
		        }
	    	}
	    	if (s.split(";")[0].compareTo(name) == 0) {
		    	//System.out.printf("Received '%s' from image-service.\n", s);
	    		return s.split(";")[1];
	    	} else {
	    		return readFile(name, file); // Try again
	    	}
	    }
	    catch (IOException err) // Can't access
	    {
	        try
	        {
	            Thread.sleep(200); // Sleep a bit
	            return readFile(name, file); // Try again
	        }
	        catch (InterruptedException err2)
	        {
	           return readFile(name, file); // Could not sleep, try again anyway
	        }
	    }
	}

	private static boolean writeFile(String info, File file) {
	    try
	    {
	    	PrintWriter writer = new PrintWriter(file);
	    	writer.print(info);
	    	System.out.printf("Wrote '%s' to file <%s>.\n\n", info, file.getName());
	    	writer.close();
	        return true;
	    }
	    catch (IOException err) // Can't access
	    {
	        try
	        {
	            Thread.sleep(200); // Sleep a bit
	            return writeFile(info, file); // Try again
	        }
	        catch (InterruptedException err2)
	        {
	           return writeFile(info, file); // Could not sleep, try again anyway
	        }
	    }
	}
}
