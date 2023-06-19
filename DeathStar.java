package animatedSpace;
import java.util.ArrayList;
import java.awt.*;


/**
 * This Class creates an animated DeathStar for the Space
 * class that can be displayed in an animation.
 *
 */
public class DeathStar extends AnimatedObject {

	public int x;
	public int y;
	private int times;
	private ArrayList moveList; 
	private Movement current;
	private int i;
	private Graphics2D g2;
	private GradientPaint grad;
	private GradientPaint grad2;
	
	/**
	 * This creates a DeathStar based on its x,y position.
	 * @param xpos X Position
	 * @param ypos Y Position
	 */
	public DeathStar( int xpos, int ypos){
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
		grad=new GradientPaint(x, y, Color.white, x+200, y+200, Color.black, true);
		grad2=new GradientPaint(x+65, y+10, Color.black, x+135, y+60, Color.white, true);
		g2 = (Graphics2D)g;
	    g2.setPaint(grad);
	    g2.fillOval(x,y,200,200);
		g2.setPaint(grad2);
		g2.fillOval(x+65,y+10,70,50);
		g2.drawArc(x,y+80,205,60,20,160);
		g2.setColor(Color.black);
		g2.fillRect(x+100,y+120,100,2);
		g2.fillRect(x+130,y+160,50,50);
		g2.fillRect(x+140,y+150,50,20);
		g2.fillRect(x+100,y+180,100,10);
		g2.fillRect(x+100,y+130,100,2);
		g2.setColor(Color.black);
		g2.fillOval(x+100, y+35,2,2);


	}

}
