package animatedSpace;
import java.awt.*;

/**
 * This class is basically a variable that stores stars.
 */
public class Star {

	public int x;
	public int y;
	
	/**
	 * When a star is created with this method in the Space class, it
	 * will use the given position.
	 * @param xpos X Position
	 * @param ypos Y Position
	 */
	public Star(int xpos, int ypos){
		this.x=xpos;
		this.y=ypos;
	}
	
	/**
	 * When a star is created with this method in the Space class, it will
	 * randomly calculate its position based on the size of the screen.
	 * @param displaySize Size of the Screen
	 */
	public Star(Dimension displaySize){
		this.x=(int)(Math.random()*displaySize.width);
		this.y=(int)(Math.random()*displaySize.height);
	}
}
