package cs5004.animator.controller;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.view.AnimatorView;

/**
 * Represents a text controller.
 */
public class AnimatorTextController implements AnimatorController {

  private AnimationModel model;
  private AnimatorView view;
  
  public AnimatorTextController(AnimationModel m, AnimatorView v) {
    this.model = m;
    this.view = v;
  }
  
  @Override
  public void perform() {
    view.display(model);
  }
}
