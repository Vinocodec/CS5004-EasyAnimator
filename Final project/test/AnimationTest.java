import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import cs5004.animator.model.AnimationElement;
import cs5004.animator.model.ColorChange;
import cs5004.animator.model.Animation;
import cs5004.animator.model.Shape;
import cs5004.animator.model.ShapeType;
import cs5004.animator.model.Move;
import cs5004.animator.model.Coordinate;
import cs5004.animator.model.Rectangle;
import cs5004.animator.model.Scale;

import static org.junit.Assert.assertEquals;

/**
 * This is a test for animation class.
 */
public class AnimationTest {
  private Animation move;
  private Animation scale;
  private Animation color;
  private Map shapeList;

  @Before
  public void setUp() throws Exception {
    shapeList = new HashMap<String, Shape>();
    move = new Move(shapeList, "R", 0, 10, 0,0,100,100);
    color = new ColorChange(shapeList, "L", 20,40,1.0,
            1.0,1.0,2.0,2.0,2.0);
    scale = new Scale(shapeList, "Q", 30,50, 100,
            200,10,20);
  }

  @Test
  public void getName() {
    assertEquals("R", move.getName());
    assertEquals("L", color.getName());
    assertEquals("Q", scale.getName());
  }

  @Test
  public void getType() {
    Assert.assertEquals(AnimationElement.MOVE, move.getElement());
    assertEquals(AnimationElement.SCALE, scale.getElement());
    assertEquals(AnimationElement.COLORCHANGE, color.getElement());
  }

  @Test
  public void getStartTime() {
    assertEquals(0, move.getStartTime());
    assertEquals(20, color.getStartTime());
    assertEquals(30, scale.getStartTime());
  }

  @Test
  public void getEndTime() {
    assertEquals(10, move.getEndTime());
    assertEquals(40, color.getEndTime());
    assertEquals(50, scale.getEndTime());
  }


  @Test
  public void performAction() {
    
    Shape shapeR = new Rectangle("R", ShapeType.Rectangle, new Coordinate(0,0), 10,20,
            0.1,0.1,0.1, 0, 100);
    shapeList.put("R", shapeR);
    move.generateAnimation();
    assertEquals(100, shapeR.getCoordinate().getX(), 0.01);
    assertEquals(100, shapeR.getCoordinate().getY(), 0.01);
  }


  @Test
  public void testToString() {
    assertEquals("Shape R moves from (0.0,0.0) to (100.0,100.0) from t=0 to t=10\n",
            move.toString());
    assertEquals("Shape L changes color from (1.0,1.0,1.0) to (2.0,2.0,2.0) from t=20 to "
                    + "t=40\n", color.toString());
    assertEquals("Shape Q scales from Width: 100.0, Height: 200.0 to Width: 10.0, " +
            "Height: 20.0 from t=30 to t=50\n", scale.toString());
  }
}