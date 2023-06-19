package animatedSpace;

import java.util.ArrayList;

/**
 * This class creates a thread that handles the animation
 * of the Space.

 */
public class AnimationThread extends Thread {
	private ArrayList animatedObjects;
	private Space space;

	public AnimationThread(ArrayList ss, Space s){
		animatedObjects=ss;
		space=s;
		
	}
	
	/**
	 * This is the animation loop, it goes on forever,
	 * repeatedly calling the animations and the 
	 * painting of the space until you stop the 
	 * program.
	 *
	 */
	public void run(){
		while(true){
			for(int i=0;i<animatedObjects.size();i++){
				AnimatedObject ss=(AnimatedObject) animatedObjects.get(i);
				ss.move();
			}
			if(space.starAnimation==true){
				space.animateStars();
			}
			space.repaint();
			try
			{
				Thread.sleep(20);
			}
			catch (InterruptedException ex)
			{
				// swallow the exception
			}
		}
	}
}
