package animatedSpace;
import java.util.ArrayList;
import java.awt.*;

/**
 * This Class creates an animated TimeLordShip for the Space
 * class that can be displayed in an animation.
 *
 */
public class TimeLordShip extends AnimatedObject {

	public int x;
	public int y;
	private int times;
	private ArrayList moveList; 
	private Movement current;
	private int i;
	private Graphics2D g2;
	private Color mine;
	
	/**
	 * This creates the ship based on the position.
	 * @param xpos x Position
	 * @param ypos Y Position
	 */
	public TimeLordShip( int xpos, int ypos){
		x=xpos;
		y=ypos;
		moveList=new ArrayList();
		times=0;
		i=0;		
		mine=new Color(0,0,205);
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
		current=(Movement)moveList.get(i);
	}
	
	/**
	 * Part of the animation, this draws the Object.
	 */
	public void draw(Graphics g){
		g2=(Graphics2D)g;
		g2.setColor(Color.blue);
		g2.fillRect(x,y,20,40);
		g2.setColor(Color.yellow);
		g2.fillRect(x+3,y+2,5,9);
		g2.fillRect(x+13,y+2,5,9);
		g2.setColor(mine);
		g2.fillRect(x+9,y,2,38);
		g2.fillRect(x+1,y+10, 20, 2);
		g2.fillRect(x+1,y+20, 18, 2);
		g2.fillRect(x+1,y+30, 18, 2);
		g2.drawRect(x,y,20,40);
	}

}
