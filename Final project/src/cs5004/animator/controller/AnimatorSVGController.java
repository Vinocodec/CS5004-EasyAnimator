package cs5004.animator.controller;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.view.AnimatorView;

/**
 * Represents a SVG controller.
 */
public class AnimatorSVGController implements AnimatorController {

  private AnimationModel model;
  private AnimatorView view;
  
  public AnimatorSVGController(AnimationModel m, AnimatorView v) {
    this.model = m;
    this.view = v;
  }
  
  @Override
  public void perform() {
    view.display(model);
  }

}
