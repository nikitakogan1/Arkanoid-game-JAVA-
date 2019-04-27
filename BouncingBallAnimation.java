import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.awt.Color;

/**
 * @author Nikita Kogan
 * implementation of Line BouncingBallAnimation.
 */
public class BouncingBallAnimation {
    /**
     * main to run the bouncing ball animation.
     *
     * @param args from cmd.ball sizes
     */
    public static void main(String[] args) {
        GUI gui = new GUI("title", 800, 600); //create new gui
        Sleeper sleeper = new Sleeper(); //new sleeper
        Ball ball = new Ball(new Point(0, 0), 30, Color.PINK); //we create a new ball
        ball.setVelocity(20, 20); //we set the velocity.
        while (true) { //loop to make the ball run for ever.
            ball.moveOneStep(); //we use the func to move the ball.
            DrawSurface d = gui.getDrawSurface(); //create new surface
            ball.drawOn(d); //draw the ball on the surface
            gui.show(d); //show command.
            sleeper.sleepFor(80); // wait for 50 milliseconds.
        }
    }
}
