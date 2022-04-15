import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.ShapeType;

import static org.junit.Assert.assertEquals;


/**
 * This is a test for IModel interface. It tests all the functions in IModel interfaces.
 */
public class AnimationModelImplTest {
  private AnimationModel model;

  @Before
  public void setUp() throws Exception {
    model = new AnimationModelImpl();
    model.addShape("A", ShapeType.Rectangle, 0,0, 10, 20,
            1.0, 1.0, 1.0, 0, 100);
    model.addShape("B", ShapeType.Oval, 0,0, 10, 20,
            1.0, 1.0, 1.0, 0, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSetUp() {
    model.addShape("C", ShapeType.Rectangle, 10,10,-1,10,10,10,
            10,10,10);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSetUp2() {
    model.addShape("C", ShapeType.Rectangle, 1,1,1,-1,10,10,
            10,10,10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSetUp3() {
    model.addShape("C", ShapeType.Rectangle, 1,1,1,1,300,10,
            10,10,10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSetUp4() {
    model.addShape("C", ShapeType.Rectangle, 1,1,1,1,-200,10,
            10,10,10);
  }


  @Test
  public void getShape() {
    assertEquals("Name: A\n" 
            + "Type: rectangle\n" 
            + "Min corner: (0.0,0.0), Width: 10.0, Height: 20.0, Color: (1.0,1.0,1.0)\n" 
            + "Appears at t=0\n" 
            + "Disappears at t=100\n", model.getShape("A").toString());
    assertEquals("Name: B\n" 
            + "Type: oval\n" 
            + "Center: (0.0,0.0), X radius: 10.0, Y radius: 20.0, Color: (1.0,1.0,1.0)\n" 
            + "Appears at t=0\n" 
            + "Disappears at t=100\n", model.getShape("B").toString());
  }

  @Test
  public void getShapeList() {
    assertEquals("{A=Name: A\n" +
            "Type: rectangle\n" +
            "Min corner: (0.0,0.0), Width: 10.0, Height: 20.0, Color: (1.0,1.0,1.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            ", B=Name: B\n" +
            "Type: oval\n" +
            "Center: (0.0,0.0), X radius: 10.0, Y radius: 20.0, Color: (1.0,1.0,1.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "}", model.getShapeList().toString());
  }


  @Test
  public void getAnimationList() {
    assertEquals("{}", model.getCurrAnimationList().toString());
  }

  @Test
  public void getSortedList() {
    model.changeColor("A", 3,6,10,10,10);
    model.scale("A", 20,60,100,100);
    model.changeColor("B", 100,200,10,10,10);
    model.move("B", 15,45,10,10);
    assertEquals("[Shape A changes color from (1.0,1.0,1.0) to (10.0,10.0,10.0) from t=3 to t=6\n" +
            ", Shape B moves from (0.0,0.0) to (10.0,10.0) from t=15 to t=45\n" +
            ", Shape A scales from Width: 10.0, Height: 20.0 to "
            + "Width: 100.0, Height: 100.0 from t=20 to t=60\n" +
            ", Shape B changes color from (1.0,1.0,1.0) to (10.0,10.0,10.0) from t=100 to t=200\n" +
            "]", model.getSortedList().toString());
  }


  @Test
  public void changeColor() {
    model.changeColor("A", 10,20, 2.0, 2.0, 2.0);
    assertEquals(1, model.getCurrAnimationList().size());
    assertEquals(1, model.getSortedList().size());
    model.changeColor("A", 0,5, 3.0, 3.0, 3.0);
    assertEquals("[Shape A changes color from (1.0,1.0,1.0) to (2.0,2.0,2.0) from t=10 to t=20\n" +
            ", Shape A changes color from (1.0,1.0,1.0) to (3.0,3.0,3.0) from t=0 to t=5\n" +
            "]", model.getCurrAnimationList().get("A").toString());
    assertEquals("Shapes: \n" +
            "Name: A\n" +
            "Type: rectangle\n" +
            "Min corner: (0.0,0.0), Width: 10.0, Height: 20.0, Color: (1.0,1.0,1.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: B\n" +
            "Type: oval\n" +
            "Center: (0.0,0.0), X radius: 10.0, Y radius: 20.0, Color: (1.0,1.0,1.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape A changes color from (1.0,1.0,1.0) to (3.0,3.0,3.0) from t=0 to t=5\n" +
            "Shape A changes color from (1.0,1.0,1.0) to (2.0,2.0,2.0) from t=10 to t=20\n", 
            model.modelState());

    model.changeColor("A", 10, 15, 3.0,3.0,3.0);
    assertEquals("Shapes: \n" +
            "Name: A\n" +
            "Type: rectangle\n" +
            "Min corner: (0.0,0.0), Width: 10.0, Height: 20.0, Color: (1.0,1.0,1.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: B\n" +
            "Type: oval\n" +
            "Center: (0.0,0.0), X radius: 10.0, Y radius: 20.0, Color: (1.0,1.0,1.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape A changes color from (1.0,1.0,1.0) to (3.0,3.0,3.0) from t=0 to t=5\n" +
            "Shape A changes color from (1.0,1.0,1.0) to (2.0,2.0,2.0) from t=10 to t=20\n", 
            model.modelState());
  }


  @Test
  public void testRemoveShape() {
    model.move("A", 10,30,100,100);
    model.changeColor("A", 40,80,10,10,10);
    assertEquals("Shapes: \n" +
            "Name: A\n" +
            "Type: rectangle\n" +
            "Min corner: (0.0,0.0), Width: 10.0, Height: 20.0, Color: (1.0,1.0,1.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: B\n" +
            "Type: oval\n" +
            "Center: (0.0,0.0), X radius: 10.0, Y radius: 20.0, Color: (1.0,1.0,1.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape A moves from (0.0,0.0) to (100.0,100.0) from t=10 to t=30\n" +
            "Shape A changes color from (1.0,1.0,1.0) to (10.0,10.0,10.0) from t=40 to t=80\n", 
            model.modelState());

    model.removeShape("A", ShapeType.Rectangle, 50);

    assertEquals("Shapes: \n" +
            "Name: B\n" +
            "Type: oval\n" +
            "Center: (0.0,0.0), X radius: 10.0, Y radius: 20.0, Color: (1.0,1.0,1.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape A moves from (0.0,0.0) to (100.0,100.0) from t=10 to t=30\n", 
            model.modelState());
  }

  @Test
  public void testRemove() {

    model.removeShape("A", ShapeType.Rectangle, 0);
    assertEquals("{B=Name: B\n" +
            "Type: oval\n" +
            "Center: (0.0,0.0), X radius: 10.0, Y radius: 20.0, Color: (1.0,1.0,1.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "}", model.getShapeList().toString());
    model.getCurrAnimationList().get("A"); //null
  }

  @Test
  public void testScale() {
    
    model.scale("B", 40,50,5,5);
    model.scale("A", 10,20,10,10);
    model.scale("A", 15,30,20,20); 
    assertEquals("Shapes: \n" +
            "Name: A\n" +
            "Type: rectangle\n" +
            "Min corner: (0.0,0.0), Width: 10.0, Height: 20.0, Color: (1.0,1.0,1.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: B\n" +
            "Type: oval\n" +
            "Center: (0.0,0.0), X radius: 10.0, Y radius: 20.0, Color: (1.0,1.0,1.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape A scales from Width: 10.0, Height: 20.0 to Width: "
            + "10.0, Height: 10.0 from t=10 to t=20\n" +
            "Shape B scales from Width: 10.0, Height: 20.0 to Width: 5.0, "
            + "Height: 5.0 from t=40 to t=50\n", model.modelState());
  }


  @Test
  public void move() {
    model.move("A", 10,20, 5,5);
    model.move("B", 20,40,10,10);
    model.move("B", 20,30,10,10);
    assertEquals("Shapes: \n" +
            "Name: A\n" +
            "Type: rectangle\n" +
            "Min corner: (0.0,0.0), Width: 10.0, Height: 20.0, Color: (1.0,1.0,1.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: B\n" +
            "Type: oval\n" +
            "Center: (0.0,0.0), X radius: 10.0, Y radius: 20.0, Color: (1.0,1.0,1.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape A moves from (0.0,0.0) to (5.0,5.0) from t=10 to t=20\n" +
            "Shape B moves from (0.0,0.0) to (10.0,10.0) from t=20 to t=40\n", model.modelState());

  }

  @Test
  public void testState() {

    model.move("A", 0,5, 50, 60);
    model.scale("B", 40,50,5,5);
    model.changeColor("A", 10,20, 2.0, 2.0, 2.0);
    assertEquals("Shapes: \n" +
            "Name: A\n" +
            "Type: rectangle\n" +
            "Min corner: (0.0,0.0), Width: 10.0, Height: 20.0, Color: (1.0,1.0,1.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Name: B\n" +
            "Type: oval\n" +
            "Center: (0.0,0.0), X radius: 10.0, Y radius: 20.0, Color: (1.0,1.0,1.0)\n" +
            "Appears at t=0\n" +
            "Disappears at t=100\n" +
            "\n" +
            "Shape A moves from (0.0,0.0) to (50.0,60.0) from t=0 to t=5\n" +
            "Shape A changes color from (1.0,1.0,1.0) to (2.0,2.0,2.0) from t=10 to t=20\n" +
            "Shape B scales from Width: 10.0, Height: 20.0 to Width: 5.0, Height: 5.0 from t=40" +
            " to t=50\n", model.modelState());
  }

}