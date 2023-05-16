package microservice;

import java.util.ArrayList;

public class Recipe {
	
	public String name;
	
	public ArrayList<String> ingredients;
	
	public Recipe(String name, ArrayList<String> ingredients) {
		this.name = name;
		this.ingredients = ingredients;
	}
}
