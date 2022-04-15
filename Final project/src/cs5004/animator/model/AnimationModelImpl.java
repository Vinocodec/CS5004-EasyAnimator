package cs5004.animator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * This class represents a modelImpl.
 */
public class AnimationModelImpl implements AnimationModel {
 
  private Map<String, Shape> shapeList;
  private Map<String, ArrayList<Animation>> currAnimationLst;
  private ArrayList<Animation> sortedAnimationList;
  
  private int canvasWidth;
  private int canvasHeight;

  /**
   * Create a new object of a modelImpl.
   */
  public AnimationModelImpl() {
    this.shapeList = new HashMap<>();
    this.currAnimationLst = new HashMap<>();
    this.sortedAnimationList = new ArrayList<>();
  }
  
  public void setCanvasSize(int x, int y) {
    this.canvasWidth = x;
    this.canvasHeight = y;
  }
  
  


  public Map<String, ArrayList<Animation>> getCurrAnimationLst() {
    return currAnimationLst;
  }

  public ArrayList<Animation> getSortedAnimationList() {
    return sortedAnimationList;
  }

  public int getCanvasWidth() {
    return canvasWidth;
  }

  public int getCanvasHeight() {
    return canvasHeight;
  }

  /**
   * Return the Shape object of this shape name.
   *
   * @param name the name of the shape
   * @return the Shape object of this shape name.
   */
  @Override
  public Shape getShape(String name) {
    return shapeList.get(name);
  }

  /**
   * Return the shapeList.
   *
   * @return the shapeList
   */
  @Override
  public Map getShapeList() {
    return this.shapeList;
  }

  /**
   * Return the sortedList.
   *
   * @return the sortedList
   */
  @Override
  public ArrayList getSortedList() {
    return this.sortedAnimationList;
  }

  /**
   * Return the animation list.
   *
   * @return the animation list
   */
  @Override
  public Map getCurrAnimationList() {
    return this.currAnimationLst;
  }

  /**
   * Return true if this shape is already exist in the model.
   *
   * @param name the name of this shape
   * @return true if this shape is already exist in the model.
   */
  private boolean checkShapeExist(String name) {
    
    for (String existShape: shapeList.keySet()) {
      if (existShape.equals(name)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Add a new shape to the model.
   *
   * @param name the name of the shape
   * @param type  the shape type
   * @param x the x-coordinate of the shape
   * @param y the y-coordinate of the shape
   * @param width the width of the shape
   * @param height the height of the shape
   * @param red the red intensity of this shape
   * @param green the green intensity of this shape
   * @param blue the blue intensity of this shape
   * @param startTime the start time of this animation
   * @param endTime the end time of this animation
   * @throws IllegalArgumentException if cannot add new shape to the model
   */
  @Override
  public void addShape(String name, ShapeType type, double x, double y, double width, double height,
                       double red, double green, double blue, int startTime, int endTime)
          throws IllegalArgumentException {
    
    Shape shape;
    Coordinate coordinate = new Coordinate(x, y);
    switch (type) {
      case Oval:
        shape = new Oval(name, ShapeType.Oval, coordinate,
            width, height, red, green, blue, startTime, endTime);
        shapeList.put(name, shape);
        break;
      case Rectangle:
        shape = new Rectangle(name, ShapeType.Rectangle, coordinate,
            width, height, red, green, blue, startTime, endTime);
        shapeList.put(name, shape);
        break;
      default:
        throw new IllegalArgumentException("Cannot find the shape type");
    }
  }

  /**
   * Remove a shape from this model.
   *
   * @param name the name of the shape
   * @param type the type of the shape
   * @param removeTime the delete Time of the shape
   * @throws IllegalArgumentException if input is invalid or cannot find the shape
   */
  @Override
  public void removeShape(String name, ShapeType type, int removeTime)
          throws IllegalArgumentException {
    if (name.equals("") || type == null) {
      throw new IllegalArgumentException("Cannot remove the shape because the input is invalid.");
    }
    if (shapeList.get(name) == null) {
      throw new IllegalArgumentException(
          "Cannot remove the shape because the shape cannot be found.");
    }
    
    shapeList.remove(name);
    currAnimationLst.remove(name);
    sortedAnimationList.removeIf(animation -> animation.getName().equals(name)
            && (removeTime < animation.getEndTime()));
  }


  /**
   * Create a change color animation.
   *
   * @param name the name of the shape
   * @param timeStart the start time of this animation
   * @param timeEnd the end time of this animation
   * @param afterRed the new red intensity of this shape
   * @param afterGreen the new green intensity of this shape
   * @param afterBlue the new blue intensity of this shape
   * @throws IllegalArgumentException when it cannot find the shape
   */
  @Override
  public void changeColor(String name, int timeStart, int timeEnd, double afterRed,
                          double afterGreen, double afterBlue) 
                              throws IllegalArgumentException {
    if (!checkShapeExist(name)) {
      throw new IllegalArgumentException("Cannot find the shape.");
    }

    boolean canChange = checkTimeOverlap(AnimationElement.COLORCHANGE, name, timeStart, timeEnd);
    if (canChange) {
      Animation newColor = new ColorChange(shapeList, name, timeStart, timeEnd,
              shapeList.get(name).getRed(), shapeList.get(name).getGreen(),
              shapeList.get(name).getBlue(), afterRed,
              afterGreen, afterBlue);
      updateAllRelatedList(newColor, timeStart, name);
    }
  }

  /**
   * Create a scale animation.
   *
   * @param name the name of the shape
   * @param timeStart the start time of this animation
   * @param timeEnd the end time of this animation
   * @param afterWidth the afterWidth of the shape
   * @param afterHeight the afterHeight of the shape
   * @throws IllegalArgumentException when it cannot find the shape.
   */
  @Override
  public void scale(String name, int timeStart, int timeEnd,
                           double afterWidth, double afterHeight) throws IllegalArgumentException {
    
    if (!checkShapeExist(name)) {
      throw new IllegalArgumentException("Cannot find the shape.");
    }

    boolean canChange = checkTimeOverlap(AnimationElement.SCALE, name, timeStart, timeEnd);

    if (canChange) {
      Animation newScale = new Scale(shapeList, name, timeStart, timeEnd,
              shapeList.get(name).getWidth(), shapeList.get(name).getHeight(),
              afterWidth, afterHeight);
      updateAllRelatedList(newScale, timeStart, name);
    }
  }

  /**
   * Create a movement animation.
   *
   * @param name the name of the shape
   * @param timeStart the start time of this animation
   * @param timeEnd the end time of this animation
   * @param toX the new x-coordinate of the shape
   * @param toY the new y-coordinate of the shape
   * @throws IllegalArgumentException when it cannot find the shape
   */
  @Override
  public void move(String name, int timeStart, int timeEnd, double toX, double toY)
          throws IllegalArgumentException {
    
    if (!checkShapeExist(name)) {
      throw new IllegalArgumentException("Cannot find the shape");
    }

    boolean canChange = checkTimeOverlap(AnimationElement.MOVE, name, timeStart, timeEnd);
    if (canChange) {
      Animation newMove = new Move(shapeList, name, timeStart, timeEnd,
              shapeList.get(name).getCoordinate().getX(),
              shapeList.get(name).getCoordinate().getY(), toX, toY);
      updateAllRelatedList(newMove, timeStart, name);
    }
  }

  /**
   * Return a description of the animations.
   *
   * @return a description of the animations
   */
  @Override
  public String modelState() {
    StringBuilder output = new StringBuilder();
    output.append("Shapes: \n");
    
    for (String shape: shapeList.keySet()) {
      output.append(shapeList.get(shape).toString());
      output.append("\n");
    }
    
    for (Animation animation: sortedAnimationList) {
      output.append(animation.toString());
    }
    return String.valueOf(output);

  }

  /**
   * Return true if there is a time conflict between new animation and the exist animation.
   *
   * @param animationsType the new animation type
   * @param name the name of the shape
   * @param startT the start time of the new animation
   * @param endT the end time of the new animation
   * @return true if there is a time conflict between new animation and the exist animation.
   */
  private boolean checkTimeOverlap(AnimationElement animationElement, String name, int startT,
                                   int endT) {
    
    for (String shape: currAnimationLst.keySet()) {
      if (shape.equals(name)) {
        ArrayList<Animation> shapeAnimationList = currAnimationLst.get(name);
        for (Animation a : shapeAnimationList) {
          if (a.getElement().equals(animationElement)) {
            if (startT < a.getEndTime() && startT >= a.getStartTime()
                    || endT > a.getStartTime() && endT <= a.getEndTime()) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  /**
   * Add new animation to the sortedAnimationList.
   *
   * @param startTime the start time of the new animation
   * @param newAnimation the new animation being added
   */
  private void addAnimationInSortedList(int startTime, Animation newAnimation) {
    
    if (sortedAnimationList.size() == 0) {
      sortedAnimationList.add(newAnimation);
      return;
    }
    
    int i  = 0;
    boolean added = false;
    
    for (Animation currAnimation: sortedAnimationList) {
      if (startTime <= currAnimation.getStartTime()) {
        sortedAnimationList.add(i, newAnimation);
        added = true;
        break;
      }
      i ++;
    }

    if (!added) {
      sortedAnimationList.add(newAnimation);
    }
  }


  /**
   * Update new animation to all related lists.
   *
   * @param newAnimation the new animation
   * @param timeStart the start time of the new animation
   * @param name the name of the shape
   */
  private void updateAllRelatedList(Animation newAnimation, int timeStart, String name) {
   
    addAnimationInSortedList(timeStart, newAnimation);
    ArrayList<Animation> animationArrayList = currAnimationLst.get(name);
    if (animationArrayList == null) {
      currAnimationLst.put(name, new ArrayList<>());
      ArrayList<Animation> animationList = currAnimationLst.get(name);
      animationList.add(newAnimation);
    }
    else {
      animationArrayList.add(newAnimation);
    }
  }
  
  /**
   * Return the string of all svg tags.
   */
  public String getSVG(int speed) {
    
    StringBuilder out = new StringBuilder();

    for (String s: this.currAnimationLst.keySet()) {
      String key = s;
      Shape shape = this.shapeList.get(key);
      Animation animation = this.currAnimationLst.get(key).get(0);

      if (shape.getShapeType() == ShapeType.Rectangle) {
        out.append(String.format("<rect id=\"%s\" x=\"%s\" y=\"%s\" width=\"%s\" height=\"%s\" " 
                                + "fill=\"rgb(%s, %s, %s)\" visibility=\"hidden\">\n", key,
            animation.getFromX(), animation.getFromY(), animation.getBeforeWidth(), 
            animation.getBeforeHeight(),
            animation.getBeforeRed(), animation.getBeforeGreen(), animation.getBeforeBlue()));

        out.append(String.format("<animate attributeType=\"CSS\" begin=\"%fs\" dur=\"%fs\""
            + " attributeName=\"visibility\" from=\"visible\" to=\"hidden\"/>\n", 
            animation.getStartTime() / (double) speed, 
            animation.getEndTime() - animation.getStartTime() + 1000 / (double) speed));
          
        for (int i = 0; i < this.currAnimationLst.get(key).size(); i++) {
          Animation motion = this.currAnimationLst.get(key).get(i);
          int duration = motion.getEndTime() - motion.getStartTime();
          String startColor = String.format("rgb(%s, %s, %s)", 
                                        motion.getBeforeRed(), 
                                        motion.getBeforeGreen(),
                                        motion.getBeforeBlue());
          String endColor = String.format("rgb(%s, %s, %s)", 
                                        motion.getAfterRed(), 
                                        motion.getAfterGreen(),
                                        motion.getAfterBlue());

          if (motion.getFromX() != motion.getToX()) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" " 
                  + "dur=\"%fs\" attributeName=\"x\" from=\"%s\" to=\"%s\" "
                  + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) speed, 
                duration / (double) speed, motion.getFromX(), motion.getToX()));
          }

          if (motion.getFromY() != motion.getToY()) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" " 
                  + "dur=\"%fs\" attributeName=\"y\" from=\"%s\" to=\"%s\" "
                  + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) speed, 
                duration / (double) speed, motion.getFromY(), motion.getToY()));
          }

          if (motion.getBeforeWidth() != motion.getAfterWidth()) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" " 
                  + "dur=\"%fs\" attributeName=\"width\" from=\"%s\" to=\"%s\" "
                  + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) speed, 
                duration / (double) speed, motion.getBeforeWidth(),
                motion.getAfterWidth()));
          }

          if (motion.getBeforeHeight() != motion.getAfterHeight()) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" " 
                  + "dur=\"%fs\" attributeName=\"height\" from=\"%s\" to=\"%s\" "
                  + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) speed, 
                duration / (double) speed, motion.getBeforeHeight(),
                motion.getAfterHeight()));
          }

          if (!startColor.equals(endColor)) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" "
                  + "dur=\"%fs\" attributeName=\"fill\" from=\"%s\" to=\"%s\" " 
                  + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) speed, 
                duration / (double) speed, startColor, endColor));
          }

        }

        out.append("</rect>\n");
      }

      else {
        out.append(String.format("<ellipse id=\"%s\" cx=\"%s\" cy=\"%s\" rx=\"%s\" ry=\"%s\" " 
                              + "fill=\"rgb(%s, %s, %s)\" visibility=\"hidden\">\n", key,
                              animation.getFromX(), animation.getFromY(), 
                              animation.getBeforeWidth(), animation.getBeforeHeight(),
                              animation.getBeforeRed(), 
                              animation.getBeforeGreen(), 
                              animation.getBeforeBlue()));

        out.append(String.format("<animate attributeType=\"CSS\" begin=\"%fs\" dur=\"%fs\"" 
            + " attributeName=\"visibility\" from=\"visible\" to=\"hidden\"/>\n", 
            animation.getStartTime() / (double) speed, 
            animation.getEndTime() - animation.getStartTime() + 1000 / (double) speed));
          
        for (int i = 0; i < this.currAnimationLst.get(key).size(); i++) {
          Animation motion = this.currAnimationLst.get(key).get(0);
          int duration = motion.getEndTime() - motion.getStartTime();
          String startColor = String.format("rgb(%s, %s, %s)", 
                                        motion.getBeforeRed(), 
                                        motion.getBeforeGreen(),
                                        motion.getBeforeBlue());
          String endColor = String.format("rgb(%s, %s, %s)", 
                                        motion.getAfterRed(), 
                                        motion.getAfterGreen(),
                                        motion.getAfterBlue());

          if (motion.getFromX() != motion.getToX()) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" " 
                  + "dur=\"%fs\" attributeName=\"cx\" from=\"%s\" to=\"%s\" "
                  + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) speed, 
                duration / (double) speed, motion.getFromX(), motion.getToX()));
          }

          if (motion.getFromY() != motion.getToY()) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" " 
                  + "dur=\"%fs\" attributeName=\"cy\" from=\"%s\" to=\"%s\" "
                  + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) speed, 
                duration / (double) speed, motion.getFromY(), motion.getToY()));
          }

          if (motion.getBeforeWidth() != motion.getAfterWidth()) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" " 
                  + "dur=\"%fs\" attributeName=\"rx\" from=\"%s\" to=\"%s\" "
                  + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) speed, 
                duration / (double) speed, motion.getBeforeWidth(),
                motion.getAfterWidth()));
          }

          if (motion.getBeforeHeight() != motion.getAfterHeight()) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" " 
                  + "dur=\"%fs\" attributeName=\"ry\" from=\"%s\" to=\"%s\" "
                  + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) speed, 
                duration / (double) speed, motion.getBeforeHeight(),
                motion.getAfterHeight()));
          }

          if (!startColor.equals(endColor)) {
            out.append(String.format(
                "<animate attributeType=\"CSS\" begin=\"%fs\" "
                  + "dur=\"%fs\" attributeName=\"fill\" from=\"%s\" to=\"%s\" " 
                  + "fill=\"freeze\"/>\n",
                motion.getStartTime() / (double) speed, 
                duration / (double) speed, startColor, endColor));
          }
        }

        out.append("</ellipse>\n");
      }
    }

    return out.toString();
    
    
    
  }

}

