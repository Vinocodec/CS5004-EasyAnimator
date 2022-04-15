package cs5004.animator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import cs5004.animator.controller.AnimatorController;
import cs5004.animator.controller.AnimatorTextController;
import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.AnimatorView;
import cs5004.animator.view.AnimatorViewGUI;
import cs5004.animator.view.AnimatorViewSVG;
import cs5004.animator.view.AnimatorViewText;

/**
 * Run an easy animator.
 */
public class Main {
  /**
   * Run an easy animator.
   */
  public static void main(String[] args) {
    
    File file = new File("/Users/vino/Downloads/课程/CS5004/final/model/code/buildings.txt");
    AnimationModel m = new AnimationModelImpl();
    try {
      m = AnimationReader.parseFile(new BufferedReader(
          new FileReader(file)), new AnimationBuilderImpl());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    
    AnimatorView text = new AnimatorViewText(System.out, m);
    AnimatorController textController = new AnimatorTextController(m, text);
    textController.perform();
    
    AnimatorView gui = new AnimatorViewGUI(m);
    AnimatorController guiController = new AnimatorTextController(m, gui);
    guiController.perform();
    
    try {
      String s = "/Users/vino/Downloads/课程/sample.svg";
        
      AnimatorViewSVG svg = new AnimatorViewSVG(m, s);
        
      System.out.println(m.toString());
        
      svg.display(m);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    
  }
}