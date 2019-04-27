import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Class GameEnviroment.
 */
public class GameEnvironment {
    //Members
    /**
     * Constructor.
     */
    private List<Collidable> collObjects;
    // add the given collidable to the environment.

    /**
     * Creates new Arraylist.
     */
    public GameEnvironment() {
        this.collObjects = new ArrayList<Collidable>();
    }

    /**
     * function that adds a colliadble.
     *
     * @param c colliadble to add.
     */
    public void addCollidable(Collidable c) {
        collObjects.add(c);
    }

    /**
     * func to delete a colliadble.
     *
     * @param c colliadble.
     */
    public void deleteColliadable(Collidable c) {
        collObjects.remove(c);
    }

    /**
     * @param trajectory trajectory.
     * @return CollisionInfo object that contains information about the collision.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Collidable> lines = new ArrayList<>();
        for (int i = 0; i < this.collObjects.size(); i++) {
            Collidable runningCollide = this.collObjects.get(i);
            Rectangle runningRect = runningCollide.getCollisionRectangle();
            if (trajectory.closestIntersectionToStartOfLine(runningRect) != null) {
                lines.add(runningCollide);
            } else {
                continue;
            }
        }
        Point closestPoint = null;
        Collidable closest = null;
        double min = -1;
        for (int i = 0; i < lines.size(); i++) {
            Collidable object = lines.get(i);
            Point colPoint = trajectory.closestIntersectionToStartOfLine(object.getCollisionRectangle());
            //we determine which point is the closest (which one will be the first collision).
            double currentDistance = colPoint.distance(trajectory.start());
            if (min == -1) {
                min = currentDistance;
                closest = object;
                closestPoint = colPoint;
            } else {
                if (currentDistance < min) {
                    min = currentDistance;
                    closest = object;
                    closestPoint = colPoint;
                }
            }
        }
        //if all points null.
        if (closestPoint == null && closest == null) {
            return null;
        }
        //return new collision info with the information.
        return new CollisionInfo(closestPoint, closest);
    }
}