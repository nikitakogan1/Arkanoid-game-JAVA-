import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Circle Class.
 */
public class Circle implements Sprite {
    private int x;
    private int y;
    private int radius;
    private Color color;

    /**
     * Constructor.
     *
     * @param x1      x1
     * @param y1      y1
     * @param radius1 radious1
     * @param c       c
     */
    public Circle(int x1, int y1, int radius1, Color c) {
        this.x = x1;
        this.y = y1;
        this.radius = radius1;
        this.color = c;
    }

    /**
     * draw on.
     *
     * @param d surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.drawCircle(this.x, this.y, this.radius);
    }

    /**
     * fill circle.
     *
     * @param d d
     */
    public void fillCircle(DrawSurface d) {
        d.setColor(this.color);
        d.fillCircle(this.x, this.y, this.radius);
    }

    /**
     * for interface.
     */
    public void timePassed() {

    }
}

