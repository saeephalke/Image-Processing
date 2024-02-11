import images.*;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.setImageFile();
		Scanner s = new Scanner(System.in);
		
		String sentinel = "go";		
		while(!sentinel.equals("stop")) {
			menu.showMenu();
			
			System.out.println("Would you like to stop, type \"stop\", otherwise type something else");
			sentinel = s.nextLine();
		}
		System.out.println("Thanks for using our program!");

	}
}