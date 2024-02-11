import images.*;
import java.util.*;
import java.util.Scanner;
public class Menu {
	private String imageFile;
	private static String[] availableImages = {"smokey.jpg", "swam.jpg", "seagull.jpg", "redMotorcycle.jpg", 
	                                           "koala.jpg", "butterfly1.jpg", "arch.jpg"};
	
	public Menu() {
		imageFile = "smokey.jpg";
	}
	
	
	public void setImageFile() {
		Scanner s = new Scanner(System.in);
		System.out.println("Please choose an index, by default the file you'll use is smokey.jpg");
		System.out.println("If you enter an invalid number, you'll be using smokey.jpg");
		System.out.println(printFileNames());
		
		System.out.print("Enter index here: ");
		String index = s.nextLine();
		
		try{
			int i = Integer.parseInt(index);
			if(i >= 0 && i < availableImages.length) {
				System.out.println("Choosing " + availableImages[i]);
				imageFile = availableImages[i];
			} else {
				System.out.println("This isn't a valid number, so we'll just use smokey.jpg");
			}
		} catch (Exception e) {
			System.out.println("This isn't a number, so we'll just use smokey.jpg");
		}
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
	
	public String printFileNames() {
		String s = "";
		int index = 0;
		for(String name : availableImages) {
			s += index + ". " + name + "/n";
			index++;
		}
		return s;
	}
}
