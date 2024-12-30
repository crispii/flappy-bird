package hw1;

import java.awt.event.KeyEvent;

/**
 * A demo where a FlappyBox can jump when the space key is pressed.
 */
public class FlappyBoxDemo {
  private FlappyBox flappyBox;

  /**
   * Private constructor to initialize the demo.
   */
  private FlappyBoxDemo() {
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
    new FlappyBoxDemo();  // Instantiate the demo and run the game loop
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
    flappyBox = new FlappyBox(
        200,
        GameConstant.CANVAS_HEIGHT - 50
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
    }
  }

  /**
   * Move the game objects.
   */
  private void moveGameObjects() {
    if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
      flappyBox.jump();
    }
    flappyBox.move();
  }

  /**
   * Draw the game objects.
   */
  private void drawGameObjects() {
    flappyBox.draw();
  }
}
