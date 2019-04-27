import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Level 3.
 */
public class Level3 implements LevelInformation {

    private List<Velocity> speeds = new ArrayList<>();
    private List<Block> blocks = new ArrayList<>();

    /**
     * number of balls.
     *
     * @return 2
     */
    public int numberOfBalls() {
        return 2;
    }

    /**
     * return speeds.
     *
     * @return speeds.
     */
    public List<Velocity> initialBallVelocities() {
        for (int i = 0; i < this.numberOfBalls(); i++) {
            Velocity v = Velocity.fromAngleAndSpeed(133 + 130 * i, 5);
            speeds.add(v);
        }
        return speeds;
    }

    /**
     * return paddle speed.
     *
     * @return 10.
     */
    public int paddleSpeed() {
        return 10;
    }

    /**
     * paddle width.
     *
     * @return 80
     */
    public int paddleWidth() {
        return 80;
    }

    /**
     * return string.
     *
     * @return level name.
     */
    public String levelName() {
        return "Green 3";
    }

    /**
     * returns Background.
     *
     * @return background.
     */
    public Sprite getBackground() {
        return new BackgroundType3();
    }

    /**
     * return blocks.
     *
     * @return blocks.
     */
    public List<Block> blocks() {
        Block block;
        Color color = null;
        int numOfRows = 6;
        int numOfBlocks = 10;
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfBlocks; j++) {
                //the i value represents the rown number each row gets a diffrent color and hitpoints values.
                if (i == 0) {
                    color = Color.gray;
                } else if (i == 1) {
                    color = Color.red;
                } else if (i == 2) {
                    color = Color.yellow;
                } else if (i == 3) {
                    color = Color.blue;
                } else {
                    color = Color.white;
                }
                block = new Block(new Rectangle(new Point(720 - 60 * j, 150 + i * 20), 60, 20)
                        , color, 1);
                this.blocks.add(block);
            }
            numOfBlocks--;
        }
        return blocks;
    }


    /**
     * number of balls.
     *
     * @return number of balls.
     */
    public int numberOfBlocksToRemove() {
        return 40;
    }
}
