import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * Sprite Collection class.
 */
public class SpriteCollection {
    //Memmbers
    private List<Sprite> sprites; //list of sprites.

    /**
     * new list.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>(); //initiallize array list.
    }

    /**
     * add.
     *
     * @param list list.
     */
    public void addAllToSprites(ArrayList list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                this.addSprite((Sprite) list.get(i));
            }
        }
    }

    /**
     * adds a sprite.
     *
     * @param s sprite.
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * remove sprite.
     *
     * @param s sprite.
     */
    public void deleteSprite(Sprite s) {
        sprites.remove(s);
    }

    /**
     * // call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).timePassed();
        }
    }

    /**
     * // call drawOn(d) on all sprites.
     *
     * @param d surface
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).drawOn(d);
        }
    }
}