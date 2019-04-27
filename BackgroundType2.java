
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * The type Level two background.
 */
public class BackgroundType2 implements Sprite {

    /**
     * draw on.
     *
     * @param d surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.cyan);
        d.fillRectangle(20, 20, 800, 800);
        d.setColor(java.awt.Color.ORANGE);
        for (int i = 0; i < 50; i++) {
            d.drawLine(125, 125, i * 18, 300);
        }
        d.fillCircle(150, 125, 70);
        d.setColor(java.awt.Color.YELLOW);
        d.fillCircle(150, 125, 50);
    }

    /**
     * timepassed.
     */
    public void timePassed() {
    }
}

