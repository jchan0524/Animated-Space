package animatedSpace;

/**
 * This class is basically a variable for storing the
 * movements of the animated objects.
 *
 */
public class Movement {

	public int time;
	public String type;
	public int speed;
	
	/**
	 * When a movement is created by an animated object, it will
	 * be given the type of movement, the time, and the speed.
	 * @param ty The type of movement, which is a String defined in the Animated Object's class.
	 * @param t The number of iterations to do this movement
	 * @param s The speed (skips some iterations)
	 */
	public Movement(String ty,int t,int s){
		time=t;
		type=ty;
		speed=s;
	}
}
