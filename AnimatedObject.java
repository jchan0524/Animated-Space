package animatedSpace;
import java.awt.*;

/**
 * This is the abstract class for all animated 
 * objects in the space.  
 */
public abstract class AnimatedObject {
	
	public abstract void move();
	
	public abstract void addMovement(String type, int t, int s);
	
	public abstract void draw(Graphics g);

}
