/**
 * Score Tracking Listener.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor.
     *
     * @param scoreCounter counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * hit event.
     *
     * @param beingHit block.
     * @param hitter   ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getHitPoints() == 1) {
            this.currentScore.increase(15);
        } else {
            this.currentScore.increase(5);
        }
    }
}