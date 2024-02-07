
public class Processing {
private APImage image;

public Processing() {
  Menu gettingImage = new Menu();
  image = gettingImage.giveImage();
}

public Processing(String s) {
  Menu gettingImage = new Menu(s);
  image = gettingImage.giveImage();
}
/**
* Can use any image
*/
//Convert an image to BW (Christina)
public convertBW () {
  image.draw();
  for (Pixel little : image) {
    //take the average of the colors
    int average = (little.getRed() + little.getBlue() + little.getGreen())/3;
    if (average < 128) {
      //set it to black
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
  image.draw();

}

  
/*
* Convert image to grayscale (Christina)
*/
public convertGray () {
  for (Pixel p : image) {
    int average = (p.getRed() + p.getBlue() + p.getGreen())/3;
    p.setRed(average);
    p.setGreen(average);
    p.setBlue(average);
  }
}
  
//Convert image to luminance grayscale (Christina)
public lumGray () {
  for (Pixel p : image) {
    int average = (p.getRed() * 0.299 + p.getBlue() * .114 + p.getGreen() * .587);
    p.setRed(average);
    p.setGreen(average);
    p.setBlue(average);
  }
}
  
* Rotate left 90, right 90, 180 (Isha)
* Convert to sepia (Isha)
* Darken/brighten image (Felicia)
//Do color filtering (Christina)
public colorFilter (int red, int green, int blue) {
  for (Pixel p : image) {
    if (p.getRed() + red > 255) {
      p.setRed(255);
    }
    else if (p.getRed() + red < 0) {
      p.setRed(0);
    }
    else {
      p.setRed(p.getRed + red);
    }
    if (p.getGreen() + green > 255) {
      p.setGreen(255);
    }
    else if (p.getGreen() + green < 0) {
      p.setGreen(0);
    }
    else {
      p.setGreen(p.getGreen + green);
    }
    
    if (p.getBlue() + blue > 255) {
      p.setBlue(255);
    }
    else if (p.getBlue() + blue < 0) {
      p.setBlue(0);
    }
    else {
      p.setBlue(p.getBlue + blue);
    }
    
    
  }
}

  
* Posterize image  (Saee)
* Convert to photographic negative (Saee)
* Sharpen (Saee)
* Blur (Saee)
* Shrink (Felicia)
* Enlarge (Felicia)
* VIDEO EDITING (Together)
* SLIDESSSSS (Together)
*/

  
}
