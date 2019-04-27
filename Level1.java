
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Level 1.
 */
public class Level1 implements LevelInformation {
    private List<Velocity> speeds = new ArrayList<>();
    private List<Block> blocks = new ArrayList<>();

    /**
     * number of balls in game.
     *
     * @return 1
     */
    public int numberOfBalls() {
        return 1;
    }

    /**
     * initiallize ball velocities.
     *
     * @return list
     */
    public List<Velocity> initialBallVelocities() {
        Velocity v = Velocity.fromAngleAndSpeed(90, 5);
        speeds.add(v);
        return speeds;
    }

    /**
     * padle speed.
     *
     * @return 7
     */
    public int paddleSpeed() {
        return 7;
    }

    /**
     * paddle witth.
     *
     * @return 80
     */
    public int paddleWidth() {
        return 80;
    }

    /**
     * level name.
     *
     * @return String
     */
    public String levelName() {
        return "Direct Hit";
    }

    /**
     * return background.
     *
     * @return background.
     */
    public Sprite getBackground() {
        return new BackgroundType1();
    }

    /**
     * return blocks.
     *
     * @return blocks.
     */
    public List<Block> blocks() {
        for (int i = 0; i < this.numberOfBlocksToRemove(); i++) {
            Block block = new Block(new Rectangle(new Point(375, 280), 50, 20), Color.GREEN, 1);
            this.blocks.add(block);
        }
        return this.blocks;
    }

    /**
     * return number of blocks.
     *
     * @return 1
     */
    public int numberOfBlocksToRemove() {
        return 1;
    }

}
