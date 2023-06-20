package animatedSpace;

import java.awt.*;

import javax.swing.*;

/**
 * The Main class is the main entry point for the Animated Space program.
 * It sets up the JFrame, adds animated objects to the Space, and starts the
 * animation.
 */

public class Main extends JFrame {
    private static final long serialVersionUID = 5;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public Main() {
        // Set the size of the JFrame
        this.setSize(WIDTH, HEIGHT);

        // Create a space object
        Space solarSystem = new Space();

        // Add the Space object to the content pane of the JFrame.
        this.getContentPane().add(solarSystem, BorderLayout.CENTER);

        // Start the animation of the Space.
        solarSystem.animate();

        // Create and add Death Star
        DeathStar DeathBall = new DeathStar(150, 100);

        // Movements to the Death Star.
        DeathBall.addMovement("pause", 400, 2);
        DeathBall.addMovement("pause", 50, 2);
        DeathBall.addMovement("moveRight", 450, 1);
        DeathBall.addMovement("moveDown", 450, 4);
        DeathBall.addMovement("pause", 70, 10);
        DeathBall.addMovement("moveUp", 450, 4);
        DeathBall.addMovement("moveLeft", 450, 100);

        solarSystem.addAnimatedObject(DeathBall);

        // Create and add animated Starship Enterprise.
        StarShip enterprise = new StarShip(600, 100);

        // Add movements to the Death Star.
        enterprise.addMovement("moveLeft", 400, 2);
        enterprise.addMovement("pause", 50, 2);
        enterprise.addMovement("moveRight", 400, 4);
        enterprise.addMovement("moveDown", 400, 2);
        enterprise.addMovement("moveLeft", 400, 4);
        enterprise.addMovement("moveRight", 400, 2);
        enterprise.addMovement("pause", 200, 2);

        solarSystem.addAnimatedObject(enterprise);

        // Create and add animated TimeLordShip Tardis.
        TimeLordShip tardis = new TimeLordShip(400, 500);

        // Add movements to the TimeLordShip Tardis
        tardis.addMovement("moveLeft", 800, 100);
        tardis.addMovement("moveRight", 800, 100);
        tardis.addMovement("pause", 50, 100);
        tardis.addMovement("moveUp", 800, 100);
        tardis.addMovement("moveDown", 800, 100);

        solarSystem.addAnimatedObject(tardis);

        // Add planets and suns to the solar system
        solarSystem.setStellarAnimation();
        solarSystem.addPlanet(200, 300, 250);
        solarSystem.addSun(500, 325, 300);
        solarSystem.addPlanet(400, 50, 50);
        solarSystem.addSun(40, 400, 10);
        AnimatedPlanet sun = new AnimatedPlanet(325, 325, 50, 0, Color.yellow);
        sun.addMovement("pause", 20000, 6);
        solarSystem.addAnimatedObject(sun);
        AnimatedPlanet mercury = new AnimatedPlanet(350, 350, 3, 40, Color.red);
        mercury.addMovement("orbit", 20000, 6);
        solarSystem.addAnimatedObject(mercury);
        AnimatedPlanet venus = new AnimatedPlanet(350, 350, 5, 60, Color.white);
        venus.addMovement("orbit", 20000, 5);
        solarSystem.addAnimatedObject(venus);
        AnimatedPlanet earth = new AnimatedPlanet(350, 350, 10, 75, Color.blue);
        earth.addMovement("orbit", 20000, 4);
        solarSystem.addAnimatedObject(earth);
        AnimatedPlanet mars = new AnimatedPlanet(350, 350, 9, 100, Color.red);
        mars.addMovement("orbit", 20000, 3);
        solarSystem.addAnimatedObject(mars);
        AnimatedPlanet jupiter = new AnimatedPlanet(350, 350, 20, 130, Color.orange);
        jupiter.addMovement("orbit", 20000, 2);
        solarSystem.addAnimatedObject(jupiter);
        AnimatedPlanet saturn = new AnimatedPlanet(350, 350, 17, 160, Color.yellow);
        saturn.addMovement("orbit", 20000, 1);
        solarSystem.addAnimatedObject(saturn);
        AnimatedPlanet dwarf = new AnimatedPlanet(10, 300, 200, 10, Color.green);
        dwarf.addMovement("moveRight", 400, 4);
        dwarf.addMovement("pause", 50, 2);
        dwarf.addMovement("moveRight", 200, 2);
        dwarf.addMovement("moveDown", 450, 4);
        dwarf.addMovement("moveLeft", 400, 4);
        dwarf.addMovement("moveLeft", 200, 2);
        dwarf.addMovement("moveUp", 450, 4);
        solarSystem.addAnimatedObject(dwarf);

        // Set the default close operation for the JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the JFrame visable
        this.setVisible(true);

    }

    /**
     * Main method that serves as the entry point for the program
     */
    public static void main(String[] args) {
        // Create a new instance of Main which initializes and starts the program
        new Main();
    }

}
