package animatedSpace;

import java.awt.*;

/**
 * Represents a star in the animated space.
 * A star is a point in the space with an x and y coordinate.
 */
public class Star {

	// x and y coordinates of the star.
	public int x;
	public int y;

	/**
	 * Constructs a star at a specific position.
	 *
	 * @param xpos X Position of the star.
	 * @param ypos Y Position of the star.
	 */
	public Star(int xpos, int ypos) {
		// Set the x and y coordinates to the specified positions.
		this.x = xpos;
		this.y = ypos;
	}

	/**
	 * Constructs a star with a random position within the screen.
	 * The position is calculated based on the size of the screen.
	 *
	 * @param displaySize Size of the screen.
	 */
	public Star(Dimension displaySize) {
		// Set the x coordinate to a random value between 0 and the screen width.
		this.x = (int) (Math.random() * displaySize.width);

		// Set the y coordinate to a random value between 0 and the screen height.
		this.y = (int) (Math.random() * displaySize.height);
	}
}
