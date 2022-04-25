import javax.swing.JLabel;
import javax.swing.JPanel;

public class App extends JPanel {
	
// Properties
	private String name;
	private String category;
	private String store;
	private String releaseYear;
	private String description;
	
// Constructors
	
	public App(String name, String category, String store, String releaseYear, String description) {
		this.name = name;
		this.category = category;
		this.store = store;
		this.releaseYear = releaseYear;
		this.description = description;
		
		
	}
	
// Methods 
	
	public String displayBasic() {
		String s = name + ": \n\n" + description;
		return s;
	}
	
	public String displayExtended() {
		String s = name + ":  " + category + " " + store + " " + releaseYear + " " + description;
		return s;
	}
}