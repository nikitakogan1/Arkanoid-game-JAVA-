/**
 * Colliadble interface.
 */
public interface Collidable {
    // Return the "collision shape" of the object.

    /**
     * return the rectangle.
     *
     * @return collision rectangle
     */
    Rectangle getCollisionRectangle();

    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).

    /**
     * hit.
     *
     * @param hitter          hitter
     * @param collisionPoint  colpoint
     * @param currentVelocity current velocity
     * @return velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}