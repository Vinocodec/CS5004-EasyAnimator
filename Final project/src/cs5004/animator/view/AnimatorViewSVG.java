package cs5004.animator.view;

import java.io.BufferedWriter;
import java.io.PrintWriter;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;

/**
 * Represents a SVG view.
 */
public class AnimatorViewSVG implements AnimatorView {

  private BufferedWriter writer;
  AnimationModel model;
  String outFile;
  int speed;
  
  /**
   * Create a new object of svg view.
   * 
   * @param m the model
   * @param of the out file
   */
  public AnimatorViewSVG(AnimationModel m, String of) {
    this.model = m;
    this.outFile = of;
    speed = 1;
  }
  
  public void setSpeed(int s) {
    speed = s;
  }
  
  @Override
  public void display(AnimationModel model) {
    try {
      PrintWriter out = new PrintWriter(outFile);
      AnimationModelImpl m = (AnimationModelImpl) model;
      out.print(String.format("<svg xmlns=\"http://www.w3.org/2000/svg\" x='%s'"
          + " y='%s' width='%s' height='%s' version=\"1.1\">\n", 
          m.getSortedAnimationList().get(0).getFromX(), 
          m.getSortedAnimationList().get(0).getFromY(),
          m.getSortedAnimationList().get(0).getBeforeWidth(), 
          m.getSortedAnimationList().get(0).getBeforeHeight()));
      
      out.print(m.getSVG(speed));
      out.print("</svg>\n");
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }


  }

}
