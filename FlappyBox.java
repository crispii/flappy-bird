package hw1;

/**
 * A FlappyBox is a FallingBox that can jump.
 */
public class FlappyBox extends FallingBox {
  protected double jumpVelocity;

  /**
   * Constructs a FlappyBox.
   *
   * @param x coordinate of the top left corner.
   * @param y coordinate of the top left corner.
   */
  public FlappyBox(double x, double y) {
    super(x, y, GameConstant.FLAPPY_BOX_COLOR);
    jumpVelocity = GameConstant.JUMP_VELOCITY;
  }

  /**
   * Gets the jump velocity of this FlappyBox.
   * @return the jump velocity.
   */
  public double getJumpVelocity() {
    return jumpVelocity;
  }

  /**
   * Sets the jump velocity of this FlappyBox.
   * @param jumpVelocity the jump velocity to set.
   */
  public void setJumpVelocity(double jumpVelocity) {
    this.jumpVelocity = jumpVelocity;
  }

  /**
   * Makes this FlappyBox jump up.
   */
  public void jump() {
    System.out.println("Jump!");
    setY(getY() + jumpVelocity);
    setFallingSpeed(GameConstant.FALLING_SPEED);
    setFallingAcceleration(GameConstant.GRAVITY);
  }
}