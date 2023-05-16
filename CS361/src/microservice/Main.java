package microservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static ArrayList<Recipe> recipe;
	
	public static String NOTEXIST = "Recipe does not exists.";
	
	public static void main (String args[]) throws InterruptedException {
		File request = new File("req-service.txt");
		//File add = new File("add-service.txt");
		File receive = new File("rcv-service.txt");
		recipe = buildRecipe();
		while(true) {
			tryLookUp(request, receive);
			//tryAddRecipe(add);
			Thread.sleep(200);
		}
	}
	
	
	
	public static ArrayList<Recipe> buildRecipe() {
		ArrayList<Recipe> r = new ArrayList<Recipe>();
		r.add(new Recipe("Bread", new ArrayList<String>(Arrays.asList("wheat powder: 10g", "water: 10g", "sugar: 2g"))));
		r.add(new Recipe("Apple Pie", new ArrayList<String>(Arrays.asList("wheat powder: 10g", "apple: 10g", "egg: 2g"))));
		return r;
	}
	
	
	
	
	public static boolean tryLookUp(File req_file, File rsv_file) {
	    try
	    {
	    	BufferedReader br = new BufferedReader(new FileReader(req_file));
	    	String s = br.readLine();
	    	if (s == null) {
	    		br.close();
		        return false;
	    	}
	    	writeFile("", req_file);
	    	writeFile(s + ';' + lookUp(s), rsv_file);
	    	br.close();
	        return true;
	    }
	    catch (IOException err) // Can't access
	    {
	    	return false;
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

	private static String lookUp(String name) {
		for (Recipe r : recipe) {
			if (r.name.equalsIgnoreCase(name)) {
				return String.join(", ", r.ingredients);
			}
		}
		return NOTEXIST;
	}
	
	
	
	
	
	
	public static boolean tryAddRecipe(File file) {
	    try
	    {
	    	BufferedReader br = new BufferedReader(new FileReader(file));
	    	String s = br.readLine();
	    	if (s == null) {
		        return false;
	    	}
	    	addRecipe(s);
	    	writeFile("", file);
	        return true;
	    }
	    catch (IOException err) // Can't access
	    {
	    	return false;
	    }
	}
	
	public static boolean addRecipe(String recipe_string) {
		String[] split = recipe_string.split(";");
		if (split.length < 2) return false;
		recipe.add(new Recipe(split[0], new ArrayList<String>(Arrays.asList(split).subList(1, split.length))));
		return true;
	}

}
