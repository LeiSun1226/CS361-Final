package dishes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * Builder for data set of dishes
 */
public class DishData {
	
	public ArrayList<BreakfastDish> breakfast = new ArrayList<BreakfastDish>();
	
	public ArrayList<LunchDish> lunch = new ArrayList<LunchDish>();
	
	public ArrayList<DinnerDish> dinner = new ArrayList<DinnerDish>();
	
	public ArrayList<SnackDish> snack = new ArrayList<SnackDish>();
	
	public Random rand = new Random();
	
	/**
	 * Constructor for dish data set
	 */
	public DishData() {
		this.breakfast.add(new BreakfastDish("Breakfast Taco", 277, 104));
		this.breakfast.add(new BreakfastDish("Granola Yogurt Bowl", 355, 261));
		this.breakfast.add(new BreakfastDish("Sweet Potato And Chorizo Hash", 383, 191));
		this.breakfast.add(new BreakfastDish("Almond Poppy Seed Muffins", 408, 113));
		this.breakfast.add(new BreakfastDish("Fried Egg Sandwiches", 367, 183));
		//Collections.sort(this.breakfast, compareCalories);
		
		this.lunch.add(new LunchDish("Tuna Sandwich", 438, 210));
		this.lunch.add(new LunchDish("Garlic Chicken Pizza", 355, 196));
		this.lunch.add(new LunchDish("Cranberry Pecan Chicken Salad", 580, 224));
		this.lunch.add(new LunchDish("Buffalo Chicken Wrap", 626, 355));
		this.lunch.add(new LunchDish("Chicken Burger", 535, 207));
		//Collections.sort(this.lunch, compareCalories);
		
		this.dinner.add(new DinnerDish("Mexican Beef Stew", 572, 506));
		this.dinner.add(new DinnerDish("Lasagna", 602, 385));
		this.dinner.add(new DinnerDish("Spaghetti And Meatballs", 801, 505));
		this.dinner.add(new DinnerDish("Chicken Pasta", 396, 224));
		this.dinner.add(new DinnerDish("Lasagna", 602, 385));
		//Collections.sort(this.dinner, compareCalories);
		
		this.snack.add(new SnackDish("Apple Crips", 227, 141));
		this.snack.add(new SnackDish("Oatmeal Cookies", 135, 32));
		this.snack.add(new SnackDish("Strawberries And Cream Pie", 345, 164));
		this.snack.add(new SnackDish("Kettle Corn", 98, 18));
		this.snack.add(new SnackDish("Roasted Chickpeas", 119, 28));
		this.snack.add(new SnackDish("Chocolate Chip Cookies", 148, 30));
		this.snack.add(new SnackDish("Kettle Corn", 98, 18));
		this.snack.add(new SnackDish("Apple Chips", 48, 19));
		this.snack.add(new SnackDish("Onigiri", 232, 142));
		this.snack.add(new SnackDish("Pecan Nuts", 100, 15));
		//Collections.sort(this.snack, compareCalories);
	}
	
	/**
	 * Gives random dish of a specific type
	 * 
	 * @param index index of dish type requested
	 * @return random dish from list of dishes of desired type
	 */
	public Dish getRandDish(int index) {
		Dish d;
		switch (index) {
			case 0:
				d = this.breakfast.get(rand.nextInt(breakfast.size()));
				return new BreakfastDish(d.name, d.calories, d.weight);
			case 2:
				d = this.lunch.get(rand.nextInt(lunch.size()));
				return new LunchDish(d.name, d.calories, d.weight);
			case 4:
				d = this.dinner.get(rand.nextInt(dinner.size()));
				return new DinnerDish(d.name, d.calories, d.weight);
			default:
				d = this.snack.get(rand.nextInt(snack.size()));
				return new SnackDish(d.name, d.calories, d.weight);
		}
	}
	
//	public int averageCalorie(ArrayList<Dish> dishes) {
//		int total = 0;
//		for (Dish d : dishes) total += d.calories;
//		return dishes.size() == 0 ? 0 : total / dishes.size();
//	}
//	
//	public Comparator<Dish> compareCalories = new Comparator<Dish>(){
//	    public int compare(Dish d1, Dish d2){
//	        if(d1.calories == d2.calories)
//	            return 0;
//	        return d1.calories < d2.calories ? -1 : 1;
//	    }
//	};
	
}
