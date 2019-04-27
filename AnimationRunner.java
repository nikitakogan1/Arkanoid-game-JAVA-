import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * Animation Runner.
 */
public class AnimationRunner {
    private GUI gui;
    private final int framesPerSecond = 60;

    /**
     * Constructor.
     *
     * @param gui gui.
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
    }

    /**
     * run.
     *
     * @param animation animation.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                biuoop.Sleeper sleeper = new Sleeper();
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}

