/**
 * Implementation of BallRemover.
 */
public class BallRemover implements HitListener {
    //Memmbers.
    private Counter counter;
    private GameLevel  g;

    /**
     * Constructor.
     *
     * @param c    c
     * @param game game
     */
    public BallRemover(Counter c, GameLevel game) {
        this.counter = c;
        this.g = game;
    }

    /**
     * hitEvent.
     *
     * @param beingHit block.
     * @param hitter   ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.g.removeSprite(hitter);
        this.counter.decrease(1);
    }
}
