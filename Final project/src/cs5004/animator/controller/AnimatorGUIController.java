package cs5004.animator.controller;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.view.AnimatorView;
import cs5004.animator.view.AnimatorViewGUI;

/**
 * Represents a GUI controller.
 */
public class AnimatorGUIController implements AnimatorController {
  
  private AnimationModel model;
  private AnimatorView view;
  
  /**
   * Create a new object of the GUI controller.
   *
   * @param m the animation model
   */
  public AnimatorGUIController(AnimationModel m, AnimatorView v) {
    this.model = m;
    this.view = v;
  }
  
  @Override
  public void perform() {
    view.display(model);
  }

}
