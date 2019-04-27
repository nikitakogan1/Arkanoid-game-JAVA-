import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * GameLevel Class.
 */
public class GameLevel implements Animation {
    //Members.
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter blockNum;
    private Counter ballsNum;
    private Counter score;
    private Counter lives;
    private Paddle gamePaddle;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation level;

    /**
     * initiallize game.
     * @param l l
     * @param gui gui
     * @param ar ar
     * @param info info
     * @param s s
     *@param k k
     */
    public GameLevel(LevelInformation info, KeyboardSensor k, AnimationRunner ar, Counter s, Counter l, GUI gui) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.blockNum = new Counter(0);
        this.ballsNum = new Counter(0);
        this.score = s;
        this.lives = l;
        this.runner = ar;
        this.keyboard = k;
        this.level = info;
        this.gui = gui;
    }

    /**
     * adds colliadble to the list.
     *
     * @param c c.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * adds sprite to the list.
     *
     * @param s sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * // Initialize a new game: create the Blocks and Ball (and Paddle).
     * // and add them to the game.
     * //this func creates all the object needed for the game.
     */
    public void initialize() {
        sprites.addSprite(level.getBackground());
        Rectangle newRec4 = new Rectangle(new Point(0, 0), 800, 20);
        Rectangle newRec5 = new Rectangle(new Point(780, 0), 20, 800);
        Rectangle newRec6 = new Rectangle(new Point(0, 0), 20, 800);
        Block block4 = new Block(newRec4, Color.GRAY);
        Block block5 = new Block(newRec5, Color.GRAY);
        Block block6 = new Block(newRec6, Color.GRAY);
        Block bottomBlock = new Block(new Rectangle(new Point(20, 600), 800, 20), Color.gray, 0);
        bottomBlock.add2game(this);
        HitListener ballremover = new BallRemover(this.ballsNum, this);
        HitListener scoreTrack = new ScoreTrackingListener(this.score);
        bottomBlock.addHitListener(ballremover);
        BlockRemover hitListener = new BlockRemover(this, blockNum);
        LivesIndicator lives1 = new LivesIndicator(this.lives);
        this.addSprite(lives1);
        block4.add2game(this);
        block5.add2game(this);
        block6.add2game(this);
        this.addSprite(lives1);
        ScoreIndicator indicator = new ScoreIndicator(this.score);
        this.addSprite(indicator);
        for (int i = 0; i < this.level.numberOfBlocksToRemove(); i++) {
            Block block1 = this.level.blocks().get(i);
            block1.add2game(this);
            block1.addHitListener(hitListener);
            block1.addHitListener(scoreTrack);
            this.blockNum.increase(1);
        }
        LevelName levelStr = new LevelName(this.level.levelName());
        this.sprites.addSprite(levelStr);
    }

    /**
     * // Run the game -- start the animation loop.
     */
    public void playOneTurn() {
        createBalls();
        createPaddle();
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.running = true;
        this.runner.run(this);
        if (this.blockNum.getValue() != 0) {
            this.lives.decrease(1);
        }
        this.removeSprite(this.gamePaddle);
        this.removeCollidable(this.gamePaddle);

    }

    /**
     * run func.
     */
    public void run() {
        while (true) {
            playOneTurn();
            if (this.ballsNum.getValue() == 0) {
                this.lives.decrease(1);
                this.removeCollidable(this.gamePaddle);
                this.removeSprite(this.gamePaddle);
                if (this.lives.getValue() == 0) {
                    gui.close();
                    System.exit(0);
                }
            }

        }
    }

    /**
     * remove colliadble.
     *
     * @param c d
     */
    public void removeCollidable(Collidable c) {
        this.environment.deleteColliadable(c);
    }

    /**
     * remove sprites.
     *
     * @param s s
     */
    public void removeSprite(Sprite s) {
        this.sprites.deleteSprite(s);
    }

    /**
     * creates the balls.
     */
    public void createBalls() {
        for (int i = 0; i < this.level.numberOfBalls(); i++) {
            Ball ball = new Ball(new Point(390 + 25 * i, 500), 4, java.awt.Color.BLACK, environment);
            this.ballsNum.increase(1);
            ball.add2game(this);
            ball.setVelocity(level.initialBallVelocities().get(i));
        }
    }

    /**
     * creates the paddle.
     */
    public void createPaddle() {
        Rectangle paddle = new Rectangle(new Point(350, 580), this.level.paddleWidth(), 10);
        Block block7 = new Block(paddle, Color.YELLOW);
        biuoop.KeyboardSensor sensor = gui.getKeyboardSensor();
        this.gamePaddle = new Paddle(sensor, block7, level.paddleSpeed(), level.paddleWidth());
        this.gamePaddle.addToGame(this);
    }

    /**
     * shouldstop.
     *
     * @return boolean.
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * do one frame.
     *
     * @param d d
     */
    public void doOneFrame(DrawSurface d) {
        this.sprites.notifyAllTimePassed();
        this.sprites.drawAllOn(d);
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new PauseScreen(this.keyboard));
        }
        if (this.blockNum.getValue() == 0) {
            this.score.increase(100);
            this.running = false;
        }
        if (this.ballsNum.getValue() == 0) {
            this.running = false;
        }
    }

    /**
     * getter.
     *
     * @return blocks num.
     */
    public Counter getBlocksNum() {
        return this.blockNum;
    }
}