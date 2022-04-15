package cs5004.animator.model;

/**
 * This class represents an Oval.
 */
public class Oval extends AbstractShape {

  /**
   * Create a new object of an oval.
   *
   * @param name the name of this shape
   * @param c the coordinate of this shape
   * @param width the width of this shape
   * @param height the height of this shape
   * @param red the red intensity for this shape's color
   * @param green the green intensity for this shape's color
   * @param blue the blue intensity for this shape's color
   * @param appearsT the time of the shape appear
   * @param disappearsT the time of the shape disappear
   */
  public Oval(String name, ShapeType type, Coordinate c, double width, double height, double red,
              double green, double blue, int appearsT, int disappearsT) {
    super(name, ShapeType.Oval, c, width, height, red, green, blue, appearsT, disappearsT);
  }

  /**
   * Return a string of the information of the shape.
   *
   * @return a string of the information of the shape.
   */
  @Override
  public String toString() {
    String s = "Name: " + this.getName() + "\nType: oval\nCenter: (" + this.coordinate.getX()
        + "," + this.coordinate.getY() + "), X radius: " + this.getWidth() + ", Y radius: "
        + this.getHeight() + ", Color: (" + this.getRed() + "," + this.getGreen() + ","
        + this.getBlue() + ")\nAppears at t=" + this.getAppears() + "\nDisappears at t="
        + this.getDisappears() + "\n";
    return s;
  }


}