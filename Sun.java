package animatedSpace;

/**
 * Represents a sun in the animated space.
 * The sun has x and y coordinates representing its position and a diameter.
 * Note that the Space class provides methods for adding suns,
 * so this class may not necessarily need to be used directly in the main
 * program.
 */
public class Sun {

	// x and y coordinates of the sun.
	public int x;
	public int y;

	// The diameter of the sun.
	public int d;

	/**
	 * Constructs a Sun at the specified position with a random diameter.
	 *
	 * @param xpos X Position of the sun.
	 * @param ypos Y Position of the sun.
	 */
	public Sun(int xpos, int ypos) {
		this.x = xpos;
		this.y = ypos;
		// Randomly calculate the diameter of the sun (between 0 and 50).
		this.d = (int) (Math.random() * 50);
	}

	/**
	 * Constructs a Sun at the specified position with the specified diameter.
	 *
	 * @param xpos     X Position of the sun.
	 * @param ypos     Y Position of the sun.
	 * @param diameter Diameter of the sun.
	 */
	public Sun(int xpos, int ypos, int diameter) {
		this.x = xpos;
		this.y = ypos;
		this.d = diameter;
	}

	/**
	 * Constructs a Sun with random position and diameter.
	 */
	public Sun() {
		// Randomly calculate the x position of the sun (between 0 and 500).
		this.x = (int) (Math.random() * 500);
		// Randomly calculate the y position of the sun (between 0 and 500).
		this.y = (int) (Math.random() * 500);
		// Randomly calculate the diameter of the sun (between 0 and 50).
		this.d = (int) (Math.random() * 50);
	}
}
