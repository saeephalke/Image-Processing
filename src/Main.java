import images.*;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.setImageFile();
		Scanner s = new Scanner(System.in);
		
		menu.showMenu();

	}
}