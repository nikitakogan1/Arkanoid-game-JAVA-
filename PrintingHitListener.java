/**
 * hit listerner printer.
 */
public class PrintingHitListener implements HitListener {
    /**
     * test.
     *
     * @param beingHit block.
     * @param hitter   ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block with " + beingHit.getHitPoints() + " points was hit.");
    }
}