package animatedSpace;

import java.awt.*;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The Space class represents the outer space where animation takes place.
 * It creates and manages stars, planets, suns, and other animated objects.
 */
public class Space extends JComponent {

	// Serial version UID for serialization.
	private static final long serialVersionUID = 5;

	// Lists to store the space objects.
	private ArrayList stars;
	private ArrayList planets;
	private ArrayList suns;
	private ArrayList animatedObjects;

	// Graphics objects for offscreen drawing.
	public Graphics os;

	// Offscreen image used for double buffering
	private Image offScreenImage;

	// Dimension object to store the screen size.
	private Dimension screenSize;

	// Flag to enable or disable star animation.
	public boolean starAnimation;

	/**
	 * Constructor - initializes object lists, creates stars, and paints space.
	 */
	public Space() {
		// Get screen size
		screenSize = getToolkit().getScreenSize();

		// Initialize the lists for stars, planets, suns, and animated objects.
		stars = new ArrayList<>();
		planets = new ArrayList<>();
		suns = new ArrayList<>();
		animatedObjects = new ArrayList<>();

		// Creates 500 stars
		for (int i = 0; i < 500; i++) {
			Star st = new Star(screenSize);
			stars.add(st);
		}

		// Initially set star animation to false
		starAnimation = false;

		// Initial paint
		repaint();

	}

	/**
	 * Creates a planet using the x and y positions of the planet.
	 * It generates a random color and diameter.
	 * 
	 * @param xpos X position
	 * @param ypos Y position
	 */
	public void addPlanet(int xpos, int ypos) {
		Planet plan = new Planet(xpos, ypos);
		planets.add(plan);
	}

	/**
	 * Creates a planet using the x and y positions,
	 * along with the diameter of the planet.
	 * It calculates a random color.
	 * 
	 * @param xpos     X Position
	 * @param ypos     Y Position
	 * @param diameter Planet Diamter
	 */
	public void addPlanet(int xpos, int ypos, int diameter) {
		Planet plan = new Planet(xpos, ypos, diameter);
		planets.add(plan);
	}

	/**
	 * Creates a planet using the x and y positions,
	 * along with the diameter and color of the planet.
	 * 
	 * @param xpos     X Position
	 * @param ypos     Y Position
	 * @param diameter Planet Diameter
	 * @param col      Planet Color
	 */
	public void addPlanet(int xpos, int ypos, int diameter, Color col) {
		Planet plan = new Planet(xpos, ypos, diameter, col);
		planets.add(plan);
	}

	/**
	 * Creates a planet with a random position, diameter, and color.
	 *
	 */
	public void addPlanet() {
		Planet plan = new Planet();
		planets.add(plan);
	}

	/**
	 * Creates a random star within the boundaries of the screen.
	 *
	 */
	public void addStar() {
		Star star = new Star(screenSize);
		stars.add(star);
	}

	/**
	 * Creates a star at a specific position.
	 * 
	 * @param xpos X Position
	 * @param ypos Y Position
	 */
	public void addStar(int xpos, int ypos) {
		Star star = new Star(xpos, ypos);
		stars.add(star);
	}

	/**
	 * Creates a sun at a specific position.
	 * It uses a random diamter.
	 * 
	 * @param xpos X Position
	 * @param ypos Y Position
	 */
	public void addSun(int xpos, int ypos) {
		Sun sun = new Sun(xpos, ypos);
		suns.add(sun);
	}

	/**
	 * Creates a sun with a specific position and diameter.
	 * 
	 * @param xpos     X Position
	 * @param ypos     Y Position
	 * @param diameter Sun Diameter
	 */
	public void addSun(int xpos, int ypos, int diameter) {
		Sun sun = new Sun(xpos, ypos, diameter);
		suns.add(sun);
	}

	/**
	 * Creates a sun at a random position and diameter.
	 *
	 */
	public void addSun() {
		Sun sun = new Sun();
		suns.add(sun);
	}

	/**
	 * Adds an animated object to the space.
	 * 
	 * @param myObject Some Animated Object (Polymorphism!!!)
	 */
	public void addAnimatedObject(AnimatedObject myObject) {
		animatedObjects.add(myObject);
	}

	/**
	 * Begins the animation by creating and starting an animation thread
	 */
	public void animate() {
		AnimationThread myThread = new AnimationThread(animatedObjects, this);
		myThread.start();
	}

	/**
	 * Enables star animation (Initially disabled)
	 */
	public void setStellarAnimation() {
		starAnimation = true;
	}

	/**
	 * Part of the Animation, this animates the
	 * background if that option is turned on.
	 *
	 */
	public void animateStars() {
		// Loop through stars and move them
		for (int i = 0; i < stars.size(); i++) {
			Star st = (Star) stars.get(i);
			st.x--;

			// If the star moves off the screen, place it on the other side
			if (st.x < 0) {
				st.x = screenSize.width;
			}
		}

		for (int i = 0; i < planets.size(); i++) {
			Planet st = (Planet) planets.get(i);
			st.x--;
			if (st.x < 0) {
				st.x = screenSize.width;
			}
		}

		for (int i = 0; i < suns.size(); i++) {
			Sun st = (Sun) suns.get(i);
			st.x--;
			if (st.x < 0) {
				st.x = screenSize.width;
			}
		}
	}

	/**
	 * Paints the space, including stars, planets, suns, and animated objects.
	 */
	public void paint(Graphics g) {
		// If offScreenImage is null, initailize it and create graphics object.
		if (offScreenImage == null) {
			offScreenImage = createImage(getWidth(), getHeight());
			os = offScreenImage.getGraphics();
		}
		// Create graphics object and set background color to black
		os = g.create();
		os.setColor(Color.black);
		os.fillRect(0, 0, getWidth(), getHeight());

		try {
			// Draw each star
			for (int i = 0; i < stars.size(); i++) {
				Star star = (Star) stars.get(i);
				drawStar(star);
			}

			// Draw each planet
			for (int i = 0; i < planets.size(); i++) {
				Planet planet = (Planet) planets.get(i);
				drawPlanet(planet);
			}

			// Draw each sun
			for (int i = 0; i < suns.size(); i++) {
				Sun sun = (Sun) suns.get(i);
				drawSun(sun);
			}

			// Draw each animated Object
			for (int i = 0; i < animatedObjects.size(); i++) {
				AnimatedObject ss = (AnimatedObject) animatedObjects.get(i);
				drawAnimatedObject(ss);
			}
		} catch (NullPointerException e) {

		}

		g.drawImage(offScreenImage, getWidth(), getHeight(), this);
	}

	/**
	 * This draws a star on the background.
	 * 
	 * @param s The Star
	 */
	private void drawStar(Star s) {
		os.setColor(Color.white);
		os.fillRect(s.x, s.y, 1, 1);
	}

	/**
	 * This draws a planet on the background
	 * 
	 * @param p The Planet
	 */
	private void drawPlanet(Planet p) {
		os.setColor(p.c);
		os.fillOval(p.x, p.y, p.d, p.d);
	}

	/**
	 * This draws a sun on the background.
	 * 
	 * @param s The Sun
	 */
	private void drawSun(Sun s) {
		Graphics2D g2 = (Graphics2D) os;
		GradientPaint grad = new GradientPaint(s.x, s.y, Color.red, s.x + s.d, s.y + s.d, Color.orange, true);
		g2.setPaint(grad);
		g2.fillOval(s.x, s.y, s.d, s.d);
	}

	/**
	 * This draws the Animated objects on the background.
	 * 
	 * @param s The Animated Object
	 */
	private void drawAnimatedObject(AnimatedObject s) {
		s.draw(os);
	}
}
