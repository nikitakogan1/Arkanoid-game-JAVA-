import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * Ass3Game class responsible for building and running the Game.
 * @author Nikita Kogan.
 */
public class Ass5Game {
    /**
     * main method running the class.
     *
     * @param args **array of Strings with names of arguments passed from command prompt**
     */
    public static void main(String[] args) {
        GUI gui = new GUI("hello", 800, 600);
        AnimationRunner runner = new AnimationRunner(gui);
        biuoop.KeyboardSensor keybord = gui.getKeyboardSensor();
        GameFlow gameFlow = new GameFlow(gui, runner, keybord);
        List<LevelInformation> levels = new ArrayList<>();
        if (args.length == 0) {
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.add(new Level4());
            //if args are given add the matching levels to them.
        } else {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("1")) {
                    levels.add(new Level1());
                }
                if (args[i].equals("2")) {
                    levels.add(new Level2());
                }
                if (args[i].equals("3")) {
                    levels.add(new Level3());
                }
                if (args[i].equals("4")) {
                    levels.add(new Level4());
                }
            }

        }
        gameFlow.runLevels(levels);
    }
}
