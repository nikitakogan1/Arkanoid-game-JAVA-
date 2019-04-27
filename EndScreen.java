
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type End screen.
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private boolean wonTheGame;
    private int score;


    /**
     * Instantiates a new End screen.
     *
     * @param k          the keyboard
     * @param wonTheGame boolean - true if the player won the game, false otherwise.
     * @param score      the score of the player
     */
    public EndScreen(KeyboardSensor k, boolean wonTheGame, int score) {
        this.keyboard = k;
        this.stop = false;
        this.wonTheGame = wonTheGame;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        //if the player won
        if (wonTheGame) {
            d.drawText(10, d.getHeight() / 2, "You Win! Your score is:" + " " + this.score, 32);
            if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
                this.stop = true;
            }
            //if they didn't
        } else {
            d.drawText(10, d.getHeight() / 2, "Game Over. Your score is:" + " " + this.score, 32);
            if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
                this.stop = true;
            }
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}