import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Implementation of Block.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    //Members.
    private Rectangle rectangle;
    private Color color;
    private int hits;
    private List<HitListener> hitListeners;

    /**
     * Constructor.
     *
     * @param rec   rectangle
     * @param color color
     */
    public Block(Rectangle rec, Color color) {
        this.rectangle = rec;
        this.color = color;
        this.hits = 1;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * Another Constructor.
     *
     * @param rec   rectangle
     * @param color color
     * @param hits  number of hits
     */
    public Block(Rectangle rec, Color color, int hits) {
        this.hits = hits;
        this.rectangle = rec;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * @param collisionPoint  collision point
     * @param currentVelocity current velocity of the ball.
     * @param hitter ball.
     * @return new Velocity according to the collision point.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //hits the right edge of the block
        this.notifyHit(hitter);
        this.hits--;
        if (collisionPoint.equals(this.rectangle.getUpperLeft())
                || collisionPoint.equals(this.rectangle.getBottomLeft())
                || collisionPoint.equals(this.rectangle.getUpperRight())
                || collisionPoint.equals(this.rectangle.getBottomRight())) {
            return new Velocity(-1 * currentVelocity.getdx(), -1 * currentVelocity.getdy());
        }
        if (collisionPoint.getX() > this.rectangle.getBottomLeft().getX()
                && collisionPoint.getX() < this.rectangle.getBottomRight().getX()) {
            return new Velocity(currentVelocity.getdx(), -1 * currentVelocity.getdy());
        }
        if (collisionPoint.getY() > this.rectangle.getUpperLeft().getY()
                && collisionPoint.getY() < this.rectangle.getBottomLeft().getY()) {
            return new Velocity(-1 * currentVelocity.getdx(), currentVelocity.getdy());
        }
        return currentVelocity;
    }

    /**
     * function to draw on the screen.
     *
     * @param surface surface to draw on.
     */
    public void drawOn(DrawSurface surface) {
        Point upperleft = this.getCollisionRectangle().getUpperLeft();
        Line line = new Line(upperleft, this.getCollisionRectangle().getBottomRight());
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }

    /**
     * function to create a nice and colorfull game.
     *
     * @return randomcolor
     */
    public Color randomColor() {
        Random rand = new Random();
        java.awt.Color[] colors = {Color.ORANGE, Color.GREEN, Color.YELLOW, Color.RED, Color.PINK, Color.BLUE};
        return colors[rand.nextInt(4) + 0];
    }

    /**
     * func for next...
     */
    public void timePassed() {
        int x = 5;
    }

    /**
     * adds Block to game. makes it colliadble and sprite.
     *
     * @param game game envirmoent
     */
    public void add2game(GameLevel game) {
        game.addCollidable(this);
        game.addSprite(this);
    }

    /**
     * Remove a Block from the game.
     *
     * @param game game
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    /**
     * add listener.
     *
     * @param hl hl
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * remove listener.
     *
     * @param hl hl
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * notify hit.
     *
     * @param hitter hitter.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * return hits.
     *
     * @return hits.
     */
    public int getHitPoints() {
        return this.hits;
    }
}
