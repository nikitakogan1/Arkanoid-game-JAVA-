import biuoop.DrawSurface;

import java.util.ArrayList;

/**
 * Implementation of Line.
 *
 * @author Nikita Kogan.
 */
public class Line implements Sprite {
    // start, end are the start and end points of the line.
    private Point start;
    private Point end;

    /**
     * @param start maintain the starting point of line
     * @param end   maintain the ending point of line
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * constructor, creating 2 points then creating a line from between 2
     * points.
     *
     * @param x1 x1 value
     * @param y1 y1 value
     * @param x2 x2 value
     * @param y2 y2 value
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * function returns the length of the line.
     *
     * @return the length of the line.
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * function returns the middle point of the line.
     *
     * @return the middle point of the line.
     */
    public Point middle() {
        // Calculate the axis X of the middle point
        double middleX = (this.end.getX() + this.start.getX()) / 2;
        // Calculate the axis Y of the middle point
        double middleY = (this.end.getY() + this.start.getY()) / 2;
        // create the middle point from the middle X,Y and return her
        return new Point(middleX, middleY);
    }

    /**
     * @return the starting point of line
     */
    public Point start() {
        return this.start;
    }

    /**
     * function returns the ending point of line.
     *
     * @return the ending point of line
     */
    public Point end() {
        return this.end;
    }

    /**
     * function checks if there is intersection between 2 lines.
     *
     * @param other other line
     * @return if the input line have an intersection with the current line
     */
    public boolean isIntersecting(Line other) {
        // if other point doesn't intersect with this point, return false.
        // else , return true.
        if (intersectionWith(other) == null) {
            return false;
        }
        return true;
    }

    /**
     * @param other other line.
     * @return intersection point or null if there is no intersection.
     */
    public Point intersectionWith(Line other) {
        double x, y;
        double m1, m2;
        //check if slope is problematic.
        if (this.getSlope() == null) {
            if (other.getSlope() == null) {
                return null;
            }
            // update Incline of other line
            m2 = other.getSlope();
            // update the X and Y of the intersection point
            x = this.start.getX();
            y = m2 * (x - other.start.getX()) + other.start.getY();
            // else if just the incline of other line is undefined update X and
            // Y
        } else if (other.getSlope() == null) {
            /*
             * this.incline not null, because it would get into the first if
             * update the Incline of current line.
             */
            m1 = this.getSlope();
            // update the X and Y of the intersection point
            x = other.start.getX();
            y = m1 * (x - this.start.getX()) + this.start.getY();
        } else {
            m1 = this.getSlope();
            m2 = other.getSlope();
            if (m1 == m2) {
                return null;
            }
            x = (m2 * other.start.getX()) - other.start.getY() - (m1 * this.start.getX()) + this.start.getY();
            x /= (m2 - m1);
            y = this.start.getY() + m1 * (x - this.start.getX());
        }
        Point intersection = new Point(x, y);
        // if the intersection point is not on the lines return null.
        if (this.start.distance(intersection) > this.length()
                || this.end.distance(intersection) > this.length()
                || other.start.distance(intersection) > other.length()
                || other.end.distance(intersection) > other.length()) {
            return null;
        }
        return intersection;
    }

    /**
     * function check if both lines are equals.
     *
     * @param other - represents another line
     * @return if anther line equals this line
     */
    public boolean equals(Line other) {
        return (this.start.equals(other.start) && this.end.equals(other.end));
    }

    /**
     * function calculate the incline of this line.
     *
     * @return Incline
     */
    private Double getSlope() {
        // if slope undefined return null
        if (this.start.getX() == this.end.getX()) {
            return null;
        }
        // calculate the incline and return him
        return ((this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX()));
    }

    /**
     * @param rect rect
     * @return the collision point between given rectangle and this line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        @SuppressWarnings("unchecked")
        ArrayList<Point> intersections = (ArrayList<Point>) rect.intersectionPoints(this);
        if (intersections.size() > 0) {
            Point closest = intersections.get(0);
            for (int i = 1; i < intersections.size(); i++) {
                if (this.start.distance(intersections.get(i)) < this.start.distance(closest)) {
                    closest = intersections.get(i);
                }
            }
            return closest;
        }
        return null;
    }

    /**
     * draw sprite.
     *
     * @param d surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.drawLine((int) this.start().getX(), (int) this.start().getY(),
                (int) this.end().getX(), (int) this.end().getY());
    }

    /**
     * starts every object part at the game.
     */
    @Override
    public void timePassed() {

    }
}
