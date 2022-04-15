package cs5004.animator.model;

import java.util.ArrayList;
import java.util.Map;

/**
 * Represents an animationModel.
 */
public interface AnimationModel {
  
  /**
   * Set the size of the canvas.
   *
   * @param x the width of the canvas
   * @param y the height of the canvas
   */
  void setCanvasSize(int x, int y);

  /**
   * Return the Shape object of the name.
   *
   * @param name the name of the shape
   * @return the Shape object of the name
   */
  Shape getShape(String name);

  /**
   * Return the shape list.
   *
   * @return the shape list
   */
  Map getShapeList();

  /**
   * Return the sorted animation list.
   *
   * @return the sorted animation list
   */
  ArrayList getSortedList();

  /**
   * Return the currAnimationList.
   *
   * @return the currAnimationList arrayList
   */
  Map getCurrAnimationList();

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
   * @throws IllegalArgumentException when it cannot add new shape to the model
   */
  void addShape(String name, ShapeType type, double x, double y, double width, double height,
                double red, double green, double blue, int startTime, int endTime)
          throws IllegalArgumentException;

  /**
   * Delete a shape from the model.
   *
   * @param name the name of the shape
   * @param type the type of the shape
   * @param deleteTime the delete Time of the shape
   * @throws IllegalArgumentException when the input is invalid
   */
  void removeShape(String name, ShapeType type, int deleteTime) throws IllegalArgumentException;

  /**
   * Create a color change animation.
   * 
   * @param name the name of the shape
   * @param startTime the start time of this animation
   * @param endTime the end time of this animation
   * @param red the red intensity of this shape
   * @param green the green intensity of this shape
   * @param blue the blue intensity of this shape
   * @throws IllegalArgumentException when it cannot find the shape
   */
  void changeColor(String name, int startTime, int endTime, double red, double green, double blue)
          throws IllegalArgumentException;

  /**
   * Create a scale animation.
   *
   * @param name the name of the shape
   * @param startTime the start time of this animation
   * @param endTime the end time of this animation
   * @param afterWidth the Width of the shape after change
   * @param afterHeight the Height of the shape after change
   * @throws IllegalArgumentException when it cannot find the shape
   */
  void scale(String name, int startTime, int endTime, double afterWidth,
                    double afterHeight) throws IllegalArgumentException;

  /**
   * Create a movement animation.
   *
   * @param name the name of the shape
   * @param startTime the start time of this animation
   * @param endTime the end time of this animation
   * @param toX the new x-coordinate of the shape
   * @param toY the new y-coordinate of the shape
   * @throws IllegalArgumentException when it cannot find the shape
   */
  void move(String name, int startTime, int endTime, double toX, double toY)
          throws IllegalArgumentException;

  /**
   * Return a string of the description of animation.
   *
   * @return a string of the description of animation.
   */
  String modelState();


}