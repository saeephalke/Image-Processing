import images.*;

/**
 * Processes an image provided by the user
 */
public class Processing {
private APImage image;


/**
 * constructor to create a Processing object by initializing processing image
 * @param s file name to access the image file
 */
public Processing(String s) {
  image = new APImage(s);
}

/**
 * returns the image instance variable
 * @return APImage image instance variable
 */
public APImage getImage() {
	return image;
}
/**
 * converts the image to black and white
 * @return the black and white image
*/
//Convert an image to BW (Christina)
public APImage convertBW() {
  image.draw();
  APImage newImage = image.clone();
  for (Pixel little : newImage) {
    //take the average of the colors
    int average = (little.getRed() + little.getBlue() + little.getGreen())/3;
    if (average < 128) {
      //set the same Pixel to black
      little.setRed(0);
      little.setGreen(0);
      little.setBlue(0);
    }
    else {
      //set it to white
      little.setRed(255);
      little.setGreen(255);
      little.setBlue(255);
    }
  }
  return newImage;

}

  
/**
 * converts the image to grayscale
 * @return the grayscale image
*/
public APImage convertGray() {
  APImage ret = image.clone();
  for (Pixel p : ret) {
    int average = (p.getRed() + p.getBlue() + p.getGreen())/3;
    p.setRed(average);
    p.setGreen(average);
    p.setBlue(average);
  }
  return ret;
}

/**
 * converts the image to luminance grayscale
 * @return the luminance grayscale image
*/
//Convert image to luminance grayscale (Christina)
public APImage lumGray() {
	//an image is not an array of pixels, you can't traverse it like this
  APImage ret = image.clone();
  int width = ret.getWidth();
  int height = ret.getHeight();
  for(int w = 0; w < width; w++) {
		for(int h = 0; h < height; h++) {
			Pixel p = ret.getPixel(w, h);
			int average = (int)(p.getRed() * 0.299 + p.getBlue() * .114 + p.getGreen() * .587);
		    p.setRed(average);
		    p.setGreen(average);
		    p.setBlue(average);
	}
  }
  return ret;
}
  
/**
 * rotates the image left by 90 degrees
 * @return the rotated left image
*/
//Rotate left 90, right 90, 180 (Isha)
public APImage rotateL() {
	//APImage ret = image.clone();
	int newheight = image.getWidth();
        int newwidth = image.getHeight();
        APImage ret = new APImage(newwidth, newheight);
		    
	for (int i = 0; i < ret.getHeight(); i++) {
		 for (int j = 0; j < ret.getWidth(); j++) {               
		         ret.setPixel(j, ret.getHeight()-1-i, image.getPixel(i, j));        
		 }
	 }
	return ret;
}

/**
 * rotates the image right by 90 degrees
 * @return the rotated right image
*/
public APImage rotateR() { 
	int newheight = image.getWidth();
        int newwidth = image.getHeight();
        APImage ret = new APImage(newwidth, newheight);
	
	for (int i = 0; i < ret.getHeight(); i++) {
		 for (int j = 0; j < ret.getWidth(); j++) {               
		        ret.setPixel(ret.getWidth() - j - 1, i, image.getPixel(i, j));            
		 }
	}
	return ret;
	
}
	

/**
 * flip the image 180 degrees
 * @return the flipped image
*/
public APImage rotateFlip() {
        APImage ret = new APImage(image.getWidth(), image.getHeight());
	for (int i = ret.getWidth() - 1; i >= 0; i--) {
		 for (int j = ret.getHeight()-1; j >= 0; j--) {               
		         ret.setPixel(i, j, image.getPixel(image.getWidth()-i-1, image.getHeight()-j-1));         
		 }
	}
	return ret;
}

/**
 * apply a sepia effect to the image
 * @return the sepia image
*/
// Convert to sepia (Isha)
public APImage sepia() {
	APImage ret = convertGray();
	for(Pixel p: ret) {
		if(p.getRed() < 63) {
		  p.setRed((int)(p.getRed() * 1.1));
		  p.setBlue((int)(p.getBlue() * 0.9));
		} else if (p.getRed() < 192) {
		  p.setRed( (int)(p.getRed() * 1.15));
		   p.setBlue((int)(p.getBlue() * 0.85));
		} else {
		   p.setRed(Math.min((int)(p.getRed() * 1.08), 255));
		   p.setBlue((int)(p.getBlue() * 0.93));
		}
	}
	return ret;
}
	
/**
 * darkens the image by a factor
 * @param factor - the darkening factor
 * @return the darkened image
*/
// Darken/brighten image (Felicia)
public APImage darken(int factor) {
        APImage ret = image.clone();
        //ret.draw();
        for(Pixel p: ret) {
            int darkRed = p.getRed()-factor;
            int darkGreen = p.getGreen()-factor;
            int darkBlue = p.getBlue()-factor;
            p.setRed(Math.max(0, darkRed));
            p.setGreen(Math.max(0, darkGreen));
            p.setBlue(Math.max(0, darkBlue));
            // p.setRed(darkRed);
        	// p.setGreen(darkGreen);
        	// p.setBlue(darkBlue);
        }
        return ret;
}
   
/**
 * brightens the image by a factor
 * @param factor - the brightening factor
 * @return the brightened image
*/
public APImage brighten(int factor) {
    APImage ret = image.clone();
    //ret.draw();
    for(Pixel p: ret) {
        int brightRed = p.getRed()+factor;
        int brightGreen = p.getGreen()+factor;
        int brightBlue = p.getBlue()+factor;
        p.setRed(Math.min(255, brightRed));
        p.setGreen(Math.min(255, brightGreen));
        p.setBlue(Math.min(255, brightBlue));
        // p.setRed(darkRed);
    	// p.setGreen(darkGreen);
    	// p.setBlue(darkBlue);
    }
    return ret;
}

/**
 * filter the image by one or more RGB values
 * @param red - red RGB factor
 * @param green - green RGB factor
 * @param blue - blue RGB factor
 * @return the color filtered image
*/	
//Do color filtering (Christina)
public APImage colorFilter (int red, int green, int blue) {
	APImage ret = image.clone();
	int width = ret.getWidth();
	int height = ret.getHeight();
	
	for(int w = 0; w <  width; w++) {
		for(int h = 0; h < height; h++) {
			Pixel p = ret.getPixel(w, h);
			if (p.getRed() + red > 255) {
			      p.setRed(255);
			    }
			    else if (p.getRed() + red < 0) {
			      p.setRed(0);
			    }
			    else {
			      p.setRed(p.getRed() + red);
			    }
			    if (p.getGreen() + green > 255) {
			      p.setGreen(255);
			    }
			    else if (p.getGreen() + green < 0) {
			      p.setGreen(0);
			    }
			    else {
			      p.setGreen(p.getGreen() + green);
			    }
			    
			    if (p.getBlue() + blue > 255) {
			      p.setBlue(255);
			    }
			    else if (p.getBlue() + blue < 0) {
			      p.setBlue(0);
			    }
			    else {
			      p.setBlue(p.getBlue() + blue);
			    }
		}
	}
	return ret;
}


/**
 * posterizes image
 * @return the posterized image
*/
/* Posterize image  (Saee)
 */
public APImage posterize() {
	int width = image.getWidth();
	int height = image.getHeight();
	APImage i = new APImage(width, height);
	
	int randomRedOne = (int)(Math.random()*256);
	int randomGreenOne = (int)(Math.random()*256);
	int randomBlueOne = (int)(Math.random()*256);
	
	int randomRedTwo = (int)(Math.random()*256);
	int randomGreenTwo = (int)(Math.random()*256);
	int randomBlueTwo = (int)(Math.random()*256);
	
	for(int w = 0; w < width; w++) {
		for(int h = 0; h < height; h++) {
			Pixel p = image.getPixel(w, h);
			if(p.getBlue() <= 100 && p.getRed() <= 100 && p.getGreen() <= 100) {
				i.setPixel(w, h, new Pixel(randomRedOne, randomGreenOne, randomBlueOne));
			} else {
				i.setPixel(w, h, new Pixel(randomRedTwo, randomGreenTwo, randomBlueTwo));
			}
		}
	}
	return i;
	
}

/**
 * converts the image to photographic negative
 * @return the photographic negative image
*/
/* Convert to photographic negative (Saee)
 */
public APImage photographicNegative() {
	APImage ret =  convertGray();
	
	for(Pixel p : ret) {
		p.setRed(255 - p.getRed());
		p.setBlue(255 - p.getBlue());
		p.setGreen(255 - p.getGreen());
	}
	
	return ret;
	
}

/**
 * sharpen image
 * @return the sharpened image
*/
/* Sharpen (Saee)
 */
public APImage sharpen(int threshold, int degree) {
	int width = image.getWidth();
	int height = image.getHeight();
	
	APImage ret = new APImage(width, height);
	
	for(int w = 1; w < width; w++) {
		for(int h = 0; h < height - 1; h++) {
			Pixel curr = image.getPixel(w, h);
			Pixel left = image.getPixel(w - 1, h);
			Pixel bottom = image.getPixel(w, h +1);
			
			int currAve = (curr.getRed() + curr.getBlue() + curr.getGreen())/3;
			int leftAve = (left.getRed() + left.getBlue() + left.getGreen())/3;
			int bottomAve = (bottom.getRed() + bottom.getBlue() + bottom.getGreen())/3;
			
			Pixel changingPixel = ret.getPixel(w, h); 
			if(Math.abs(currAve - leftAve) > threshold || Math.abs(currAve - bottomAve) > threshold) {
				changingPixel.setRed(Math.max(0, curr.getRed() - degree));
				changingPixel.setGreen(Math.max(0, curr.getGreen() - degree));
				changingPixel.setBlue(Math.max(0, curr.getBlue() - degree));
			} else {
				changingPixel.setRed(curr.getRed());
				changingPixel.setGreen(curr.getGreen());
				changingPixel.setBlue(curr.getBlue());
			}
		}
	}
	return ret;
}

/**
 * blur image
 * @return the blurred image
*/
public APImage blur() {
	int width = image.getWidth();
	int height = image.getHeight();
	APImage ret = new APImage(width, height);
	
	for(int w = 0; w < width; w++) {
		for(int h = 0; h < height; h++) {
			int sumRed = 0;
			int sumGreen = 0;
			int sumBlue = 0;
			int pixelsAccounted = 0;
			
			if(w > 0) {
				sumRed += image.getPixel(w-1, h).getRed();
				sumBlue += image.getPixel(w-1, h).getBlue();
				sumGreen += image.getPixel(w-1, h).getGreen();
				pixelsAccounted++;
			}
			
			if(w < width-1) {
				sumRed += image.getPixel(w+1, h).getRed();
				sumBlue += image.getPixel(w+1, h).getBlue();
				sumGreen += image.getPixel(w+1, h).getGreen();
				pixelsAccounted++;
			}
			
			if(h > 0) {
				sumRed += image.getPixel(w, h-1).getRed();
				sumBlue += image.getPixel(w, h-1).getBlue();
				sumGreen += image.getPixel(w, h-1).getGreen();
				pixelsAccounted++;
			}
			
			if(h < height-1) {
				sumRed += image.getPixel(w, h+1).getRed();
				sumBlue += image.getPixel(w, h+1).getBlue();
				sumGreen += image.getPixel(w, h+1).getGreen();
				pixelsAccounted++;
			}
			
			int redAverage = sumRed/pixelsAccounted;
			int greenAverage = sumGreen/pixelsAccounted;
			int blueAverage = sumBlue/pixelsAccounted;
			
			Pixel curr = ret.getPixel(w, h);
			curr.setRed(redAverage);
			curr.setGreen(greenAverage);
			curr.setBlue(blueAverage);
		}
	}
	
	return ret;
}

/**
 * shrinks the image by a factor
 * @param factor - the shrinking factor
 * @return the shrunken image
*/
//Shrink (Felicia)
public APImage shrink(int factor) {
	int shrunkenWidth = (image.getWidth()/factor);
	int shrunkenHeight = (image.getHeight()/factor);
	APImage shrunkenImage = new APImage(shrunkenWidth, shrunkenHeight);
	for(int i = 0; i < shrunkenWidth; i++) {
		for(int j = 0; j < shrunkenHeight; j++) {
			shrunkenImage.setPixel(i, j, image.getPixel(i*factor, j*factor));
		}
	}
	
	return shrunkenImage;
}

/**
 * enlarges the image by a factor
 * @param factor - the enlarging factor
 * @return the enlarged image
*/
//Enlarge (Felicia)
public APImage enlarge(int factor) {
	int enlargedWidth = (image.getWidth()*factor);
	int enlargedHeight = (image.getHeight()*factor);
	APImage enlargedImage = new APImage(enlargedWidth, enlargedHeight);
	for(int i = 0; i < enlargedWidth; i++) {
		for(int j = 0; j < enlargedHeight; j++) {
			enlargedImage.setPixel(i, j, image.getPixel(i/factor, j/factor));
		}
	}
	
	return enlargedImage;
}
/*
* VIDEO EDITING (Together)
* SLIDESSSSS (Together)
*/

  
}
