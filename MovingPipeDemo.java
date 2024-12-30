package hw1;

import java.util.ArrayList;
import java.util.List;

/**
 * A demo of moving pipes.
 */
public class MovingPipeDemo {
  private List<Pipe> pipes;

  /**
   * Private constructor to initialize the demo.
   */
  private MovingPipeDemo() {
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
    new MovingPipeDemo();  // Instantiate the demo and run the game loop
  }

  /**
   * Set up the canvas for the game.
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
    pipes = new ArrayList<>();
    pipes.add(
        new Pipe(
            GameConstant.CANVAS_WIDTH,
            GameConstant.CANVAS_HEIGHT - GameConstant.BOX_SPACE / 2.0
        )
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
      recyclePipes();
      StdDraw.show();
      StdDraw.pause(GameConstant.FRAME_DELAY);
    }
  }

  /**
   * Move the pipes.
   */
  private void moveGameObjects() {
    for (Pipe pipe : pipes) {
      pipe.move();
    }
  }

  /**
   * Draw the pipes.
   */
  private void drawGameObjects() {
    for (Pipe pipe : pipes) {
      pipe.draw();
    }
  }

  /**
   * Remove pipes that are out of the canvas and add new pipes.
   */
  private void recyclePipes() {
    if (pipes.get(0).right() <= 0) {
      pipes.remove(0);
    }

    if (pipes.get(pipes.size() - 1).right() <= GameConstant.CANVAS_WIDTH / 2.0) {
      double x = pipes.get(pipes.size() - 1).right() + GameConstant.CANVAS_WIDTH / 2.0;
      pipes.add(
          new Pipe(x,
              GameConstant.CANVAS_HEIGHT - GameConstant.BOX_SPACE / 2.0
          )
      );
    }
  }
}
