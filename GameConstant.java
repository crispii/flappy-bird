package hw1;

import java.awt.Color;

/**
 * A class containing all the constants used in the game.
 */
public final class GameConstant {
  /** Color of the game canvas. */
  public static final Color CANVAS_COLOR = Color.decode("#71C5CF");

  /** Width of the game canvas. */
  public static final int CANVAS_WIDTH = 800;

  /** Height of the game canvas. */
  public static final int CANVAS_HEIGHT = 960;

  /** Delay between frames in milliseconds. */
  public static final int FRAME_DELAY = 20;

  /** Color of the text in the game. */
  public static final Color TEXT_COLOR = Color.RED;

  /** Initial falling speed of the flappy box. */
  public static final double FALLING_SPEED = -2;

  /** Acceleration due to gravity. */
  public static final double GRAVITY = -0.5;

  /** Upward velocity when the flappy box jumps. */
  public static final double JUMP_VELOCITY = 10;

  /** Color of the flappy box. */
  public static final Color FLAPPY_BOX_COLOR = Color.decode("#E0D796");

  /** Number of boxes in a pipe. */
  public static final int BOX_IN_PIPE = 8;

  /** Color of the pipes. */
  public static final Color PIPE_COLOR = Color.decode("#538c22");

  /** Speed at which pipes move. */
  public static final double PIPE_SPEED = -6;

  /** Length of each box. */
  public static final int BOX_LENGTH = 100;

  /** Space between boxes. */
  public static final int BOX_SPACE = 20;

  // Private constructor to prevent instantiation
  private GameConstant() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }
}