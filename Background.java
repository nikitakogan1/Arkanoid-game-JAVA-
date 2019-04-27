import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Background.
 */
public abstract class Background implements Sprite {
    //members
    private Color color;
    private SpriteCollection elements = new SpriteCollection();

    /**
     * getColor.
     *
     * @return color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * spritecollection.
     *
     * @return elements.
     */
    public SpriteCollection getElements() {
        return elements;
    }

    /**
     * setcolor.
     *
     * @param c c
     */
    public void setColor(Color c) {
        this.color = c;
    }

    /**
     * set elements.
     *
     * @param sprites sprites.
     */
    public void setElements(ArrayList sprites) {
        this.elements.addAllToSprites(sprites);
    }

    /**
     * draw on.
     *
     * @param d surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(getColor());
        d.drawRectangle(0, 0, d.getWidth(), d.getHeight());
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        this.elements.drawAllOn(d);
    }

}