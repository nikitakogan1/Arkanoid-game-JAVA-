
/**
 * @author Nikita Kogan
 * implementation of Point class.
 */
public class Point {
    // Members
    private double x; //point x value
    private double y; //point y value
    // Constructor

    /**
     * @param x x value
     * @param y y value
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    // Access methods

    /**
     * @return this.x x value
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return this.y y value
     */
    public double getY() {
        return this.y;
    }

    /**
     * func to return distance from point to point.
     *
     * @param other other point to compare
     * @return distance
     */
    public double distance(Point other) {
        double x1 = this.getX();
        double x2 = other.getX();
        double y1 = this.getY();
        double y2 = other.getY();
        return Math.sqrt((x1 - (x2)) * (x1 - (x2)) + ((y1 - (y2)) * (y1 - (y2)))); //calculate the distance.
    }

    /**
     * returns true if the points are the same,else returns false.
     *
     * @param other other point to compare
     * @return false or true
     */
    public boolean equals(Point other) {
        if (this.x == other.getX()) {
            if (this.y == other.getY()) {
                return true; //func check if x and y values are the same.
            }
            return false;
        }
        return false;
    }
}