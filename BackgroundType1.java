import java.awt.Color;
import java.util.ArrayList;

/**
 * Backgroundtype1.
 */
public class BackgroundType1 extends Background implements Sprite {
    //members
    private ArrayList<Circle> circles = new ArrayList<>();
    private ArrayList<Line> lines = new ArrayList<>();

    /**
     * BackGround type 1 Constructor.
     */
    public BackgroundType1() {
        super.setColor(Color.BLUE);
        initializeCircles();
        initializeLines();
        super.setElements(this.circles);
        super.setElements(this.lines);
    }

    /**
     * initiallize.
     */
    public void initializeCircles() {
        int radius = 150;
        for (int i = 0; i < 3; i++) {
            Circle c = new Circle(400, 300, radius, Color.YELLOW); //check
            circles.add(c);
            radius -= 40;
        }
    }

    /**
     * initiallize.
     */
    public void initializeLines() {
        lines.add(new Line(new Point(400, 100), new Point(400, 500)));
        lines.add(new Line(new Point(200, 300), new Point(600, 300)));
    }

    /**
     * time passed.
     */
    public void timePassed() {
        int x = 5;
    }
}