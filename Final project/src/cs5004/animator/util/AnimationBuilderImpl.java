package cs5004.animator.util;

import java.util.HashMap;
import java.util.Map;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.ShapeType;

/**
 * Represents the Implement of the Animation Builder.
 */
public class AnimationBuilderImpl implements AnimationBuilder<AnimationModel> {
  
  private AnimationModel model;
  private Map<String, String> shapes;
  private int x;
  private int y;
  
  /**
   * Create a new object of the animation builder impl.
   */
  public AnimationBuilderImpl() {
    this.model = new AnimationModelImpl();
    shapes = new HashMap<String, String>();
    x = 0;
    y = 0;
  }
  
  @Override
  public AnimationModel build() {
    return model;
  }

  @Override
  public AnimationBuilder<AnimationModel> setBounds(int x, int y, int width, int height) {
    model.setCanvasSize(Math.max(width, width - x) , Math.max(height, height - y));
    this.x = x;
    this.y = y;
    return this;
  }

  @Override
  public AnimationBuilder<AnimationModel> declareShape(String name, String type) {
    if (type.equals("rectangle")) {
      model.addShape(name, ShapeType.Rectangle, 0, 0, 0, 0, 0, 0, 0, 0, 10000000);
    }
    if (type.equals("oval") || type.equals("ellipse")) {
      model.addShape(name, ShapeType.Oval, 0, 0, 0, 0, 0, 0, 0, 0, 10000000);
    }
    shapes.put(name, type);
    return this;
  }

  @Override
  public AnimationBuilder<AnimationModel> addMotion(String name, int t1, 
      int x1, int y1, int w1, int h1, int r1, int g1,
      int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    
    String s = shapes.get(name);
    
    if (x1 - x2 + y1 - y2 + w1 - w2 + h1 - h2 + r1 - r2 + g1 - g2 + b1 - b2 == 0) {
      if (s.contentEquals("ellipse")) {
        model.addShape(name, ShapeType.Oval, (double)(x1), 
            (double)(y1), (double)w1, (double)h1,
            (double)r1, (double)g1, (double)b1, t1, t2);
      } else if (s.contentEquals("rectangle")) {
        model.addShape(name, ShapeType.Rectangle, (double)(x1), 
            (double)(y1), (double)w1, (double)h1,
            (double)r1, (double)g1, (double)b1, t1, t2);
      }
      
    }
    if (x1 - x2 + y1 - y2 != 0) {
      model.move(name, t1, t2, x2, y2);
    }
    if (h1 - h2 + w1 - w2 != 0) {
      model.scale(name, t1, t2, w2, h2);
    }
    if (r1 - r2 + g1 - g2 + b1 - b2 != 0) {
      model.changeColor(name, t1, t2, r2, g2, b2);
    }
    
    return this;  
  }

}
