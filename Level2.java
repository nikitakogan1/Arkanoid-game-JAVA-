
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikita Kogan.
 * Level 2.
 */
public class Level2 implements LevelInformation {
    private List<Velocity> speeds = new ArrayList<>();
    private List<Block> blocks = new ArrayList<>();

    /**
     * number of balls.
     *
     * @return 10;
     */
    public int numberOfBalls() {
        return 10;
    }

    /**
     * sets velocity.
     *
     * @return balls speed.
     */
    public List<Velocity> initialBallVelocities() {
        for (int i = 0; i < this.numberOfBalls(); i++) {
            Velocity v = Velocity.fromAngleAndSpeed(70 + 12 * i, 5);
            speeds.add(v);
        }
        return speeds;
    }

    /**
     * paddle speed.
     *
     * @return speed.
     */
    public int paddleSpeed() {
        return 10;
    }

    /**
     * returns the width of the paddle.
     *
     * @return width.
     */
    public int paddleWidth() {
        return 350;
    }

    /**
     * name of level.
     *
     * @return string.
     */
    public String levelName() {
        return "Wide Easy";
    }

    /**
     * sets background.
     *
     * @return background.
     */
    public Sprite getBackground() {
        return new BackgroundType2();
    }

    /**
     * initiallize the blocks.
     *
     * @return blocks.
     */
    public List<Block> blocks() {
        for (int i = 1; i < 16; i++) {
            if (i < 8) {
                Block block = new Block(new Rectangle(new Point(47 * i, 300), 47, 20), Color.YELLOW, 1);
                blocks.add(block);
            }
            if (i >= 8) {
                Block block = new Block(new Rectangle(new Point(47 * i, 300), 47, 20), Color.YELLOW, 1);
                blocks.add(block);
            }
        }
        return blocks;

    }

    /**
     * number of blocks.
     *
     * @return 15
     */
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
