# Space Animation Program

## Description

The Space Animation Program is a Java-based application that simulates a space environment with stars, suns, a starship, a Time Lord's spaceship, planets, and a Death Star, all moving in an animated space. The program uses Java's Swing library to create the animation.

## Image


<img width="790" alt="animated-space" src="https://github.com/jchan0524/Animated-Space/assets/117332299/a6082e5f-920a-4b60-92af-da6920dcdad5">


## Files

### `AnimatedObject.java`

This is an abstract class that serves as a base for all animated objects within the space animation. It is meant to be extended by other classes that need common animation functionalities.

### `Movement.java`

This class is used to store the properties of a movement for animated objects. Each movement has a type (such as "moveUp", "moveDown", "moveLeft", "moveRight", "pause"), time (duration), and speed.

### `Space.java`

This class sets up the animation enviroment and is responsible for updating the screen at a regular interval. It also contains methods for adding animated objects like stars, suns, planets, and spaceships to the space.

### `Star.java`

This class represents a star in the animation. It has x and y coordinates and can be created with a specific position or a random position based on the size of the display.

### `StarShip.java`

This class represents a starship in the animation. It extends `AnimatedObject` and has x and y coordinates. The starship can move according to a list of movements. It also has a method to draw itself

### `Sun.java`

This class represents a sun in the animation. It has x and y coordinates and a diameter. The sun can be created with specific position and diameter, or with random values.

### `TimeLordShip.java`

This class represents a Time Lord's spaceship in the animation. Similar to `StarShip`, it extends `AnimatedObject`. It moves according to a list of movements and has a method to draw itself.

### `AnimatedPlanet.java`

This class represents a planet in the animation. It extends `AnimatedObject` and includes properties such as x and y coordinates. The planets can move around the space and be drawn on the screen.

### `DeathStar.java`

This class represents a Death Star in the animation. Similar to `StarShip`, it extends `AnimatedObject`. It has a custom shape and can move according to a list of movements. It also has a method to draw itself.

### `AnimatedThread.java`

This class extends `Thread` and is responsible for handling the animation loop. It refreshes the screen at regular intervals and calls the move method of each animated object in the space.

### `Main.java`

This is the entry point of the program. It initializes and starts the animation by creating an instance of the `Space` class.

## How to Run

1. Ensure you have Java Development Kit (JDK) installed on your machine.

2. Open a terminal or command prompt.

3. Navigate to the directory where the files are located.

4. Compile all the java files using the command: `javac -d bin *.java`

5. Navigate to the newly made bin directory: `cd bin`

6. Run the Main class to start the animation: `java animatedSpace.Main`

7. The animation windown should open, displaying the animated space environment.

## What I Learned

- Object-Oriented Programming: This project helped me brush up on my unstanding of the core concepts of OOP such as inheritance, abstraction, and polymorphism.

- Animation Concepts: Used the basics of animation such as frames, animation loops, and movements. This is evident in working with the `AnimatedObject` class and managing different movements through the `Movement` class.

- Error Handling: Practiced handling exceptions in the `StarShip` and `TimeLordShip` classes

## Technologies Used

- Java: The primary programming language used in the program.

- Java Swing: Used to create the GUI of the program.

- Java AWT (Abstract Window Toolkit): Used in conjunction with Java Swing, AWT provides GUI components and is used for rendering graphics and creating windows in this project.

- Vim: Used the Vim program for text editing this program.

## Author

Justin Chan
