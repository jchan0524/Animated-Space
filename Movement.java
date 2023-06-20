package animatedSpace;

/**
 * The Movement class is used for storing the properties
 * of the movements of the animated objects.
 */
public class Movement {

	// The number of iterations for which the movement should last.
	public int time;

	// The type of movement (e.g., "moveLeft", "moveRight", etc.).
	public String type;

	// The speed of the movement (number of iterations to skip).
	public int speed;

	/**
	 * Constructs a Movement object with the specified type, time, and speed.
	 * 
	 * @param ty The type of movement, which is a String defined in the Animated
	 *           Object's class.
	 * @param t  The number of iterations for which the movement should last.
	 * @param s  The speed of the movement (number of iterations to skip).
	 */
	public Movement(String ty, int t, int s) {
		time = t;
		type = ty;
		speed = s;
	}
}
