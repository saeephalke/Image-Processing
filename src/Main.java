import images.*;

/**
 * uses main method to run methods from the Menu class
 */
import java.util.*;
public class Main {
	
	/**
	 * creates a Menu object and runs the setImageFile() and showMenu() methods from the Menu class
	 * @param args list of strings provided in terminal
	 */
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.setImageFile();		
		menu.showMenu();
	}
}