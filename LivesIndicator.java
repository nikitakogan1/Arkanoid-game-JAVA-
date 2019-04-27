import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Lives Indicator.
 */
public class LivesIndicator implements Sprite {
    private Counter lives;

    /**
     * Constructor.
     *
     * @param s s
     */
    public LivesIndicator(Counter s) {
        this.lives = s;
    }

    /**
     * time passed.
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
        d.drawText(100, 15, "lives:" + " " + this.lives.getValue(), 15);
    }
}
