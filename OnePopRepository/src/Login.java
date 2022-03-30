import java.io.File;
import java.util.Scanner;

public class Login {

	private static boolean userLoggedIn = false;
	
	private static String[] userNames;
	private static String[] passwords;
	
	public static void getUserNames() {
		try {
			Scanner fileIn = new Scanner(new File("loginDatabase.txt"));
			String file = fileIn.nextLine();
			String[] arr = file.split(", ");
			
			userNames = new String[arr.length/2];
			passwords = new String[arr.length/2];
			
			int j = 0;
			for(int i = 0; i < userNames.length; i++) {
				userNames[i] = arr[j];
				passwords[i] = arr[++j];
				j++;
				
				System.out.print(userNames[i] + " ");
				System.out.println(passwords[i]);
				
			}
			fileIn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean loginCheck(String uName, String pWord) {
		int index = findIndex(uName);
		
		if(index == -1) return false;
		
		if(passwords[index].equals(pWord)) {
			userLoggedIn = true;
			return true;
		}
		
		return false;
	}
	
	private static int findIndex(String uName) {
		for(int i = 0; i < userNames.length; i++) {
			if(userNames[i].equals(uName)) {
				return i;
			}
		}
		return -1;
	}
}
