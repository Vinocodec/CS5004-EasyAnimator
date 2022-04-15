package cs5004.animator.model;

/**
 * Represents an abstract shape.
 */
public class AbstractShape implements Shape {
  
  protected String name;
  protected ShapeType type;
  protected Coordinate coordinate;
  protected double width;
  protected double height;
  protected double red;
  protected double green;
  protected double blue;
  protected int appearsT;
  protected int disappearsT;

  /**
   * Create a new object of an abstract shape.
   *
   * @param name the name of the shape
   * @param coordinate the current coordinate of this shape
   * @param width the width of this shape
   * @param height the height of this shape
   * @param red the red intensity for this shape's color
   * @param green the green intensity for this shape's color
   * @param blue the blue intensity for this shape's color
   * @param appearsT the time that the shape appear
   * @param disappearsT the time that the shape disappear
   * @throws IllegalArgumentException when the input is invalid.
   */
  protected AbstractShape(String name, ShapeType type, Coordinate c, 
      double width, double height, double red, 
      double green, double blue, int appearsT, int disappearsT)
          throws IllegalArgumentException {

    if (c == null || name.equals("") || width < 0 || height < 0 || red < 0
            || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
      throw new IllegalArgumentException("Cannot build a shape because the input is invalid.");
    }

    this.name = name;
    this.type = type;
    this.coordinate = c;
    this.width = width;
    this.height = height;
    this.red = red;
    this.blue = blue;
    this.green = green;
    this.appearsT = appearsT;
    this.disappearsT = disappearsT;
  }

  /**
   * Return the name of the shape.
   *
   * @return the name of the shape.
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Return the current coordinate of the shape.
   *
   * @return the current coordinate of the shape.
   */
  @Override
  public Coordinate getCoordinate() {
    return this.coordinate;
  }


  /**
   * Return the width of the shape.
   *
   * @return the width of the shape
   */
  @Override
  public double getWidth() {
    return this.width;
  }


  /**
   * Return the height of the shape.
   *
   * @return the height of the shape
   */
  @Override
  public double getHeight() {
    return this.height;
  }

  /**
   * Return the red portion of this shape's color.
   *
   * @return the red portion of this shape's color
   */
  @Override
  public double getRed() {
    return this.red;
  }

  /**
   * Return the blue portion of this shape's color.
   *
   * @return the blue portion of this shape's color
   */
  @Override
  public double getBlue() {
    return this.blue;
  }

  /**
   * Return the green portion of this shape's color.
   *
   * @return the green portion of this shape's color
   */
  @Override
  public double getGreen() {
    return this.green;
  }

  /**
   * Return the time of the shape appear.
   *
   * @return the time of the shape appear.
   */
  @Override
  public int getAppears() {
    return this.appearsT;
  }

  /**
   * Return the time of the shape disappear.
   *
   * @return the time of the shape disappear.
   */
  @Override
  public int getDisappears() {
    return this.disappearsT;
  }

  /**
   * Set the red intensity of this shape color.
   *
   * @param newRed the updated red
   */
  public void setRed(double newRed) {
    this.red = newRed;
  }

  /**
   * Set the green intensity of this shape color.
   *
   * @param newGreen the updated green
   */
  public void setGreen(double newGreen) {
    this.green = newGreen;
  }

  /**
   * Set the blue intensity of this shape color.
   *
   * @param newBlue the updated blue
   */
  public void setBlue(double newBlue) {
    this.blue = newBlue;
  }

  /**
   * Set the width of this shape.
   *
   * @param newWidth the updated width
   */
  public void setWidth(double newWidth) {
    this.width = newWidth;
  }

  /**
   * Set the height of this shape.
   *
   * @param newHeight the updated height
   */
  public void setHeight(double newHeight) {
    this.height = newHeight;
  }

  /**
   * Set the coordinate of this shape.
   *
   * @param x the new x-coordinates of this shape
   * @param y the new y-coordinates of this shape
   */
  public void setCoordinate(double x, double y) {
    this.coordinate.setPosition(x, y);
  }

  @Override
  public ShapeType getShapeType() {
    return this.type;
  }

  @Override
  public double getX() {
    return this.getCoordinate().getX();
  }

  @Override
  public double getY() {
    return this.getCoordinate().getY();
  }


}
