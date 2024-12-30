package hw1;

import java.awt.Color;

/**
 * A block is a game object with a rectangular bounding box.
 */
public abstract class Block implements GameObject {
  private double topLeftX;
  private double topLeftY;
  private final int width;
  private final int height;
  private final Color color;

  /**
   * Construct a block.
   * @param x coordinate of the top left corner.
   * @param y coordinate of the top left corner.
   * @param width of this block.
   * @param height of this block.
   * @param color of this block.
   */
  public Block(double x, double y, int width, int height, Color color) {
    this.topLeftX = x;
    this.topLeftY = y;
    this.width = width;
    this.height = height;
    this.color = color;
  }

  /**
   * Get the x coordinate of the top left corner.
   * @return the x coordinate.
   */
  public double getX() {
    return topLeftX;
  }

  /**
   * Get the y coordinate of the top left corner.
   * @return the y coordinate.
   */
  public double getY() {
    return topLeftY;
  }

  /**
   * Get the width of this block.
   * @return the width.
   */
  public int getWidth() {
    return width;
  }

  /**
   * Get the height of this block.
   * @return the height.
   */
  public int getHeight() {
    return height;
  }

  /**
   * Get the color of this block.
   * @return the color.
   */
  public Color getColor() {
    return color;
  }

  /**
   * Set the x coordinate of the top left corner.
   * @param x the new x coordinate.
   */
  protected void setX(double x) {
    this.topLeftX = x;
  }

  /**
   * Set the y coordinate of the top left corner.
   * @param y the new y coordinate.
   */
  protected void setY(double y) {
    this.topLeftY = y;
  }

  /**
   * Get the y coordinate of the top edge.
   * @return the y coordinate of the top edge.
   */
  public double top() {
    return topLeftY;
  }

  /**
   * Get the y coordinate of the bottom edge.
   * @return the y coordinate of the bottom edge.
   */
  public double bottom() {
    return topLeftY - height;
  }

  /**
   * Get the x coordinate of the left edge.
   * @return the x coordinate of the left edge.
   */
  public double left() {
    return topLeftX;
  }

  /**
   * Get the x coordinate of the right edge.
   * @return the x coordinate of the right edge.
   */
  public double right() {
    return topLeftX + width;
  }
}