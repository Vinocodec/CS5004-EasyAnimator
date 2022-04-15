package cs5004.animator;

import cs5004.animator.controller.AnimatorController;
import cs5004.animator.controller.AnimatorGUIController;
import cs5004.animator.controller.AnimatorSVGController;
import cs5004.animator.controller.AnimatorTextController;
import cs5004.animator.model.AnimationModel;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.AnimatorViewGUI;
import cs5004.animator.view.AnimatorViewSVG;
import cs5004.animator.view.AnimatorViewText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * This is a class that runs the easy animator using command lines.
 */
public class EasyAnimatorMain {
  /**
   * This is a class that runs the easy animator using command lines.
   */
  public static void main(String[] args) {
    String input = "";
    String output = "";
    String view = "text";
    int speed = 0;
    String s = String.join(" ", args);
    Scanner sc = new Scanner(s).useDelimiter("\\s");

    while (sc.hasNext()) {
      String cmd = sc.next();
      switch (cmd) {
        case "-in":
          input = sc.next();
          break;
        case "-out":
          output = sc.next();
          break;
        case "-view":
          view = sc.next();
          break;
        case "-speed":
          speed = sc.nextInt();
          break;
        default:
      }
    }
    sc.close();

    try {
      AnimationModel m = AnimationReader.parseFile(new BufferedReader(new FileReader(input)),
          new AnimationBuilderImpl());
      AnimatorController c = new AnimatorTextController(m, new AnimatorViewText(System.out, m));

      switch (view) {
        case "svg":
          AnimatorViewSVG svg = new AnimatorViewSVG(m, output);
          svg.setSpeed(speed);        
          c = new AnimatorSVGController(m, svg);
          break;
        case "text":
          c = new AnimatorTextController(m, new AnimatorViewText(System.out, m));
          break;
        case "visual":
          c = new AnimatorGUIController(m, new AnimatorViewGUI(m));
          break;
        default:
      }
      c.perform();
    } catch (FileNotFoundException e1) {
      e1.printStackTrace();
    }
  }
}
