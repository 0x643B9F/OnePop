import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Search {
	static ArrayList<App> appsList= new ArrayList<App>();
	
	public static void getApps() {
		String name;
		String category;
		String store;
		int releaseYear;
		String description = null;
		try {
			Scanner fileIn = new Scanner(new File("AppDatabase.txt"));
			while(fileIn.hasNextLine()) {
				while(!fileIn.nextLine().equals("")) {
					name = fileIn.nextLine();
					category = fileIn.nextLine();
					store = fileIn.nextLine();
					releaseYear = Integer.parseInt(fileIn.nextLine());
					while(!fileIn.nextLine().equals("-stop-")) {
						description += fileIn.nextLine();
					}
					
					App newApp = new App(name, category, store, releaseYear, description);
					appsList.add(newApp);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		appsList.get(0).displayExtended();
	}
}