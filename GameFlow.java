
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * Game flow.
 */
public class GameFlow {

    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private Counter score;
    private Counter lives;
    private GUI gui;

    /**
     * constructor.
     *
     * @param gui             gui
     * @param animationRunner animationRunner.
     * @param keyboardSensor  Keyboard
     */
    public GameFlow(GUI gui, AnimationRunner animationRunner, KeyboardSensor keyboardSensor) {
        this.gui = gui;
        this.animationRunner = animationRunner;
        this.keyboardSensor = keyboardSensor;
        this.score = new Counter(0);
        this.lives = new Counter(7);
        LevelInformation levelOne = new Level1();
        LevelInformation levelTwo = new Level2();
        LevelInformation levelThree = new Level3();
        LevelInformation levelFour = new Level4();
        //game starts with 4 levels if no args are given
    }

    /**
     * the function runs the levels of the game from the list of levels.
     *
     * @param levels the levelsOfGame
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner,
                    this.score, this.lives, this.gui);
            level.initialize();
            while (level.getBlocksNum().getValue() != 0 && this.lives.getValue() != 0) {
                level.playOneTurn();
            }
            if (this.lives.getValue() == 0) {
                this.animationRunner.run(new EndScreen(this.keyboardSensor, false, this.score.getValue()));
                gui.close();
                System.exit(0);
            }
        }
        //player won the game
        this.animationRunner.run(new EndScreen(this.keyboardSensor, true, this.score.getValue()));
        gui.close();
        System.exit(0);
    }

}
