package cs5004.animator.model;

import java.util.Objects;

/**
 * This class represents a coordinate point.
 */
public final class Coordinate {

  private double x;
  private double y;


  /**
   * Set this coordinate to the specified position.
   *
   * @param x the x-coordinate
   * @param y the y-coordinate
   */
  public Coordinate(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Return x coordinate.
   *
   * @return x coordinate
   */
  public double getX() {
    return x;
  }

  /**
   * Return y coordinate.
   *
   * @return y coordinate
   */
  public double getY() {
    return y;
  }


  public void setPosition(double x, double y) {
    this.x = x;
    this.y = y;
  }


  /**
   * Copy constructor.
   */
  public Coordinate(Coordinate c) {
    this(c.getX(), c.getY());
  }

  @Override
  public String toString() {
    return String.format("(%f, %f)", this.x, this.y);
  }

  @Override
  public boolean equals(Object a) {
    if (this == a) {
      return true;
    }
    if (!(a instanceof Coordinate)) {
      return false;
    }

    Coordinate c = (Coordinate) a;

    return ((Math.abs(this.x - c.x) < 0.01) && (Math.abs(this.y - c.y) < 0.01));
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.x, this.y);
  }




}