import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;

/**
 * The type Background type 4.
 */
public class BackgroundType4 extends Background implements Sprite {
    //members
    private ArrayList<Circle> circles = new ArrayList<>();
    private ArrayList<Line> lines = new ArrayList<>();

    /**
     * Instantiates a new Background type 4.
     */
//constructor
    public BackgroundType4() {
        setCircles();
        setLines();
        super.setColor(new Color(45, 95, 134));
    }

    /**
     * Sets circles.
     */
    public void setCircles() {
        int x1 = 125;
        int y1 = 350;
        int radius = 35;
        for (int i = 0; i < 2; i++) {
            Circle circle = new Circle(x1, y1, radius, getColors().get(0));
            this.circles.add(circle);
            x1 += 500;
        }
        x1 = 175;
        y1 = 370;
        radius = 35;
        for (int i = 0; i < 2; i++) {
            Circle circle = new Circle(x1, y1, radius, getColors().get(1));
            this.circles.add(circle);
            x1 += 500;
        }
        x1 = 80;
        y1 = 370;
        radius = 35;
        for (int i = 0; i < 2; i++) {
            Circle circle = new Circle(x1, y1, radius, getColors().get(1));
            this.circles.add(circle);
            x1 += 500;
        }
        x1 = 115;
        y1 = 400;
        radius = 35;
        for (int i = 0; i < 2; i++) {
            Circle circle = new Circle(x1, y1, radius, getColors().get(0));
            this.circles.add(circle);
            x1 += 500;
        }
        x1 = 175;
        y1 = 400;
        radius = 30;
        for (int i = 0; i < 2; i++) {
            Circle circle = new Circle(x1, y1, radius, getColors().get(0));
            this.circles.add(circle);
            x1 += 500;
        }

    }

    /**
     * Gets colors.
     *
     * @return the colors
     */
    public ArrayList<Color> getColors() {
        ArrayList<Color> colors = new ArrayList<>();
        colors.add(Color.GRAY);
        colors.add(new Color(120, 117, 111));
        return colors;
    }

    /**
     * Sets lines.
     */
    public void setLines() {
        int x = 70;
        int y = 400;
        for (int i = 0; i < 20; i++) {
            Line line = new Line(new Point(x, y), new Point(x - 10, y + 140));
            lines.add(line);
            x += 7;
        }
        x = 570;
        y = 400;
        for (int i = 0; i < 20; i++) {
            Line line = new Line(new Point(x, y), new Point(x + 10, y + 140));
            lines.add(line);
            x += 7;
        }
    }

    /**
     * notify the sprite that time has passed.
     */
    public void timePassed() {

    }

    /**
     * draw the sprite to the screen.
     *
     * @param d drawsurface.
     */
    public void drawOn(DrawSurface d) {
        super.drawOn(d);
        d.setColor(Color.DARK_GRAY);
        for (int i = 0; i < lines.size(); i++) {
            lines.get(i).drawOn(d);
        }
        for (int i = 0; i < this.circles.size(); i++) {
            circles.get(i).drawOn(d);
            circles.get(i).fillCircle(d);
        }
    }
}