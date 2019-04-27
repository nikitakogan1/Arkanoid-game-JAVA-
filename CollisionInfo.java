/**
 * Implementation of Collision info.
 */
public class CollisionInfo {
    // the point at which the collision occurs.
    //Members
    private Point collPoint;
    private Collidable object;

    /**
     * Constructor.
     *
     * @param p      point
     * @param object colliadle.
     */
    public CollisionInfo(Point p, Collidable object) {
        this.collPoint = p;
        this.object = object;
    }

    /**
     * returns collision poit.
     *
     * @return collision point.
     */
    public Point collisionPoint() {
        return this.collPoint;
    }

    /**
     * // the collidable object involved in the collision.
     *
     * @return this.object.
     */
    public Collidable collisionObject() {
        return this.object;
    }
}