package dishes;

public abstract class Dish {
	
	 public String name;
	 
	 public int calories;
	 
	 public int weight;
	 
	 public Dish(String name, int calories, int weight) {
		 this.name = name;
		 this.calories = calories;
		 this.weight = weight;
	 }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        
        if (obj.getClass() != this.getClass()) return false;

        final Dish other = (Dish) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name))
            return false;
        return true;
    }
}
