import images.*;
import java.util.Scanner;
public class Menu {
	private String imageFile;
	private static String[] availableImages = {"smokey.jpg", "swam.jpg", "seagull.jpg", "redMotorcycle.jpg", 
	                                           "koala.jpg", "butterfly1.jpg", "arch.jpg"};
	
	public Menu() {
		imageFile = "smokey.jpg";
	}
	
	public Menu(String s) {
		Scanner sc = new Scanner(System.in);
		while(!isValid(s)) {
			System.out.println("Try another File Name");
			s = sc.nextLine();
			
		}
		imageFile = s;
		
	}
	
	public APImage giveImage() {
		return new APImage(imageFile);
	}
	
	private boolean isValid(String s) {
		for(String file : availableImages) {
			if(file.equals(s)) {
				return true;
			}
		}
		return false;
	}
}
