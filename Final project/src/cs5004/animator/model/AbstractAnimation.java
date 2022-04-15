package cs5004.animator.model;

import java.util.Map;

/**
 * Represents an abstract animation.
 */
public class AbstractAnimation implements Animation {
  protected int startTime;
  protected int endTime;
  protected String name;
  protected AnimationElement animationElement;
  protected Map shapeList;

  /**
   * Create a new object of an AbstractAnimation.
   *
   * @param shapeList the map of all the shapes
   * @param animationsElement the animation's type
   * @param name the name of the shape that generates animation
   * @param startTime the start time of this animation
   * @param endTime the end time of this animation
   * @throws IllegalArgumentException if input is invalid or out of range
   */
  protected AbstractAnimation(Map shapeList, AnimationElement animationElement, String name,
                            int startTime, int endTime)
          throws IllegalArgumentException {
    if (shapeList == null || animationElement == null || name.equals("") || startTime < 0
            || endTime < 0) {
      throw new IllegalArgumentException(
          "Cannot generate an animation, because the input is invalid.");
    }
    this.shapeList = shapeList;
    this.animationElement = animationElement;
    this.name = name;
    this.startTime = startTime;
    this.endTime = endTime;
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
   * Return the type of the animation.
   *
   * @return the type of the animation.
   */
  @Override
  public AnimationElement getElement() {
    return this.animationElement;
  }

  /**
   * Return the start time of this animation.
   *
   * @return the start time of this animation
   */
  @Override
  public int getStartTime() {
    return this.startTime;
  }

  /**
   * Return the end time of this animation.
   *
   * @return the end time of this animation
   */
  @Override
  public int getEndTime() {
    return this.endTime;
  }

  /**
   * Generate the animation.
   */
  @Override
  public void generateAnimation() throws IllegalArgumentException {
    //generate the animation
  }

  @Override
  public double getFromX() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double getFromY() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double getBeforeWidth() {
    // TODO Auto-generated method stub
    return 100;
  }

  @Override
  public double getBeforeHeight() {
    // TODO Auto-generated method stub
    return 100;
  }

  @Override
  public double getToX() {
    // TODO Auto-generated method stub
    return 10;
  }

  @Override
  public double getToY() {
    // TODO Auto-generated method stub
    return 10;
  }

  @Override
  public double getAfterWidth() {
    // TODO Auto-generated method stub
    return 100;
  }

  @Override
  public double getAfterHeight() {
    // TODO Auto-generated method stub
    return 100;
  }

  @Override
  public double getBeforeRed() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double getBeforeGreen() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double getBeforeBlue() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double getAfterRed() {
    // TODO Auto-generated method stub
    return 1;
  }

  @Override
  public double getAfterGreen() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double getAfterBlue() {
    // TODO Auto-generated method stub
    return 0;
  }


}
