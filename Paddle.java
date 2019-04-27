import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * Paddle class.
 */
public class Paddle implements Sprite, Collidable {
    //Members.
    private biuoop.KeyboardSensor keyboard;
    private Block paddle;
    private int speed;
    private int paddleWidth;

    /**
     * //constructor.
     *
     * @param s     keyboard
     * @param block block
     * @param w w
     * @param sp sp
     */
    public Paddle(KeyboardSensor s, Block block, int sp, int w) {
        this.paddle = block;
        this.keyboard = s;
        this.speed = sp;
        this.paddleWidth = w;
    }

    /**
     * function to move left.
     */
    public void moveLeft() {
        if (this.getCollisionRectangle().getUpperLeft().getX() <= 20) {
            this.getCollisionRectangle().setUpperLeft(20, this.getCollisionRectangle().getUpperLeft().getY());
        } else {
            this.getCollisionRectangle().setUpperLeft(this.getCollisionRectangle().getUpperLeft().getX() - speed,
                    this.getCollisionRectangle().getUpperLeft().getY());
        }
    }

    /**
     * function to move right.
     */
    public void moveRight() {
        if (this.getCollisionRectangle().getUpperLeft().getX() >= 780 - paddleWidth) {
            this.getCollisionRectangle().setUpperLeft(780 - paddleWidth,
                    this.getCollisionRectangle().getUpperLeft().getY());
        } else {
            this.getCollisionRectangle().setUpperLeft(this.getCollisionRectangle().getUpperLeft().getX() + speed,
                    this.getCollisionRectangle().getUpperLeft().getY());
        }
    }

    /**
     * checks for keyboard sensor.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * draw function.
     *
     * @param d surface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.YELLOW);
        d.fillRectangle((int) this.getCollisionRectangle().getUpperLeft().getX(),
                (int) this.getCollisionRectangle().getUpperLeft().getY(),
                (int) this.getCollisionRectangle().getWidth(), (int) this.getCollisionRectangle().getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.getCollisionRectangle().getUpperLeft().getX(),
                (int) this.getCollisionRectangle().getUpperLeft().getY(),
                (int) this.getCollisionRectangle().getWidth(), (int) this.getCollisionRectangle().getHeight());
    }

    /**
     * return rectange.
     *
     * @return this.paddle.getCollisionRectangle();
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle.getCollisionRectangle();
    }

    /**
     * function to change the velocity of the ball when being collide with the paddle. the angles are according to
     * the manual.
     *
     * @param collisionPoint  collision point
     * @param currentVelocity current ball's velocity
     * @param hitter hitter.
     * @return new velocity according to the hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double fragment = 15; //since padle is 80 size.
        Velocity v = currentVelocity;
        double v1 = currentVelocity.getSpeed();
        double xRec = this.getCollisionRectangle().getUpperLeft().getX();
        // check which part of the paddle was hit and determine the angle.
        if (collisionPoint.getX() >= (xRec + (0 * fragment)) && collisionPoint.getX() < (xRec + (1 * fragment))) {
            return v.fromAngleAndSpeed(160, v1);
        }
        if (collisionPoint.getX() >= (xRec + (1 * fragment)) && collisionPoint.getX() < (xRec + (2 * fragment))) {
            return v.fromAngleAndSpeed(130, v1);
        }
        if (collisionPoint.getX() >= (xRec + (2 * fragment)) && collisionPoint.getX() < (xRec + (3 * fragment))) {
            return v.fromAngleAndSpeed(50, v1);
        }
        if (collisionPoint.getX() >= (xRec + (3 * fragment)) && collisionPoint.getX() < (xRec + (4 * fragment))) {
            return v.fromAngleAndSpeed(20, v1);
        }
        return new Velocity(v.getdx(), -currentVelocity.getdy());
    }

    /**
     * adds paddle to the game.
     *
     * @param g game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}