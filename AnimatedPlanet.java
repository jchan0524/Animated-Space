package animatedSpace; // Define the package name where this class is located.

import java.util.ArrayList; // Import ArrayList for handling lists of objects.
import java.awt.*; // Import the awt package for graphical user interface elements.

/**
 * AnimatedPlanet class represents a planet that can be animated.
 * It extends the AnimatedObject class and thus inherits its structure.
 * It has properties like position, diameter, orbit diameter, and color,
 * and also contains methods to move and draw the planet.
 */
public class AnimatedPlanet extends AnimatedObject {

	// Declare variables for position, times, list of movements, etc.
	public int x;
	public int y;
	private int x0;
	private int y0;
	private int times;
	private ArrayList moveList;
	private Movement current;
	private int i;
	private int d;
	private int orbitD;
	private Color c;

	/**
	 * Constructor that initializes an AnimatedPlanet object with specified
	 * properties.
	 * 
	 * @param xpos     X Position
	 * @param ypos     Y Position
	 * @param diameter Planet Diameter
	 * @param orbitDia Diameter of the Orbit
	 * @param col      Planet Color
	 */
	public AnimatedPlanet(int xpos, int ypos, int diameter, int orbitDia, Color col) {
		x = xpos;
		y = ypos;
		moveList = new ArrayList();
		times = 0;
		i = 0;
		x0 = xpos;
		y0 = ypos;
		d = diameter;
		orbitD = orbitDia;
		c = col;
	}

	/**
	 * Implements the move method from AnimatedObject.
	 * Handles the logic for moving the planet.
	 */
	public void move() {
		try {
			try {
				current = (Movement) moveList.get(i);
			} catch (IndexOutOfBoundsException e) {
				i = 0;
				current = (Movement) moveList.get(i);
				times = 0;
			}
			if (times < current.time) {
				times = times + current.speed;
				// Check the type of movement and update x and y accordingly.
				if (current.type.equals("moveUp")) {
					y = y - current.speed;
				} else if (current.type.equals("moveDown")) {
					y = y + current.speed;
				} else if (current.type.equals("moveLeft")) {
					x = x - current.speed;
				} else if (current.type.equals("moveRight")) {
					x = x + current.speed;
				} else if (current.type.equals("orbit")) {
					x = (int) (x0 + orbitD * Math.cos(times * current.speed * 0.001));
					y = (int) (y0 + orbitD * Math.sin(times * current.speed * 0.001));
				} else if (current.type.equals("pause")) {
					// Do nothing
				}
			} else {
				i++;
				times = 0;
			}
		} catch (NullPointerException e) {
			System.out.println("You need to enter movements for an object!");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("You need to enter movements for an object!");
		}
	}

	/**
	 * Implements the addMovement method from AnimatedObject.
	 * Adds a new movement to the list of movements.
	 * 
	 * @param type The type of movement
	 * @param t    The duration of this movement
	 * @param s    The speed of the motion.
	 */
	public void addMovement(String type, int t, int s) {
		Movement move = new Movement(type, t, s);
		moveList.add(move);
		current = (Movement) moveList.get(i);
	}

	/**
	 * Implements the draw method from AnimatedObject.
	 * Handles drawing the planet object on the screen.
	 * 
	 * @param g The Graphics object used for drawing.
	 */
	public void draw(Graphics g) {
		GradientPaint grad = new GradientPaint(x, y, c, x + d, y + d, Color.black, true);
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(grad);
		g2.fillOval(x, y, d, d);
	}
}
