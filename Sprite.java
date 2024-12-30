package hw1;

import java.awt.Color;

/**
 * A Sprite is a Block that can move.
 */
public abstract class Sprite extends Block {
  private double velocityX;
  private double velocityY;
  private double accelerationX;
  private double accelerationY;

  private double lastX;
  private double lastY;

  /**
   * Construct a sprite.
   * At the beginning, the speed and acceleration of this sprite are 0.
   *
   * @param x coordinate of the top left corner.
   * @param y coordinate of the top left corner.
   * @param width of this sprite.
   * @param height of this sprite.
   * @param color of this sprite.
   */
  public Sprite(double x, double y, int width, int height, Color color) {
    super(x, y, width, height, color);
    velocityX = 0;
    velocityY = 0;
    accelerationX = 0;
    accelerationY = 0;

    lastX = x;
    lastY = y;
  }

  /**
   * Get the horizontal speed of this Sprite.
   * @return the horizontal speed.
   */
  public double getVelocityX() {
    return velocityX;
  }

  /**
   * Get the vertical speed of this Sprite.
   * @return the vertical speed.
   */
  public double getVelocityY() {
    return velocityY;
  }

  /**
   * Get the horizontal acceleration of this Sprite.
   * @return the horizontal acceleration.
   */
  public double getAccelerationX() {
    return accelerationX;
  }

  /**
   * Get the vertical acceleration of this Sprite.
   * @return the vertical acceleration.
   */
  public double getAccelerationY() {
    return accelerationY;
  }

  /**
   * Set the speed of this Sprite.
   * @param dx displacement on the X axis.
   * @param dy displacement on the Y axis.
   */
  public void setVelocity(double dx, double dy) {
    velocityX = dx;
    velocityY = dy;
  }

  /**
   * Set the acceleration of this Sprite.
   * @param ax acceleration on the X axis.
   * @param ay acceleration on the Y axis.
   */
  public void setAcceleration(double ax, double ay) {
    accelerationX = ax;
    accelerationY = ay;
  }

  /**
   * Update the coordinates of this Sprite based on its speed.
   */
  public void move() {
    // Save current position
    lastX = getX();
    lastY = getY();

    // Update position with the current speed
    super.setX(lastX + velocityX);
    super.setY(lastY + velocityY);

    // Update speed with acceleration
    velocityX += accelerationX;
    velocityY += accelerationY;
  }

  /**
   * Check if this Sprite is moving left.
   * @return true if this Sprite is moving left, false otherwise.
   */
  public boolean isMovingLeft() {
    return (getX() - lastX) < 0;
  }

  /**
   * Check if this Sprite is moving right.
   * @return true if this Sprite is moving right, false otherwise.
   */
  public boolean isMovingRight() {
    return (getX() - lastX) > 0;
  }

  /**
   * Check if this Sprite is moving up.
   * @return true if this Sprite is moving up, false otherwise.
   */
  public boolean isMovingUp() {
    // This works for StdDraw because the (0,0) is in the bottom left corner of canvas.
    return (getY() - lastY) > 0;
  }

  /**
   * Check if this Sprite is moving down.
   * @return true if this Sprite is moving down, false otherwise.
   */
  public boolean isMovingDown() {
    // This works for StdDraw because the (0,0) is in the bottom left corner of canvas.
    return (getY() - lastY) < 0;
  }
}
