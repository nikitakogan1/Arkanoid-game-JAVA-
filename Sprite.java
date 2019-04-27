import biuoop.DrawSurface;

/**
 * Sprite.
 */
public interface Sprite {
    // draw the sprite to the screen

    /**
     * draw sprite.
     *
     * @param d surface.
     */
    void drawOn(DrawSurface d);
    // notify the sprite that time has passed

    /**
     * starts every object part at the game.
     */
    void timePassed();
}