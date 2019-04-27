import java.util.List;

/**
 * LevelInformation.
 */
public interface LevelInformation {
    /**
     * get background.
     *
     * @return background.
     */
    Sprite getBackground();

    /**
     * return number of balls.
     *
     * @return number of ballls.
     */
    int numberOfBalls();

    /**
     * return list of velocities.
     *
     * @return list
     */
    List<Velocity> initialBallVelocities();

    /**
     * paddle speed.
     *
     * @return paddle speed.
     */
    int paddleSpeed();

    /**
     * paddle width.
     *
     * @return paddleWidth.
     */
    int paddleWidth();

    /**
     * level name string.
     *
     * @return level name string.
     */
    String levelName();

    /**
     * return blocks.
     *
     * @return blocks.
     */
    List<Block> blocks();

    /**
     * number of blocks to remove.
     *
     * @return number of blocks to remove.
     */
    int numberOfBlocksToRemove();
}