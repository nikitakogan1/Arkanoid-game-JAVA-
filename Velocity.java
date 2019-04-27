/**
 * @author Nikita Kogan
 * implementation of Velocity class.
 */
public class Velocity {
    //Members
    private double dx;
    private double dy;
    // constructor

    /**
     * initialize Velocity with dx and dy values.
     *
     * @param dx dx value
     * @param dy dy value
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * return dx value.
     *
     * @return this.dx
     */
    public double getdx() {
        return this.dx;
    }

    /**
     * return dy value.
     *
     * @return this.dy
     */
    public double getdy() {
        return this.dy;
    }

    /**
     * Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p point.
     * @return new Point(x,y)
     */
    public Point applyToPoint(Point p) {
        double x = p.getX();
        double y = p.getY();
        x += this.dx;
        y += this.dy;
        return new Point(x, y);
    }

    /**
     * returns velocity according to speed and angle.
     *
     * @param angle angle
     * @param speed speed
     * @return new Velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dy1 = Math.sin(Math.toRadians(-1 * angle)) * speed;
        double dx1 = Math.cos(Math.toRadians(angle)) * speed;
        return new Velocity(dx1, dy1);
    }

    /**
     * get speed.
     *
     * @return speed.
     */
    public double getSpeed() {
        return (Math.sqrt(this.getdx() * this.getdx() + this.getdy() * this.getdy()));
    }
}