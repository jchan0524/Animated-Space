package animatedSpace;


import java.awt.*;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Space creates and manages the space for an Outer Space Animation!
 */
public class Space extends JComponent{
	private static final long serialVersionUID=5;
	private ArrayList stars;
	private ArrayList planets;
	private ArrayList suns;
	private ArrayList animatedObjects;
	public Graphics os;
	private Image offScreenImage;
	private Dimension screenSize;
	public boolean starAnimation;
	
	/**
	 * When constructed, Space creates the space, 
	 * initializes the Lists of objects to plot, and then
	 * paints itself for the first time.
	 */
	public Space(){
	    screenSize = getToolkit().getScreenSize();
        stars=new ArrayList<>();
        planets=new ArrayList<>();
        suns=new ArrayList<>();
        animatedObjects=new ArrayList<>();
		for(int i=0; i<500;i++){
			Star st=new Star(screenSize);
			stars.add(st);
		}
		starAnimation=false;
		repaint();
	
	}
	
	/**
	 * Creates a planet using the x and y positions of the planet.
	 * It generates a random color and diameter.
	 * @param xpos X position
	 * @param ypos Y position
	 */
	public void addPlanet(int xpos, int ypos){
		Planet plan=new Planet(xpos, ypos);
		planets.add(plan);
	}
	
	/**
	 * Creates a planet using the x and y positions, 
	 * along with the diameter of the planet.
	 * It calculates a random color.
	 * @param xpos X Position
	 * @param ypos Y Position
	 * @param diameter Planet Diamter
	 */
	public void addPlanet(int xpos, int ypos, int diameter){
		Planet plan=new Planet(xpos, ypos, diameter);
		planets.add(plan);
	}
	
	/**
	 * Creates a planet using the x and y positions, 
	 * along with the diameter and color of the planet.
	 * @param xpos X Position
	 * @param ypos Y Position
	 * @param diameter Planet Diameter
	 * @param col Planet Color
	 */
	public void addPlanet(int xpos, int ypos, int diameter, Color col){
		Planet plan=new Planet(xpos, ypos, diameter, col);
		planets.add(plan);
	}
	
	/**
	 * Creates a planet with a random position, diameter, and color.
	 *
	 */
	public void addPlanet(){
		Planet plan=new Planet();
		planets.add(plan);
	}
	
	/**
	 * Creates a random star within the boundaries of the screen.
	 *
	 */
	public void addStar(){
		Star star=new Star(screenSize);
		stars.add(star);
	}
	
	/**
	 * Creates a star at a specific position.
	 * @param xpos X Position
	 * @param ypos Y Position
	 */
	public void addStar(int xpos, int ypos){
		Star star=new Star(xpos, ypos);
		stars.add(star);
	}
	
	/**
	 * Creates a sun at a specific position.
	 * It uses a random diamter.
	 * @param xpos X Position
	 * @param ypos Y Position
	 */
	public void addSun(int xpos, int ypos){
		Sun sun=new Sun(xpos, ypos);
		suns.add(sun);
	}
	
	/**
	 * Creates a sun with a specific position and diameter.
	 * @param xpos X Position
	 * @param ypos Y Position
	 * @param diameter Sun Diameter
	 */
	public void addSun(int xpos, int ypos, int diameter){
		Sun sun=new Sun(xpos, ypos, diameter);
		suns.add(sun);
	}
	
	/**
	 * Creates a sun at a random position and diameter.
	 *
	 */
	public void addSun(){
		Sun sun=new Sun();
		suns.add(sun);
	}
	
	/**
	 * Adds an animated object to the space.
	 * @param myObject Some Animated Object (Polymorphism!!!)
	 */
	public void addAnimatedObject(AnimatedObject myObject){
		animatedObjects.add(myObject);
	}
	
	/**
	 * Starts the animation.
	 *
	 */
	public void animate(){
		AnimationThread myThread=new AnimationThread(animatedObjects, this);
		myThread.start();
	}
	
	/**
	 * Turns on the Stellar motion.
	 * It is off by default.
	 *
	 */
	public void setStellarAnimation(){
		starAnimation=true;
	}
	
	/**
	 * Part of the Animation, this animates the
	 * background if that option is turned on.
	 *
	 */
	public void animateStars(){
		for(int i=0; i<stars.size();i++){
			Star st=(Star) stars.get(i);
			st.x--;
			if(st.x<0){
				st.x=screenSize.width;
			}
		}
		for(int i=0; i<planets.size();i++){
			Planet st=(Planet) planets.get(i);
			st.x--;
			if(st.x<0){
				st.x=screenSize.width;
			}
		}
		for(int i=0; i<suns.size();i++){
			Sun st=(Sun) suns.get(i);
			st.x--;
			if(st.x<0){
				st.x=screenSize.width;
			}
		}
	}
	
	/**
	 * Part of the animation, this paints the space
	 * on each iteration.
	 */
	public void paint(Graphics g){
		if(offScreenImage==null){
			offScreenImage = createImage(getWidth(), getHeight());
	        os = offScreenImage.getGraphics();
		}
		os =g.create();
		os.setColor(Color.black);
		os.fillRect(0,0,getWidth(),getHeight());
		try{
		for(int i=0;i<stars.size();i++){
			Star star=(Star) stars.get(i);
			drawStar(star);
		}
		for(int i=0;i<planets.size();i++){
			Planet planet=(Planet) planets.get(i);
			drawPlanet(planet);
		}
		for(int i=0;i<suns.size();i++){
			Sun sun=(Sun) suns.get(i);
			drawSun(sun);
		}
		for(int i=0;i<animatedObjects.size();i++){
			AnimatedObject ss=(AnimatedObject) animatedObjects.get(i);
			drawAnimatedObject(ss);
		}
		}
		catch (NullPointerException e){
			
		}

		g.drawImage(offScreenImage, getWidth(), getHeight(), this);
		}
	
	/**
	 * This draws a star on the background.
	 * @param s The Star
	 */
	private void drawStar(Star s){
		os.setColor(Color.white);
		os.fillRect(s.x,s.y,1,1);
	}
	
	/**
	 * This draws a planet on the background
	 * @param p The Planet
	 */
	private void drawPlanet(Planet p){
		os.setColor(p.c);
		os.fillOval(p.x,p.y,p.d,p.d);
	}
	
	/**
	 * This draws a sun on the background.
	 * @param s The Sun
	 */
	private void drawSun(Sun s){
		Graphics2D g2=(Graphics2D)os;
		GradientPaint grad=new GradientPaint(s.x, s.y, Color.red, s.x+s.d, s.y+s.d, Color.orange, true);
	    g2.setPaint(grad);
	    g2.fillOval(s.x,s.y,s.d,s.d);
	}
	
	/**
	 * This draws the Animated objects on the background.
	 * @param s The Animated Object
	 */
	private void drawAnimatedObject(AnimatedObject s){
		s.draw(os);
	}
}
