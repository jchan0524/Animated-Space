package animatedSpace; // Define the package name where this class is located.

import java.util.ArrayList; // Import ArrayList for handling lists of objects.

/**
 * AnimationThread class is responsible for animating objects within a space.
 * It extends the Thread class, and thus can be run in parallel with other
 * threads.
 */
public class AnimationThread extends Thread {
	private ArrayList animatedObjects; // List to store the animated objects.
	private Space space; // Space in which the animation takes place.

	/**
	 * Constructor that initializes the AnimationThread with a list of animated
	 * objects
	 * and a space in which the animation will occur.
	 * 
	 * @param ss List of animated objects.
	 * @param s  The space in which animation occurs.
	 */
	public AnimationThread(ArrayList ss, Space s) {
		animatedObjects = ss;
		space = s;
	}

	/**
	 * This method contains the main animation loop. It runs indefinitely,
	 * repeatedly animating the objects and updating the space.
	 */
	public void run() {
		while (true) {
			// Iterate through each animated object and call its move method.
			for (int i = 0; i < animatedObjects.size(); i++) {
				AnimatedObject ss = (AnimatedObject) animatedObjects.get(i);
				ss.move();
			}

			// If star animation is enabled, animate stars.
			if (space.starAnimation) {
				space.animateStars();
			}

			// Repaint the space to reflect changes.
			space.repaint();

			// Pause for a short duration before the next iteration.
			try {
				Thread.sleep(20);
			} catch (InterruptedException ex) {
				// If thread is interrupted, exception is caught but not handled, allowing the
				// loop to continue.
			}
		}
	}
}
