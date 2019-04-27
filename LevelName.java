import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Level Name.
 */
public class LevelName implements Sprite {
    private String name;

    /**
     * level name.
     * @param s s
     */
    public LevelName(String s) {
        this.name = s;
    }

    /**
     * timepassed.
     */
    public void timePassed() {
        int x = 5;
    }

    /**
     * draw on.
     *
     * @param d surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        d.drawText(200, 15, "Level:" + " " + this.name, 15);
    }
}
