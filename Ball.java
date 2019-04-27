import biuoop.DrawSurface;

/**
 * @author Nikita Kogan
 * implementation of Ball class.
 */
public class Ball implements Sprite {
    //Members
    private Point center;
    private int radious;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    // constructor

    /**
     * .
     * Ball Class.
     *
     * @param center point of center
     * @param r      radious of ball
     * @param color  ball's color
     * @param game   game enviroment.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment game) {
        this.center = center;
        this.radious = r;
        this.color = color;
        this.gameEnvironment = game;
    }

    /**
     * second constructor.
     *
     * @param center point center of the ball
     * @param r      radious of ball
     * @param color  balls color
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.radious = r;
        this.color = color;
        //in this constructor we put zero to the limits.
    }
    // accessors

    /**
     * get x value of the ball.
     *
     * @return (int) this.center.getX()
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * returns the y value of the ball.
     *
     * @return (int) this.center.getY()
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * returns the ball radious.
     *
     * @return this.radious balls radious
     */
    public int getSize() {
        return this.radious;
    }

    /**
     * returns ball color.
     *
     * @return this.color
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * func for draw.
     *
     * @param surface gets surface to draw on
     */
    // draw the ball on the given DrawSurface
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.radious);
    }

    /**
     * sets velocity.
     *
     * @param v velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * sets velocity with dx and dy values.
     *
     * @param dx dx value
     * @param dy dy value
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * returns ball's velocity.
     *
     * @return this.velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * a function for the ball to collide with blocks. velocity is changed according to the direction.
     */
    public void moveOneStep() {
        Line trajectory = new Line(this.center, this.getVelocity().applyToPoint(this.center));
        //if no collision will happen.
        if (this.gameEnvironment.getClosestCollision(trajectory) == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
        } else { //else we need to move the ball to "epsilon" (small) location before the hit and
            //change his velocity.
            double epsilonX;
            double epsilonY;
            //check for collision points.
            Point collisionPoint = this.gameEnvironment.getClosestCollision(trajectory).collisionPoint();
            if (this.center.getX() > collisionPoint.getX()) {
                epsilonX = 1.00;
            } else {
                epsilonX = -1.00;
            }
            if (this.center.getY() > collisionPoint.getY()) {
                epsilonY = 1.00;
            } else {
                epsilonY = -1.00;
            }
            //we change the center
            this.center = new Point(collisionPoint.getX() + epsilonX, collisionPoint.getY() + epsilonY);
            Velocity v = this.gameEnvironment.getClosestCollision(trajectory).collisionObject().hit(this,
                    collisionPoint, this.velocity);
            this.setVelocity(v);
        }
    }

    /**
     * sets velocity with the following parameters.
     *
     * @param angle ball angle
     * @param speed balls speed
     * @return new Velocity(dx,dy)
     */
    public Velocity fromAngleAndSpeed(double angle, double speed) {
        double dy = Math.sin(Math.toRadians(-1 * angle)) * speed;
        double dx = Math.cos(Math.toRadians(angle)) * speed;
        return new Velocity(dx, dy);
    }

    /**
     * calls for moveOneStep.
     */
    public void timePassed() {
        moveOneStep();
    }

    /**
     * adds ball to the game.
     *
     * @param game game enviroment.
     */
    public void add2game(GameLevel game) {
        game.addSprite(this);
    }

    /**
     * remove from game.
     * @param g g
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}
