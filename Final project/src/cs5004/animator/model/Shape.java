package cs5004.animator.model;

/**
 * Represents the a Shape.
 */
public interface Shape {

  /**
   * Return the time that this shape appear.
   *
   * @return the time that this shape appear
   */
  int getAppears();

  /**
   * Return the time that this shape disappear.
   *
   * @return the time that this shape disappear
   */
  int getDisappears();

  /**
   * Return the name of the shape.
   *
   * @return the name of the shape
   */
  String getName();

  /**
   * Set the coordinate of this shape.
   *
   * @param x the new x-coordinates of this shape
   * @param y the new y-coordinates of this shape
   */
  void setCoordinate(double x, double y);
  
  /**
   * Return the current coordinate of the shape.
   *
   * @return the current coordinate of the shape
   */
  Coordinate getCoordinate();
  
  /**
   * Return the coordinate x of the shape.
   *
   * @return the coordinate x of the shape
   */
  double getX();
  
  /**
   * Return the coordinate y of the shape.
   *
   * @return the coordinate y of the shape
   */
  double getY();

  /**
   * Return the width of the shape.
   *
   * @return the width of the shape
   */
  double getWidth();

  /**
   * Return the height of the shape.
   *
   * @return the height of the shape
   */
  double getHeight();

  /**
   * Return the red portion of this shape's color.
   *
   * @return the red portion of this shape's color
   */
  double getRed();

  /**
   * Return the blue portion of this shape's color.
   *
   * @return the blue portion of this shape's color
   */
  double getBlue();

  /**
   * Return the green portion of this shape's color.
   *
   * @return the green portion of this shape's color
   */
  double getGreen();

  /**
   * Set the red intensity of this shape color.
   * 
   * @param newRed the updated red
   */
  void setRed(double newRed);

  /**
   * Set the green intensity of this shape color.
   *
   * @param newGreen the updated green
   */
  void setGreen(double newGreen);

  /**
   * Set the blue intensity of this shape color.
   *
   * @param newBlue the updated blue
   */
  void setBlue(double newBlue);

  /**
   * Set the width of this shape.
   *
   * @param newWidth the updated width
   */
  void setWidth(double newWidth);

  /**
   * Set the height of this shape.
   *
   * @param newHeight the updated height
   */
  void setHeight(double newHeight);
  
  /**
   * Return the type of this shape.
   *
   * @return the type of this shape
   */
  ShapeType getShapeType();

  

}
