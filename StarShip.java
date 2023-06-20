package animatedSpace;

import java.util.ArrayList;
import java.awt.*;

/**
 * Represents a starship in the animated space.
 * The starship can have different movements and is capable of being drawn as
 * part of an animation.
 */
public class StarShip extends AnimatedObject {

	// x and y coordinates of the starship.
	public int x;
	public int y;

	// A counter for the number of iterations.
	private int times;

	// A list to store different movements of the starship.
	private ArrayList moveList;

	// The current movement of the starship.
	private Movement current;

	// Index to keep track of the current movement in the moveList.
	private int i;

	/**
	 * Constructs a StarShip at the specified position.
	 *
	 * @param xpos X Position of the starship.
	 * @param ypos Y Position of the starship.
	 */
	public StarShip(int xpos, int ypos) {
		x = xpos;
		y = ypos;
		moveList = new ArrayList();
		times = 0;
		i = 0;
	}

	/**
	 * Part of the animation, this method moves the starship on each iteration.
	 */
	public void move() {
		try {
			try {
				// Get the current movement from the list.
				current = (Movement) moveList.get(i);
			} catch (IndexOutOfBoundsException e) {
				// Reset the index and times if at the end of the moveList.
				i = 0;
				current = (Movement) moveList.get(i);
				times = 0;
			}

			if (times < current.time) {
				times = times + current.speed;
				// Move the starship based on the type of movement.
				if (current.type.equals("moveUp")) {
					y = y - current.speed;
				} else if (current.type.equals("moveDown")) {
					y = y + current.speed;
				} else if (current.type.equals("moveLeft")) {
					x = x - current.speed;
				} else if (current.type.equals("moveRight")) {
					x = x + current.speed;
				} else if (current.type.equals("pause")) {
					// Do nothing if the movement type is pause.
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
	 * Adds a new movement to the starship.
	 * Possible movements (type) include: moveUp, moveDown, moveLeft, moveRight, and
	 * pause.
	 *
	 * @param type The type of movement.
	 * @param t    The duration of this movement.
	 * @param s    The speed of the motion.
	 */
	public void addMovement(String type, int t, int s) {
		Movement move = new Movement(type, t, s);
		moveList.add(move);
		current = (Movement) moveList.get(0);
	}

	/**
	 * Part of the animation, this method draws the StarShip.
	 *
	 * @param g The Graphics object for rendering the starship.
	 */
	public void draw(Graphics g) {
		// Set color to white for drawing the starship.
		g.setColor(Color.white);

		// Draw the main body of the starship.
		g.fillOval(x, y, 30, 30);

		// Draw the wings of the starship.
		g.fillRect(x + 17, y + 5, 30, 3);
		g.fillRect(x + 17, y + 25, 30, 3);
	}
}
