package animatedSpace;
import java.util.ArrayList;
import java.awt.*;

/**
 * This Class creates an animated planet for the Space
 * class that can be displayed in an animation.

 *
 */
public class AnimatedPlanet extends AnimatedObject {

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
	 * This creates an animated planet based on its position,
	 * diameter, orbit diameter, and color.
	 * @param xpos X Position
	 * @param ypos Y Position
	 * @param diameter Planet Diameter
	 * @param orbitDia Diameter of the Orbit
	 * @param col Planet Color
	 */
	public AnimatedPlanet( int xpos, int ypos, int diameter, int orbitDia, Color col){
		x=xpos;
		y=ypos;
		moveList=new ArrayList();
		times=0;
		i=0;		
		x0=xpos;
		y0=ypos;
		d=diameter;
		orbitD=orbitDia;
		c=col;
	}
	
	/**
	 * Part of the animation, this moves the object on
	 * each iteration.
	 */
	public void move(){
		try{
			try{
				current=(Movement)moveList.get(i);
			}
			catch(IndexOutOfBoundsException e){
				i=0;
				current=(Movement)moveList.get(i);
				times=0;
			}
		if(times<current.time){
			times=times+current.speed;
			if (current.type.equals("moveUp")){
				y=y-current.speed;
			}
			else if (current.type.equals("moveDown")){
				y=y+current.speed;
			}
			else if (current.type.equals("moveLeft")){
				x=x-current.speed;
			}
			else if (current.type.equals("moveRight")){
				x=x+current.speed;
			}
			else if (current.type.equals("orbit")){
				
				x=(int)(x0+orbitD*Math.cos(times*current.speed*0.001));
				y=(int)(y0+orbitD*Math.sin(times*current.speed*0.001));
				
			}
			else if (current.type.equals("pause")){
			}

		}
		else{
			i++;
			times=0;
		}
	}
	catch(NullPointerException e){
		System.out.println("You need to enter movements for an object!");
	}
	catch(IndexOutOfBoundsException e){
		System.out.println("You need to enter movements for an object!");
	}
	}
	
	/**
	 * This creates a new movement that the SpaceShip will do.
	 * It will repeat the sequence over and over.
	 * Possible movements (type) include: moveUp, moveDown, moveLeft,
	 * moveRight, orbit and pause.
	 * @param type The type of movement
	 * @param t The duration of this movement
	 * @param s The speed of the motion.
	 */
	public void addMovement(String type, int t, int s){
		Movement move=new Movement(type, t, s);
		moveList.add(move);
		current=(Movement)moveList.get(i);
	}
	
	/**
	 * Part of the animation, this draws the Object.
	 */
	public void draw(Graphics g){
		GradientPaint grad=new GradientPaint(x, y, c, x+d, y+d, Color.black, true);
		Graphics2D g2=(Graphics2D)g;
	    g2.setPaint(grad);
	    g2.fillOval(x,y,d,d);
	}

}
