package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import dishes.DishData;
import dishes.BreakfastDish;
import dishes.Dish;

public class MainModel {
	
	public static final int DEFAULT_NUM_PEOPLE = 1;
	public static final int DEFAULT_CALORIE = 100;
	public static final int MIN_AVG_CALORIE = 80;
	public static final int MAX_AVG_CALORIE = 1000;

	public int[] meals = new int[6];
	public int numPeople = DEFAULT_NUM_PEOPLE;
	public int calorie = DEFAULT_CALORIE;
	
	public int[] scale_factor = new int[] {2, 1, 3, 1, 3, 1};
	
	public String[] dish_name = new String[] {"Breakfast", "Morning Snack", "Lunch", "Afternoon Snack", "Dinner", "Midnight Snack"};
	
	public DishData dishdata;
	
	/**
	 * Constructor for main program
	 * @param d data set of dishes
	 */
	public MainModel(DishData d) {
		this.dishdata = d;
	}
	
	/**
	 * Checks if meal recommendation can be generated given current condition 
	 * 
	 * @return true if condition is valid, false if not
	 */
	public String isValid() {
		int total = 0;
		for (int i : meals) total += i;
		if (total == 0) 
			return "You have to specify at least one meal you want.";
		if (calorie < total * MIN_AVG_CALORIE || calorie > total * MAX_AVG_CALORIE)
			return String.format("For %d meal(s), you have to specify calorie to be between %d and %d.", 
					total, total * MIN_AVG_CALORIE, total * MAX_AVG_CALORIE);
		return "";
	}
	
	/**
	 * Gives a list of recommended dishes for current condition
	 * 
	 * @param index meal index of desired meal, e.g. 0 for breakfast
	 * @return list of recommended dishes 
	 */
	public ArrayList<Dish> getDish(int index){
		ArrayList<Dish> result = new ArrayList<Dish>();
		if (meals[index] == 0) return result;
		int total = 0;
		for (int i : meals) total += i;
		int score = 0;
		for (int i = 0; i < meals.length; i++) score += meals[i]*scale_factor[i];
		int expected = scale_factor[index] * calorie / score;
		
		while(expected > 0) {
			Dish dish = dishdata.getRandDish(index);
			if (dish.calories > expected) {
				if (dish.calories / 2 > expected && result.size() != 0) {
					
				}
				dish.weight = dish.weight * expected / dish.calories;
				dish.calories = expected;
			}
			boolean picked = false;
			for (Dish d : result) {
				if (d.equals(dish)) {
					d.calories += dish.calories;
					d.weight += dish.weight;
					picked = true;
					break;
				}
			}
			if(!picked) result.add(dish);
			expected -= dish.calories;
		}
		
		return result;
	}
	
	public int calcCalorie(List<Integer> values) throws IOException {
		
	    BufferedWriter writer = new BufferedWriter(new FileWriter("cal.csv"));
	    for (int i : values) {
	    	writer.write(i + "\n");
	    }
	    
	    writer.close();
		
        ProcessBuilder processBuilder = new ProcessBuilder();

        processBuilder.command("C:\\Users\\LENOVO\\AppData\\Local\\Programs\\Python\\Python310\\python.exe", 
        		"-u", "src/external_microservice/calories.py", "0");
        
        try {
        	Process p = processBuilder.start();
        	System.out.println("Successfully called microservice.");
        }
        catch (IOException e) {
            System.out.println("Exception happened when calling microservice.");
            e.printStackTrace();
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String value = sb.toString();
            
            
            return Integer.parseInt(value);
        } catch(IOException e) {
            System.out.println("Exception happened when calling microservice.");
            e.printStackTrace();
            return 0;
        }
	}

}
