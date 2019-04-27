/**
 * Implementation of BlockRemover.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor.
     *
     * @param game          game
     * @param removedBlocks removedblocks
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    // Blocks that are hit and reach 0 hit-points should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.

    /**
     * hit event.
     *
     * @param beingHit block.
     * @param hitter   ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getHitPoints() == 1) {
            beingHit.removeFromGame(this.game);
            beingHit.removeHitListener(this);
            this.remainingBlocks.decrease(1);
        }
    }
}