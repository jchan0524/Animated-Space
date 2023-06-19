package animatedSpace;

/**
 * This class is basically a variable that stores suns.
 * You do not have to use this class in main, since 
 * Space has methods for adding suns.
 *
 */
public class Sun {

	public int x;
	public int y;
	public int d;
	
	/**
	 * When a sun is created using this method in the Space class,
	 * The sun will use the position given and calculate the diameter randomly.
	 * @param xpos X Position
	 * @param ypos Y Position
	 */
	public Sun(int xpos, int ypos){
		this.x=xpos;
		this.y=ypos;
		this.d=(int)(Math.random()*50);
	}
	
	/**
	 * When a sun is created using this method in the Space class,
	 * it will use the position and diameter given
	 * @param xpos X Position
	 * @param ypos Y Position
	 * @param diameter Sun Diameter
	 */
	public Sun(int xpos, int ypos, int diameter){
		this.x=xpos;
		this.y=ypos;
		this.d=diameter;
	}
	
	/**
	 * When a sun is created using this method in the Space class,
	 * it will calculate the position and diameter randomly.
	 *
	 */
	public Sun(){
		this.x=(int)(Math.random()*500);
		this.y=(int)(Math.random()*500);
		this.d=(int)(Math.random()*50);
	}
}
