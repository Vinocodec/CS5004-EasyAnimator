package cs5004.animator.model;

import java.util.Map;

/**
 * This class represents one of the animations: Scale.
 */
public class Scale extends AbstractAnimation {

  private double beforeHeight;
  private double beforeWidth;
  private double afterHeight;
  private double afterWidth;

  /**
   * Create a new object of a scale animation.
   *
   * @param shapeList the map of all the shapes
   * @param name the name of the shape
   * @param startTime the start time of this animation
   * @param endTime the end time of this animation
   * @param beforeHeight height of this shape before change
   * @param beforeWidth width of this shape before change
   * @param afterHeight height of this shape after change
   * @param afterWidth width of this shape after change
   * @throws IllegalArgumentException when the input is invalid
   */
  public Scale(Map shapeList, String name, int startTime, int endTime,
               double beforeWidth, double beforeHeight, double afterWidth, double afterHeight)
          throws IllegalArgumentException {
    super(shapeList, AnimationElement.SCALE, name, startTime, endTime);

    if (afterHeight <= 0 || afterWidth <= 0 || beforeHeight < 0 || beforeWidth < 0) {
      throw new IllegalArgumentException(
          "Cannot create a movement animation because the input is invalid.");
    }

    this.beforeHeight = beforeHeight;
    this.beforeWidth = beforeWidth;
    this.afterHeight = afterHeight;
    this.afterWidth = afterWidth;

  }

  /**
   * Return true if the shape can perform the scale animation.
   *
   * @return true if the shape can perform the scale animation.
   */
  private boolean canAction() {
    
    if (this.beforeWidth == this.afterWidth && this.beforeWidth == this.afterWidth) {
      return false;
    }
    Shape shape = (Shape) shapeList.get(name);
    return startTime >= shape.getAppears() && endTime <= shape.getDisappears();
  }

  /**
   * Perform scale if can do.
   * @throws IllegalArgumentException if cannot perform scale
   */
  @Override
  public void generateAnimation() throws IllegalArgumentException {
    if (canAction()) {
      Shape shape = (Shape) shapeList.get(name);
      shape.setHeight(this.afterHeight);
      shape.setWidth(this.afterWidth);
    }
    else {
      throw new IllegalArgumentException("Cannot perform scale");
    }
  }
  
  

  public double getBeforeHeight() {
    return beforeHeight;
  }

  public double getBeforeWidth() {
    return beforeWidth;
  }

  public double getAfterHeight() {
    return afterHeight;
  }

  public double getAfterWidth() {
    return afterWidth;
  }

  /**
   * Return a string of the information of the animation.
   *
   * @return a string of the information of the animation.
   */
  @Override
  public String toString() {
    String s = "Shape " + this.name + " scales from Width: " + this.beforeWidth  + ", Height: " 
        + this.beforeHeight + " to Width: " + this.afterWidth + ", Height: " 
        + this.afterHeight + " from t=" + this.getStartTime() + " to t="
        + this.getEndTime() + "\n";
    return s;
  }


}