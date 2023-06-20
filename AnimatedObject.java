package animatedSpace; // Define the package name where this class is located.

import java.awt.*; // Import the awt package for graphical user interface elements.

/**
 * AnimatedObject is an abstract class that serves as a template for all
 * animated objects in the space animation.
 * It provides the structure that all concrete animated objects must follow.
 */
public abstract class AnimatedObject {

	/**
	 * Abstract method move that needs to be implemented by subclasses.
	 * This method will handle the logic for moving the animated object.
	 */
	public abstract void move();

	/**
	 * Abstract method addMovement that takes in the type of movement,
	 * duration t, and speed s, and must be implemented by subclasses.
	 *
	 * @param type The type of movement.
	 * @param t    The duration of the movement.
	 * @param s    The speed of the movement.
	 */
	public abstract void addMovement(String type, int t, int s);

	/**
	 * Abstract method draw that takes a Graphics object as an argument.
	 * It must be implemented by subclasses to handle drawing the object
	 * on the screen.
	 *
	 * @param g The Graphics object used for drawing.
	 */
	public abstract void draw(Graphics g);

}
