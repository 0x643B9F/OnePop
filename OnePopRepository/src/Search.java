import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Search {
	static ArrayList<App> appsList= new ArrayList<App>();
	
	public static ArrayList<App> search(String s) {
		ArrayList<App> searchResults = new ArrayList<App>();
		for(int i = 0; i < appsList.size(); i++) {
			if(appsList.get(i).displayExtended().contains(s)) {
				searchResults.add(appsList.get(i));
			}
		}
		
		return searchResults;
	}
	
	public static void getApps() {
		String name;
		String category;
		String store;
		String releaseYear;
		String description;
		
		try {
			Scanner fileIn = new Scanner(new File("AppDatabase.txt"));
			while(fileIn.hasNextLine()) {
				do {
					name = fileIn.nextLine();
					category = fileIn.nextLine();
					store = fileIn.nextLine();
					releaseYear = fileIn.nextLine();
					description = fileIn.nextLine();
					
					App newApp = new App(name, category, store, releaseYear, description);
					appsList.add(newApp);
				} while(!fileIn.nextLine().equals(""));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}