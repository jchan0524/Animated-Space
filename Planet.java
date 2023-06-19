package animatedSpace;
import java.awt.Color;

/**
 * This class is basically a variable that stores planets.
 */
public class Planet {

	public int x;
	public int y;
	public int d;
	public Color c;
	
	/**
	 * When a planet is created with this method in the Space class, it will
	 * be given the position, and will calculate the diameter and color.
	 * @param xpos X Position
	 * @param ypos Y Position
	 */
	public Planet(int xpos, int ypos){
		this.x=xpos;
		this.y=ypos;
		this.d=(int)(Math.random()*50);
		this.c=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
	}
	
	/**
	 * When a planet is created with this method in the Space class, it will
	 * be given the position and diameter, and will calculate the color.
	 * @param xpos X Position
	 * @param ypos Y Position
	 * @param diameter Planet Diameter
	 */
	public Planet(int xpos, int ypos, int diameter){
		this.x=xpos;
		this.y=ypos;
		this.d=diameter;
		this.c=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
	}
	
	/**
	 *When a planet is created with this method in the Space class, it will
	 * be given the position, the diameter, and the color.
	 * @param xpos X Position
	 * @param ypos Y Position
	 * @param diameter Planet Diameter
	 * @param col Planet Color
	 */
	public Planet(int xpos, int ypos, int diameter, Color col){
		this.x=xpos;
		this.y=ypos;
		this.d=diameter;
		this.c=col;
	}
	
	/**
	 * When a planet is created with this method in the Space class, it will
	 * randomly calculate the position, diameter, and color.
	 */
	public Planet(){
		this.x=(int)(Math.random()*500);
		this.y=(int)(Math.random()*500);
		this.d=(int)(Math.random()*50);
		this.c=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
	}
}
