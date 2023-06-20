package animatedSpace; // Define the package name where this class is located.

import java.util.ArrayList; // Import ArrayList for handling lists of movements.
import java.awt.*; // Import AWT classes for graphics.

/**
 * The DeathStar class represents an animated Death Star object in space.
 * It extends the AnimatedObject class.
 */
public class DeathStar extends AnimatedObject {

	public int x; // X coordinate of the Death Star.
	public int y; // Y coordinate of the Death Star.
	private int times; // Counter for timing in the animation.
	private ArrayList moveList; // List of movements for the animation.
	private Movement current; // Current movement in animation.
	private int i; // Counter for iterating through movements.
	private Graphics2D g2; // Graphics object for drawing.
	private GradientPaint grad; // Gradient paint for the main body.
	private GradientPaint grad2; // Gradient paint for the secondary body.

	/**
	 * Constructor that initializes the DeathStar with position coordinates.
	 * 
	 * @param xpos X Position
	 * @param ypos Y Position
	 */
	public DeathStar(int xpos, int ypos) {
		x = xpos;
		y = ypos;
		moveList = new ArrayList();
		times = 0;
		i = 0;
	}

	/**
	 * Implements the move method from AnimatedObject.
	 * Handles the movement of the Death Star in the animation.
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

				switch (current.type) {
					case "moveUp":
						y = y - current.speed;
						break;
					case "moveDown":
						y = y + current.speed;
						break;
					case "moveLeft":
						x = x - current.speed;
						break;
					case "moveRight":
						x = x + current.speed;
						break;
					case "pause":
						// Do nothing on pause.
						break;
				}
			} else {
				i++;
				times = 0;
			}

		} catch (NullPointerException | IndexOutOfBoundsException e) {
			System.out.println("You need to enter movements for an object!");
		}
	}

	/**
	 * Adds a new movement that the Death Star will perform.
	 * The movements are performed in sequence repeatedly.
	 * 
	 * @param type The type of movement (e.g. "moveUp", "moveDown").
	 * @param t    The duration of this movement.
	 * @param s    The speed of the motion.
	 */
	public void addMovement(String type, int t, int s) {
		Movement move = new Movement(type, t, s);
		moveList.add(move);
		current = (Movement) moveList.get(0);
	}

	/**
	 * Implements the draw method from AnimatedObject.
	 * Handles drawing the Death Star object on the screen.
	 * 
	 * @param g The Graphics object used for drawing.
	 */
	public void draw(Graphics g) {
		grad = new GradientPaint(x, y, Color.white, x + 200, y + 200, Color.black, true);
		grad2 = new GradientPaint(x + 65, y + 10, Color.black, x + 135, y + 60, Color.white, true);

		g2 = (Graphics2D) g;
		g2.setPaint(grad);
		g2.fillOval(x, y, 200, 200);
		g2.setPaint(grad2);
		g2.fillOval(x + 65, y + 10, 70, 50);
		g2.drawArc(x, y + 80, 205, 60, 20, 160);

		g2.setColor(Color.black);
		g2.fillRect(x + 100, y + 120, 100, 2);
		g2.fillRect(x + 130, y + 160, 50, 50);
		g2.fillRect(x + 140, y + 150, 50, 20);
		g2.fillRect(x + 100, y + 180, 100, 10);
		g2.fillRect(x + 100, y + 130, 100, 2);

		g2.setColor(Color.black);
		g2.fillOval(x + 100, y + 35, 2, 2);
	}
}
