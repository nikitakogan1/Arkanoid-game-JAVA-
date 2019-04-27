/**
 * Animation interface.
 */

import biuoop.DrawSurface;

/**
 * Animation.
 */
public interface Animation {
    /**
     * do one frame.
     *
     * @param d d
     */
    void doOneFrame(DrawSurface d);

    /**
     * should stop.
     *
     * @return true/false.
     */
    boolean shouldStop();
}