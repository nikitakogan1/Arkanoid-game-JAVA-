import java.util.ArrayList;

/**
 * Implement of Rectangle.
 */
class Rectangle {
    //Members.
    private Point upperLeft;
    private Point bottomLeft;
    private Point upperRight;
    private Point bottomRight;
    private double width;
    private double height;
    private Line[] lines;

    /**
     * // Create a new rectangle with location and width/height.
     *
     * @param upperLeft upperleft
     * @param width     width
     * @param height    height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.bottomLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        this.upperRight = new Point(this.getUpperLeft().getX() + this.width, this.upperLeft.getY());
        this.bottomRight = new Point(this.upperRight.getX(), this.upperRight.getY() + this.height);
        this.lines = createLinesFromRectangle(this);
    }

    /**
     * // Return a (possibly empty) List of intersection points.
     * // with the specified line.
     *
     * @param line line.
     * @return List. list of intersection lines.
     */
    @SuppressWarnings("rawtypes")
    public java.util.List intersectionPoints(Line line) {
        ArrayList<Point> list = new ArrayList<Point>();
        //we create the points:
        Point p2 = new Point(upperLeft.getX() + width, upperLeft.getY());
        Point p3 = new Point(upperLeft.getX(), upperLeft.getY() + height);
        Point p4 = new Point(p3.getX() + width, p3.getY());
        Point intersectionpoint;
        //we make lines.
        Line l1 = new Line(upperLeft, p2);
        Line l2 = new Line(upperLeft, p3);
        Line l3 = new Line(p3, p4);
        Line l4 = new Line(p2, p4);
        Line[] listoflines = {l1, l2, l3, l4}; //we create an array of lines to store the lines of the rectangle.
        for (int i = 0; i < 4; i++) {
            intersectionpoint = listoflines[i].intersectionWith(line);
            if (intersectionpoint != null) {
                list.add(intersectionpoint);
            }
        }
        return list; //return list of intersection points.

    }

    /**
     * @param rectangle rectangle to check
     * @return lines. array of lines
     */
    public Line[] createLinesFromRectangle(Rectangle rectangle) {
        double upperLeftX = this.upperLeft.getX();
        double upperleftY = this.upperLeft.getY();
        Line[] lines2 = new Line[4];
        Point p1 = new Point(upperLeftX, upperleftY);
        Point p2 = new Point(upperLeftX + width, upperleftY);
        Point p3 = new Point(upperLeftX + width, upperleftY + height);
        Point p4 = new Point(upperLeftX, upperleftY + height);
        lines2[0] = new Line(p1, p2);
        lines2[1] = new Line(p1, p4);
        lines2[2] = new Line(p2, p3);
        lines2[3] = new Line(p3, p4);
        return lines2;
    }

    /**
     * this func creates lines for rectangle which will be a paddle.
     *
     * @param rectangle (this)
     * @return lines. list of lines
     */
    public Line[] linesForPaddle(Rectangle rectangle) {
        double upperLeftX = this.upperLeft.getX();
        double upperleftY = this.upperLeft.getY();
        Line[] lines3 = new Line[1];
        Point p1 = new Point(upperLeftX, upperleftY);
        Point p2 = new Point(upperLeftX + width, upperleftY);
        lines[0] = new Line(p1, p2);
        return lines;
    }

    /**
     * // Return the width and height of the rectangle.
     *
     * @return this.width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * returns height.
     *
     * @return this.height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * // Returns the upper-left point of the rectangle.
     *
     * @return this.upperLeft
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * getBottomLeft.
     *
     * @return this.bottomLeft bottomleft.
     */
    public Point getBottomLeft() {
        return this.bottomLeft;
    }

    /**
     * getUpperRight.
     *
     * @return this.upperRight.
     */
    public Point getUpperRight() {
        return this.upperRight;
    }

    /**
     * getBottomRight.
     *
     * @return this.bottomRight.
     */
    public Point getBottomRight() {
        return this.bottomRight;
    }

    /**
     * setUpperLeft.
     *
     * @param x x value.
     * @param y y value.
     */
    void setUpperLeft(double x, double y) {
        this.upperLeft = new Point(x, y);
    }
}