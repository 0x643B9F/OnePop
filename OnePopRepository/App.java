
public class App {
	
// Properties
	private String name;
	private String category;
	private String store;
	private int releaseYear;
	private String description;
	
// Constructors
	
	public App(String name, String category, String store, int releaseYear, String description) {
		this.name = name;
		this.category = category;
		this.store = store;
		this.releaseYear = releaseYear;
		this.description = description;
	}
	
// Methods 
	
	public void displayBasic() {
		System.out.println(name);
		System.out.println(description);
	}
	
	public void displayExtended() {
		System.out.println(name);
		System.out.println("Category: " + category);
		System.out.println(description);
		System.out.println("Store found in: " + store);
		System.out.println("Release Year" + releaseYear);
	}
	
// Getters/Setters	
	/**
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	*/
}
