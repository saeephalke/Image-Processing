import images.*;
import java.util.*;
import java.util.Scanner;
public class Menu {
	private String imageFile;
	private final static String[] availableImages = {"smokey.jpg", "swan.jpg", "seagull.jpg", "redMotorcycle.jpg", 
	                                           "koala.jpg", "butterfly1.jpg", "arch.jpg"};
	private final static String[] availableFunctions = {"View Original", "Black and White", "Grayscale", "Luminance Grayscale", "Rotate Right", "Rotate Left", "Rotate 180", "Sepia",
			"Darken", "Brighten", "Color Filtering", "Posterize", "Photographic Negative", "Sharpening", "Blurring", "Shrinking", "Enlargen"};
	
	/**
	 * creates a Menu object, imageFile is always initially set to smokey.jpg
	 */
	public Menu() {
		imageFile = "smokey.jpg";
	}
	
	/**
	 * method sets the image file based on what index user chooses based on what's available in the availableImages instance variable
	 */
	
	public void setImageFile() {
		Scanner s = new Scanner(System.in);
		System.out.println("Please choose an index, by default the file you'll use is smokey.jpg");
		System.out.println("If you enter an invalid number, you'll be using smokey.jpg");
		System.out.println(printAvailableActions(availableImages));
		
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
	
	/**
	 * method runs a sentinel while loop that shows menu options of image processing, user can choose indexes avaiable in the availableFunctions list
	 * to process images, loop stops when the user types "stop"
	 */
	
	public void showMenu() {
		Processing p = new Processing(imageFile);
		APImage image;
		Scanner s = new Scanner(System.in);
		
		String sentinel = "go";
		
		while(!sentinel.equals("stop")) {
		
			System.out.println("What would you like to do with your image?");
			System.out.println(printAvailableActions(availableFunctions));
			
			System.out.print("Enter index here: ");
			String index = s.nextLine();
			
			try {
				int i = Integer.parseInt(index);
				
				if(i >= 0 && i < availableFunctions.length) {
					if(i == 0) {
						System.out.println("Showing original image.");
						image = p.getImage();
						image.draw();
					} else if(i == 1) {
						System.out.println("Showing black and white image.");
						image = p.convertBW();
						image.draw();
					} else if(i == 2) {
						System.out.println("Showing grayscale image.");
						image = p.convertGray();
						image.draw();
					} else if(i == 3) {
						System.out.println("Showing luminance grayscale image.");
						image = p.lumGray();
						image.draw();
					} else if(i == 4) {
						System.out.println("Showing image rotated right.");
						image = p.rotateR();
						image.draw();
					} else if(i == 5) {
						System.out.println("Showing image rotated left.");
						image = p.rotateL();
						image.draw();
					} else if(i == 6) {
						System.out.println("Showing image rotated 180.");
						image = p.rotateFlip();
						image.draw();
					} else if (i == 7) {
						System.out.println("Showing sepia image.");
						image = p.sepia();
						image.draw();
					} else if(i == 8) {
						System.out.println("How much do you want to darken the image?");
						System.out.println("Enter a number: ");
						String factor = s.nextLine();
						
						try {
							int f = Integer.parseInt(factor);
							System.out.println("Showing darkened image.");
							image = p.darken(f);
							image.draw();
							
						} catch (Exception e) {
							System.out.println("Not a valid factor");
						}
					} else if(i == 9) {
						System.out.println("How much do you want to brighten the image?");
						System.out.println("Enter a number: ");
						String factor = s.nextLine();
						
						try {
							int f = Integer.parseInt(factor);
							System.out.println("Showing brighten image.");
							image = p.brighten(f);
							image.draw();
							
						} catch (Exception e) {
							System.out.println("Not a valid factor");
						}
					} else if (i == 10) {
						System.out.println("Choosing color filtering");
						System.out.println("Pick red value (number): ");
						String red = s.nextLine();
						System.out.println("Pick green value (number): ");
						String green = s.nextLine();
						System.out.println("Pick blue value (number): ");
						String blue = s.nextLine();
						
						try {
							int r = Integer.parseInt(red);
							int g = Integer.parseInt(green);
							int b = Integer.parseInt(blue);
							System.out.println("Showing color filtered image");
							image = p.colorFilter(r, g, b);
							image.draw();
						} catch (Exception e) {
							System.out.println("Invalid values");
						}
					} else if(i == 11) {
						System.out.println("Showing posterized image.");
						image = p.posterize();
						image.draw();
					} else if (i == 12) {
						System.out.println("Showing photographic negative image.");
						image = p.photographicNegative();
						image.draw();
					} else if (i == 13) {
						System.out.println("By what threshold do you want to sharpen the image?");
						System.out.println("Enter a number: ");
						String threshold = s.nextLine();
						
						System.out.println("By what degree do you want to sharpen the image?");
						System.out.println("Enter a number: ");
						String degree = s.nextLine();
						
						try {
							int t = Integer.parseInt(threshold);
							int d = Integer.parseInt(degree);
							System.out.println("Showing lightened image.");
							image = p.sharpen(t, d);
							image.draw();
							
						} catch (Exception e) {
							System.out.println("Not invalid numbers given");
						}
					} else if(i == 14) {
						System.out.println("Showing blurred image.");
						image = p.blur();
						image.draw();
					} else if(i == 15) {
						System.out.println("How much do you want to shrink the image?");
						System.out.println("Enter a number: ");
						String factor = s.nextLine();
						
						try {
							int f = Integer.parseInt(factor);
							System.out.println("Showing shrunkened image.");
							image = p.shrink(f);
							image.draw();
							
						} catch (Exception e) {
							System.out.println("Not a valid factor");
						}
					} else if(i == 16) {
						System.out.println("How much do you want to enlarge the image?");
						System.out.println("Enter a number: ");
						String factor = s.nextLine();
						
						try {
							int f = Integer.parseInt(factor);
							System.out.println("Showing enlargened image.");
							image = p.enlarge(f);
							image.draw();
							
						} catch (Exception e) {
							System.out.println("Not a valid factor");
						}
					}
				} else {
					System.out.println("Not a valid index");
				}
					
			} catch (Exception e) {
				System.out.println("Not a valid index");
			}
			
			System.out.println("Would you like to stop, type \"stop\", otherwise type something else");
			sentinel = s.nextLine();
		
		}
		System.out.println("Thanks for using our program!");

	}
	
	/**
	 * private helper method used to print a menu with available options
	 * @param actions - list of Strings with available options to a user to choose
	 * @return - a generated menu to print
	 */
	
	private String printAvailableActions(String[] actions) {
		String s = "";
		int index = 0;
		for(String name : actions) {
			s += index + ". " + name + "\n";
			index++;
		}
		return s;
	}
}
