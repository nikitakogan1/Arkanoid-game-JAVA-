
import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

/**
 * Count Down animation.
 */
public class CountdownAnimation implements Animation {
    private double seconds;
    private int start;
    private SpriteCollection sprites;
    private Sleeper sleeper = new Sleeper();
    private int count;
    private boolean aBoolean = true;


    /**
     * constructor.
     *
     * @param numOfSeconds seconds
     * @param countFrom    count
     * @param gameScreen   gamescreen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.seconds = numOfSeconds;
        this.start = countFrom;
        this.sprites = gameScreen;
        this.count = start;
    }

    /**
     * Animates the countdown.
     *
     * @param d d
     */
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        d.setColor(Color.magenta);
        d.drawText(650, 25, "Starting in: " + count + "", 20);
        long wait = (long) ((seconds / start) * 1000);
        if (aBoolean) {
            count--;
            this.aBoolean = false;
        } else {
            sleeper.sleepFor(wait);
            count--;
        }
    }

    /**
     * Stops the countdown when it ends.
     * @return boolean.
     */
    public boolean shouldStop() {
        return count < 0;
    }
}