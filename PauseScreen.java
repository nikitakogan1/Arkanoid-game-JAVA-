import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * Pause.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * Pause Screen.
     *
     * @param k k
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * do one frame.
     *
     * @param d d
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * should stop.
     *
     * @return this.stop
     */
    public boolean shouldStop() {
        return this.stop;
    }
}