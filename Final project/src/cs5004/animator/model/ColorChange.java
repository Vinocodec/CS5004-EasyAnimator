package cs5004.animator.model;

import java.util.Map;

/**
 * This class represents one of the animations: Color change.
 */
public class ColorChange extends AbstractAnimation {

  private double beforeRed;
  private double beforeGreen;
  private double beforeBlue;
  private final double afterRed;
  private final double afterGreen;
  private final double afterBlue;


  /**
   * Create a new object of a colorChange animation.
   *
   * @param shapeList the map of all the shapes
   * @param name the name of the shape
   * @param startTime the start time of this animation
   * @param endTime the end time of this animation
   * @param beforeRed the red intensity before change
   * @param beforeGreen the green intensity before change
   * @param beforeBlue the blue intensity before change
   * @param afterRed the red intensity after change
   * @param afterGreen the green intensity after change
   * @param afterBlue the blue intensity after change
   * @throws IllegalArgumentException when input is invalid
   */
  public ColorChange(Map shapeList, String name, int startTime, int endTime,
          double beforeRed, double beforeGreen, double beforeBlue, double afterRed,
          double afterGreen, double afterBlue)
          throws IllegalArgumentException {
    
    super(shapeList, AnimationElement.COLORCHANGE, name, startTime, endTime);

    if (afterRed < 0 || afterBlue < 0 || afterGreen < 0
            || afterRed > 255 || afterBlue > 255 || afterGreen > 255 || beforeRed < 0
            || beforeRed > 255 || beforeBlue < 0 || beforeBlue > 255 || beforeGreen < 0
            || beforeGreen > 255) {
      throw new IllegalArgumentException(
          "Cannot create a color change animation because the input is invalid.");
    }

    this.shapeList = shapeList;
    this.name = name;
    this.beforeRed = beforeRed;
    this.beforeGreen = beforeGreen;
    this.beforeBlue = beforeBlue;
    this.afterRed = afterRed;
    this.afterGreen = afterGreen;
    this.afterBlue = afterBlue;
  }

  /**
   * Return true if the shape can perform the color change animation.
   *
   * @return true if can perform color change
   */
  private boolean canAction() {

    Shape shape = (Shape) this.shapeList.get(this.name);

    if ((this.beforeRed == this.afterRed && this.beforeBlue == this.afterBlue
            && this.beforeGreen == this.afterGreen)) {
      return false;
    }

    return this.getStartTime() >= shape.getAppears() && this.getEndTime() <= shape.getDisappears();
  }

  /**
   * Generate color change animation when the shape can make a color change.
   *
   * @throws IllegalArgumentException when the shape cannot make a color change
   */
  @Override
  public void generateAnimation() throws IllegalArgumentException {

    if (!canAction()) {
      throw new IllegalArgumentException("Cannot perform color change");
    }
    
    Shape shape = (Shape) this.shapeList.get(this.name);
    shape.setGreen(this.afterGreen);
    shape.setBlue(this.afterBlue);
    shape.setRed(this.afterRed);

  }
  
  

  public double getBeforeRed() {
    return beforeRed;
  }

  public double getBeforeGreen() {
    return beforeGreen;
  }

  public double getBeforeBlue() {
    return beforeBlue;
  }

  public double getAfterRed() {
    return afterRed;
  }

  public double getAfterGreen() {
    return afterGreen;
  }

  public double getAfterBlue() {
    return afterBlue;
  }

  /**
   * Return a string of the information of the animation.
   *
   * @return a string of the information of the animation
   */
  @Override
  public String toString() {
    String s = "Shape " + this.name + " changes color from (" + this.beforeRed
        + "," + this.beforeGreen + "," + this.beforeBlue
        + ") to (" + this.afterRed + "," + this.afterGreen + "," + this.afterBlue
        + ") from t=" + this.getStartTime() + " to t=" + this.getEndTime() + "\n";
    return s;
  }







}