package cs5004.animator.model;

/**
 * Represents an animation.
 */
public interface Animation {

  /**
   * Return the name of this animation.
   *
   * @return the name of this animation
   */
  String getName();

  /**
   * Return the type of this animation.
   *
   * @return the type of this animation
   */
  AnimationElement getElement();

  /**
   * Return the start time of this animation.
   *
   * @return the start time of this animation
   */
  int getStartTime();

  /**
   * Return the end time of this animation.
   *
   * @return Return the start time of this animation
   */
  int getEndTime();

  /**
   * Perform this animation.
   */
  void generateAnimation() throws IllegalArgumentException;
  
  double getFromX();
  
  double getFromY();
  
  double getBeforeWidth();
  
  double getBeforeHeight();
  
  double getToX();
  
  double getToY();
  
  double getAfterWidth();
  
  double getAfterHeight();
  
  double getBeforeRed();
  
  double getBeforeGreen();
  
  double getBeforeBlue();
  
  double getAfterRed();
  
  double getAfterGreen();
  
  double getAfterBlue();



}