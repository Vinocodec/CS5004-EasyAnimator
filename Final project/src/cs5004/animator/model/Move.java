package cs5004.animator.model;

import java.util.Map;

/**
 * This class represents one of the animations: movement.
 */
public class Move extends AbstractAnimation {
  private double fromX;
  private double fromY;
  private double toX;
  private double toY;

  /**
   * Create a new object of a movement animation.
   *
   * @param shapeList the map of all the shapes
   * @param name the name of the shape
   * @param startTime the start time of this animation
   * @param endTime the end time of this animation
   * @param fromX the x-coordinate before move
   * @param fromY the y-coordinate before move
   * @param toX the x-coordinate after move
   * @param toY the y-coordinate after move
   * @throws IllegalArgumentException when the position input is invalid
   */
  public Move(Map shapeList, String name, int startTime, int endTime, double fromX, double fromY,
              double toX, double toY) throws IllegalArgumentException {
    super(shapeList, AnimationElement.MOVE, name, startTime, endTime);

    this.fromX = fromX;
    this.fromY = fromY;
    this.toX = toX;
    this.toY = toY;

  }

  /**
   * Return true if the shape can perform the movement animation.
   *
   * @return true if can perform move.
   */
  private boolean canAction() {
    
    if (this.fromX == this.toX && this.fromY == this.toY) {
      return false;
    }
    Shape shape = (Shape) this.shapeList.get(this.name);
    return startTime >= shape.getAppears() && endTime <= shape.getDisappears();

  }

  /**
   * Perform move position if can do.
   *
   * @throws IllegalArgumentException if cannot perform move
   */
  @Override
  public void generateAnimation() throws IllegalArgumentException {
    if (canAction()) {
      Shape shape = (Shape) this.shapeList.get(this.name);
      shape.setCoordinate(toX, toY);
    }
    else {
      throw new IllegalArgumentException("Cannot perform move animation");
    }

  }
  
  


  public double getFromX() {
    return fromX;
  }

  public double getFromY() {
    return fromY;
  }

  public double getToX() {
    return toX;
  }

  public double getToY() {
    return toY;
  }

  /**
   * Return a string of the information of the animation.
   *
   * @return a string of the information of the animation
   */
  @Override
  public String toString() {
    String s = "Shape " + this.name + " moves from (" + this.fromX  + "," + this.fromY + ") to ("
        + this.toX + "," + this.toY + ") from t=" + this.getStartTime() + " to t="
        + this.getEndTime() + "\n";
    return s;
  }





}