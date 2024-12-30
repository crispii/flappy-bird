package hw1;

/**
 * A demo where a FallingBox falls from the top of the screen.
 */
public class FallingBoxDemo {
  private FallingBox fallingBox;

  /**
   * Private constructor to initialize the demo.
   */
  private FallingBoxDemo() {
    setUpCanvas();
    setUpGameObjects();
    runGameLoop();
  }

  /**
   * Main method.
   *
   * @param args command line arguments.
   */
  public static void main(String[] args) {
    new FallingBoxDemo();  // Instantiate the demo and run the game loop
  }

  /**
   * Set up the canvas with the desired settings.
   */
  private void setUpCanvas() {
    StdDraw.setCanvasSize(GameConstant.CANVAS_WIDTH, GameConstant.CANVAS_HEIGHT);
    StdDraw.setXscale(0, GameConstant.CANVAS_WIDTH);
    StdDraw.setYscale(0, GameConstant.CANVAS_HEIGHT);
    StdDraw.enableDoubleBuffering();
  }

  /**
   * Set up the game objects.
   */
  private void setUpGameObjects() {
    fallingBox = new FallingBox(
        200,
        GameConstant.CANVAS_HEIGHT - 50,
        GameConstant.FLAPPY_BOX_COLOR
    );
  }

  /**
   * Run the main game loop.
   */
  private void runGameLoop() {
    boolean isGameOver = false;
    while (!isGameOver) {
      StdDraw.clear(GameConstant.CANVAS_COLOR);
      moveGameObjects();
      drawGameObjects();
      StdDraw.show();
      StdDraw.pause(GameConstant.FRAME_DELAY);
      if (!fallingBox.isMovingDown()) {
        isGameOver = true;
      }
    }
  }

  /**
   * Move the game objects.
   */
  private void moveGameObjects() {
    fallingBox.move();
  }

  /**
   * Draw the game objects.
   */
  private void drawGameObjects() {
    fallingBox.draw();
  }
}
