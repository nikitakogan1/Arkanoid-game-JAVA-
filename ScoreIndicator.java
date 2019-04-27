import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Score Indicator.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * Constructor.
     *
     * @param s s
     */
    public ScoreIndicator(Counter s) {
        this.score = s;
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
        d.drawText(400, 15, "Score:" + " " + this.score.getValue(), 15);
    }
}
