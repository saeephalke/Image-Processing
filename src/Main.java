import images.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Processing processer = new Processing();
		APImage image = processer.sharpen(10, 50);
		image.draw();

	}
}