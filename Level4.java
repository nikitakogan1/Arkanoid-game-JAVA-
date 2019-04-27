
import java.util.ArrayList;
import java.util.List;

/**
 * Level 4.
 *
 * @author Nikita Kogan.
 */
public class Level4 implements LevelInformation {

    private List<Velocity> speeds = new ArrayList<>();
    private List<Block> blocks = new ArrayList<>();

    /**
     * number of balls.
     *
     * @return 3
     */
    public int numberOfBalls() {
        return 3;
    }

    /**
     * return speeds.
     *
     * @return speeds.
     */
    public List<Velocity> initialBallVelocities() {
        for (int i = 0; i < this.numberOfBalls(); i++) {
            Velocity v = Velocity.fromAngleAndSpeed(25 + 50 * i, 5);
            speeds.add(v);
        }
        return speeds;
    }

    /**
     * paddle speed.
     *
     * @return paddlespeed.
     */
    public int paddleSpeed() {
        return 5;
    }

    /**
     * paddle width.
     *
     * @return 80
     */
    public int paddleWidth() {


        return 120;
    }

    /**
     * level name.
     *
     * @return String.
     */
    public String levelName() {
        return "Final Hour";
    }

    /**
     * return background.
     *
     * @return background.
     */
    public Sprite getBackground() {
//        Sprite background = new Block(new Rectangle(new Point(0, 0), 800, 600), java.awt.Color.CYAN, 0);
//        return background;
        return new BackgroundType4();
    }

    /**
     * return blocks.
     *
     * @return blocks.
     */
    public List<Block> blocks() {
        for (int i = 1; i < 16; i++) {
            Block blocks1 = new Block(new Rectangle(new Point(47 * i, 100), 47, 20), java.awt.Color.RED, 1);
            blocks.add(blocks1);
        }
        for (int i = 1; i < 16; i++) {
            Block blocks2 = new Block(new Rectangle(new Point(47 * i, 120), 47, 20), java.awt.Color.ORANGE, 1);
            blocks.add(blocks2);

        }
        for (int i = 1; i < 16; i++) {
            Block blocks3 = new Block(new Rectangle(new Point(47 * i, 140), 47, 20), java.awt.Color.YELLOW, 1);
            blocks.add(blocks3);

        }
        for (int i = 1; i < 16; i++) {
            Block blocks4 = new Block(new Rectangle(new Point(47 * i, 160), 47, 20), java.awt.Color.BLUE, 1);
            blocks.add(blocks4);

        }
        for (int i = 1; i < 16; i++) {
            Block blocks5 = new Block(new Rectangle(new Point(47 * i, 180), 47, 20), java.awt.Color.GREEN, 1);
            blocks.add(blocks5);

        }

        for (int i = 1; i < 16; i++) {
            Block blocks6 = new Block(new Rectangle(new Point(47 * i, 200), 47, 20), java.awt.Color.PINK, 1);
            blocks.add(blocks6);

        }

        for (int i = 1; i < 16; i++) {
            Block blocks7 = new Block(new Rectangle(new Point(47 * i, 220), 47, 20), java.awt.Color.MAGENTA, 1);
            blocks.add(blocks7);

        }
        return blocks;
        /**
         * number of balls.
         * @return number of balls.
         */
    }

    /**
     * number of blocks.
     * @return 105
     */
    public int numberOfBlocksToRemove() {
        return 105;
    }
}
