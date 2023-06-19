package animatedSpace;
import java.util.ArrayList;
import java.awt.*;


/**
 * This Class creates an animated starship for the Space
 * class that can be displayed in an animation.
 *
 */
public class StarShip extends AnimatedObject {

	public int x;
	public int y;
	private int times;
	private ArrayList moveList; 
	private Movement current;
	private int i;
	
	/**
	 * This creates a StarShip based on its x,y position.
	 * @param xpos X Position
	 * @param ypos Y Position
	 */
	public StarShip( int xpos, int ypos){
		x=xpos;
		y=ypos;
		moveList=new ArrayList();
		times=0;
		i=0;		
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
	 * moveRight, and pause.
	 * @param type The type of movement
	 * @param t The duration of this movement
	 * @param s The speed of the motion.
	 */
	public void addMovement(String type, int t, int s){
		Movement move=new Movement(type, t, s);
		moveList.add(move);
		current=(Movement)moveList.get(0);
	}
	
	/**
	 * Part of the animation, this draws the Object.
	 */
	public void draw(Graphics g){
		g.setColor(Color.white);
		g.fillOval(x,y,30,30);
		g.fillRect(x+17,y+5,30,3);
		g.fillRect(x+17,y+25,30,3);
	}

}
