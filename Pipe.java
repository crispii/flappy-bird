package hw1;

/**
 * A Pipe is a game object composed of multiple Boxes.
 */
public class Pipe extends Box {
  private Box[] boxes;
  private boolean flappyPassedThisPipe;

  /**
   * Constructs a Pipe.
   *
   * @param x coordinate of the top left corner.
   * @param y coordinate of the top left corner.
   */
  public Pipe(double x, double y) {
    super(x, y, GameConstant.PIPE_COLOR);
    flappyPassedThisPipe = false;
    setVelocity(GameConstant.PIPE_SPEED, 0); // Pipe moves horizontally only (to the left).
    placeBoxesInPipe();
    setBoxesSpeed();
  }

  // Place the boxes in the Pipe
  // Each pipe has a hole in the middle where the flappy box can pass through.
  // The hole is 2 boxes wide and is randomly placed.
  private void placeBoxesInPipe() {
    boxes = new Box[GameConstant.BOX_IN_PIPE];
    int hole = (int) Math.floor((Math.random() * (GameConstant.BOX_IN_PIPE - 3)) + 1);

    // Add the (GameConstant.BOX_IN_PIPE - 2) boxes
    // With one big hole (two missing boxes) at position 'hole' and 'hole + 1'
    for (int i = 0; i < GameConstant.BOX_IN_PIPE; i++) {
      if (i != hole && i != hole + 1) {
        boxes[i] = new Box(
            getX(),
            getY() - i * (GameConstant.BOX_LENGTH + GameConstant.BOX_SPACE),
            GameConstant.PIPE_COLOR
        );
      }
    }
  }

  // Set the speed of the boxes in the pipe.
  // Pre: the pipe speed is set.
  private void setBoxesSpeed() {
    for (Box box : boxes) {
      if (box != null) {
        box.setVelocity(getVelocityX(), getVelocityY());
      }
    }
  }

  /**
   * Checks if the flappy box has passed this pipe.
   *
   * @return true if the flappy box has passed this pipe, false otherwise.
   */
  public boolean isFlappyPassedThisPipe() {
    return flappyPassedThisPipe;
  }

  /**
   * Sets whether the flappy box has passed this pipe.
   *
   * @param flappyPassedThisPipe true if the flappy box has passed, false otherwise.
   */
  public void setFlappyPassedThisPipe(boolean flappyPassedThisPipe) {
    this.flappyPassedThisPipe = flappyPassedThisPipe;
  }

  @Override
  public double left() {
    return boxes.length == 0 ? left() : boxes[0].left();
  }

  @Override
  public double right() {
    return boxes.length == 0 ? right() : boxes[0].right();
  }

  @Override
  public void draw() {
    for (Box box : boxes) {
      if (box != null) {
        box.draw();
      }
    }
  }

  @Override
  public boolean intersects(Box other) {
    for (Box box : boxes) {
      if (box != null && box.intersects(other)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void move() {
    super.move();
    for (Box box : boxes) {
      if (box != null) {
        box.move();
      }
    }
  }
}