import images.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Processing processer = new Processing();
		APImage original = processer.getImage();
		APImage image = processer.rotateLR();
		//original.draw();
		image.draw();

	}
}