package cs5004.animator.view;

import java.io.IOException;

import cs5004.animator.model.AnimationModel;

/**
 * Represents a text view.
 */
public class AnimatorViewText implements AnimatorView {
  
  Appendable output;
  AnimationModel model;
  
  public AnimatorViewText(Appendable output, AnimationModel m) {
    this.output = output;
    this.model = m;
  }

  @Override
  public void display(AnimationModel m) {
    try {
      this.output.append(m.modelState());
    } catch (IOException e) {
      throw new IllegalStateException("Error when output the animation text.");
    }

  }

}
