import cs5004.animator.model.Shape;
import cs5004.animator.model.ShapeType;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Coordinate;
import cs5004.animator.model.Rectangle;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a test for Shape interface.
 */
public class ShapeTest {
  private Shape rectangle;
  private Shape oval;

  @Before
  public void setUp() throws Exception {
    rectangle = new Rectangle("R", ShapeType.Rectangle, new Coordinate(200,200), 50,100,
            1.0, 0.0,0.0 , 10, 50);
    oval = new Oval("C", ShapeType.Oval, new Coordinate(500,100), 60,30,0.0,
            0.0,1.0, 0 ,100);
  }

  @Test
  public void testToString() {
    assertEquals("Name: R\n" +
            "Type: rectangle\n" +
            "Min corner: (200.0,200.0), Width: 50.0, Height: 100.0, Color: (1.0,0.0,0.0)\n" +
            "Appears at t=10\n" +
            "Disappears at t=50\n", rectangle.toString());

    assertEquals("Name: C\n" +
            "Type: oval\n" +
            "Center: (500.0,100.0), X radius: 60.0, Y radius: 30.0, Color: (0.0,0.0,1.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n", oval.toString());
  }

  @Test
  public void testGetAppears() {
    assertEquals(10, rectangle.getAppears());
    assertEquals(0, oval.getAppears());
  }


  @Test
  public void testGetDisappears() {
    assertEquals(50, rectangle.getDisappears());
    assertEquals(100, oval.getDisappears());
  }

  @Test
  public void testGetName() {
    assertEquals("R", rectangle.getName());
    assertEquals("C", oval.getName());
  }

  @Test
  public void testGetCoordinate() {
    assertEquals(new Coordinate(200,200).toString(), rectangle.getCoordinate().toString());
    assertEquals(new Coordinate(500,100).toString(), oval.getCoordinate().toString());
  }

  @Test
  public void testGetWidth() {
    assertEquals(50, rectangle.getWidth(), 0.01);
    assertEquals(60, oval.getWidth(), 0.01);
  }

  @Test
  public void testGetHeight() {
    assertEquals(100, rectangle.getHeight(), 0.01);
    assertEquals(30, oval.getHeight(), 0.01);
  }

  @Test
  public void testGetRed() {
    assertEquals(1.0, rectangle.getRed(), 0.01);
    assertEquals(0.0, oval.getRed(), 0.01);
  }

  @Test
  public void testGetGreen() {
    assertEquals(0.0, rectangle.getGreen(), 0.01);
    assertEquals(0.0, oval.getGreen(), 0.01);
  }

  @Test
  public void testGetBlue() {
    assertEquals(0.0, rectangle.getBlue(), 0.01);
    assertEquals(1.0, oval.getBlue(), 0.01);
  }

  @Test
  public void testSetRed() {
    rectangle.setRed(5.0);
    oval.setRed(5.0);
    assertEquals(5.0, rectangle.getRed(), 0.01);
    assertEquals(5.0, oval.getRed(), 0.01);
  }

  @Test
  public void testSetGreen() {
    rectangle.setGreen(5.0);
    oval.setGreen(5.0);
    assertEquals(5.0, rectangle.getGreen(), 0.01);
    assertEquals(5.0, oval.getGreen(), 0.01);
  }

  @Test
  public void testSetBlue() {
    rectangle.setBlue(5.0);
    oval.setBlue(5.0);
    assertEquals(5.0, rectangle.getBlue(), 0.01);
    assertEquals(5.0, oval.getBlue(), 0.01);
  }

  @Test
  public void testSetWidth() {
    rectangle.setWidth(5.0);
    oval.setWidth(5.0);
    assertEquals(5.0, rectangle.getWidth(), 0.01);
    assertEquals(5.0, oval.getWidth(), 0.01);
  }


  @Test
  public void testSetHeight() {
    rectangle.setHeight(5.0);
    oval.setHeight(5.0);
    assertEquals(5.0, rectangle.getHeight(), 0.01);
    assertEquals(5.0, oval.getHeight(), 0.01);
  }


  @Test
  public void testSetCoordinate() {
    rectangle.setCoordinate(0,0);
    oval.setCoordinate(0,0);
    assertEquals(new Coordinate(0,0).toString(), rectangle.getCoordinate().toString());
    assertEquals(new Coordinate(0,0).toString(), oval.getCoordinate().toString());
  }





}