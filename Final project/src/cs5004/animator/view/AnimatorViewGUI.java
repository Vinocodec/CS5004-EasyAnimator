package cs5004.animator.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.ShapeType;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Dimension;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Represents a GUI view.
 */
public class AnimatorViewGUI extends JFrame implements AnimatorView, ActionListener {
  
  private AnimationModel model;

  
  private JTextField shapeX;
  private JTextField shapeY;
  private JTextField shapeWidth;
  private JTextField shapeHeight;
  private JTextField shapeStart;
  private JTextField shapeEnd;
  private JTextField shapeRed;
  private JTextField shapeGreen;
  private JTextField shapeBlue;
  private JTextField shapeName;
  private JTextField animationName;
  private JTextField animationX;
  private JTextField animationY;
  private JTextField animationStart;
  private JTextField animationWidth;
  private JTextField animationHeight;
  private JTextField animationEnd;
  private JTextField animationRed;
  private JTextField animationGreen;
  private JTextField animationBlue;
  private JTextField animationSpeed;

  /**
   * Create the frame.
   */
  public AnimatorViewGUI(AnimationModel m) {
    
    this.model = m;
    
    setBounds(new Rectangle(0, 0, 1000, 1000));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 786, 565);
    setName("Easy Animator");
    JPanel contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JPanel panel = new JPanel();
    panel.setBounds(new Rectangle(5, 5, 761, 26));
    contentPane.add(panel);
    
    JLabel bigLabelShape = new JLabel("Add A Shape ");
    panel.add(bigLabelShape);
    
    JPanel panel_1 = new JPanel();
    panel_1.setBounds(5, 32, 198, 26);
    contentPane.add(panel_1);
    
    JLabel typeOfShape = new JLabel("Type of Shape");
    typeOfShape.setName("addShape");
    panel_1.add(typeOfShape);
    typeOfShape.setBounds(new Rectangle(0, 500, 0, 0));
    
    JPanel panel_2 = new JPanel();
    panel_2.setBounds(5, 56, 298, 26);
    contentPane.add(panel_2);
    
    JComboBox createShape = new JComboBox();
    createShape.setModel(new DefaultComboBoxModel(
        new String[] {"---Pease choose a type of shape---", "Oval", "Rectangle"}));
    createShape.setSize(new Dimension(50, 0));
    panel_2.add(createShape);
    
    JPanel panel_3 = new JPanel();
    panel_3.setBounds(325, 32, 120, 26);
    contentPane.add(panel_3);
    
    JLabel labelShapeX = new JLabel("Coordinate X");
    panel_3.add(labelShapeX);
    
    JPanel panel_4 = new JPanel();
    panel_4.setBounds(315, 56, 122, 26);
    contentPane.add(panel_4);
    
    shapeX = new JTextField();
    panel_4.add(shapeX);
    shapeX.setColumns(10);
    
    JPanel panel_3_1 = new JPanel();
    panel_3_1.setBounds(458, 32, 120, 26);
    contentPane.add(panel_3_1);
    
    JLabel labelShapeY = new JLabel("Coordinate Y");
    panel_3_1.add(labelShapeY);
    
    JPanel panel_4_1 = new JPanel();
    panel_4_1.setBounds(457, 56, 121, 26);
    contentPane.add(panel_4_1);
    
    shapeY = new JTextField();
    shapeY.setColumns(10);
    panel_4_1.add(shapeY);
    
    JPanel panel_3_2 = new JPanel();
    panel_3_2.setBounds(325, 89, 120, 26);
    contentPane.add(panel_3_2);
    
    JLabel labelShapeWidth = new JLabel("Width");
    panel_3_2.add(labelShapeWidth);
    
    JPanel panel_3_3 = new JPanel();
    panel_3_3.setBounds(458, 89, 120, 26);
    contentPane.add(panel_3_3);
    
    JLabel labelShapeHeight = new JLabel("Height");
    panel_3_3.add(labelShapeHeight);
    
    JPanel panel_4_2 = new JPanel();
    panel_4_2.setBounds(315, 114, 122, 26);
    contentPane.add(panel_4_2);
    
    shapeWidth = new JTextField();
    shapeWidth.setColumns(10);
    panel_4_2.add(shapeWidth);
    
    JPanel panel_4_1_1 = new JPanel();
    panel_4_1_1.setBounds(458, 114, 120, 26);
    contentPane.add(panel_4_1_1);
    
    shapeHeight = new JTextField();
    shapeHeight.setColumns(10);
    panel_4_1_1.add(shapeHeight);
    
    JPanel panel_3_1_1 = new JPanel();
    panel_3_1_1.setBounds(594, 32, 120, 26);
    contentPane.add(panel_3_1_1);
    
    JLabel labelShapestart = new JLabel("Start Time");
    panel_3_1_1.add(labelShapestart);
    
    JPanel panel_3_1_2 = new JPanel();
    panel_3_1_2.setBounds(594, 89, 120, 26);
    contentPane.add(panel_3_1_2);
    
    JLabel labelShapeEnd = new JLabel("End Time");
    panel_3_1_2.add(labelShapeEnd);
    
    JPanel panel_4_1_2 = new JPanel();
    panel_4_1_2.setBounds(590, 56, 124, 26);
    contentPane.add(panel_4_1_2);
    
    shapeStart = new JTextField();
    shapeStart.setColumns(10);
    panel_4_1_2.add(shapeStart);
    
    JPanel panel_4_1_3 = new JPanel();
    panel_4_1_3.setBounds(590, 114, 124, 26);
    contentPane.add(panel_4_1_3);
    
    shapeEnd = new JTextField();
    shapeEnd.setColumns(10);
    panel_4_1_3.add(shapeEnd);
    
    JPanel panel_3_2_1 = new JPanel();
    panel_3_2_1.setBounds(325, 147, 120, 26);
    contentPane.add(panel_3_2_1);
    
    JLabel labelShapeRed = new JLabel("Color Red");
    panel_3_2_1.add(labelShapeRed);
    
    JPanel panel_3_3_1 = new JPanel();
    panel_3_3_1.setBounds(458, 147, 120, 26);
    contentPane.add(panel_3_3_1);
    
    JLabel labelShapeGreen = new JLabel("Color Green");
    panel_3_3_1.add(labelShapeGreen);
    
    JPanel panel_3_1_2_1 = new JPanel();
    panel_3_1_2_1.setBounds(594, 147, 120, 26);
    contentPane.add(panel_3_1_2_1);
    
    JLabel labelShapeBlue = new JLabel("Color Blue");
    panel_3_1_2_1.add(labelShapeBlue);
    
    JPanel panel_4_2_1 = new JPanel();
    panel_4_2_1.setBounds(315, 169, 122, 26);
    contentPane.add(panel_4_2_1);
    
    shapeRed = new JTextField();
    panel_4_2_1.add(shapeRed);
    shapeRed.setColumns(10);
    
    JPanel panel_4_1_1_1 = new JPanel();
    panel_4_1_1_1.setBounds(458, 169, 120, 26);
    contentPane.add(panel_4_1_1_1);
    
    shapeGreen = new JTextField();
    shapeGreen.setColumns(10);
    panel_4_1_1_1.add(shapeGreen);
    
    JPanel panel_4_1_3_1 = new JPanel();
    panel_4_1_3_1.setBounds(590, 169, 124, 26);
    contentPane.add(panel_4_1_3_1);
    
    shapeBlue = new JTextField();
    shapeBlue.setColumns(10);
    panel_4_1_3_1.add(shapeBlue);
    
    JPanel panel_1_1 = new JPanel();
    panel_1_1.setBounds(5, 89, 198, 26);
    contentPane.add(panel_1_1);
    
    JLabel labelShapeName = new JLabel("Name of Shape");
    labelShapeName.setBounds(new Rectangle(0, 500, 0, 0));
    panel_1_1.add(labelShapeName);
    
    JPanel panel_4_2_2 = new JPanel();
    panel_4_2_2.setBounds(15, 114, 188, 26);
    contentPane.add(panel_4_2_2);
    
    shapeName = new JTextField();
    shapeName.setColumns(10);
    panel_4_2_2.add(shapeName);
    
    JButton createTheShape = new JButton("Create the Shape");
    createTheShape.setBounds(30, 147, 158, 48);
    contentPane.add(createTheShape);
    
    createTheShape.addActionListener(new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (createShape.getSelectedItem().toString().equals("Oval")) {
          model.addShape(shapeName.getText(), ShapeType.Oval, 
              Double.valueOf(shapeX.getText()), 
              Double.valueOf(shapeY.getText()), Double.valueOf(shapeWidth.getText()),
              Double.valueOf(shapeHeight.getText()), Double.valueOf(shapeRed.getText()),
              Double.valueOf(shapeGreen.getText()), Double.valueOf(shapeBlue.getText()),
              Integer.parseInt(shapeStart.getText()), Integer.parseInt(shapeEnd.getText()));
        } else {
          model.addShape(shapeName.getText(), ShapeType.Rectangle, 
              Double.valueOf(shapeX.getText()), 
              Double.valueOf(shapeY.getText()), Double.valueOf(shapeWidth.getText()),
              Double.valueOf(shapeHeight.getText()), Double.valueOf(shapeRed.getText()),
              Double.valueOf(shapeGreen.getText()), Double.valueOf(shapeBlue.getText()),
              Integer.parseInt(shapeStart.getText()), Integer.parseInt(shapeEnd.getText()));
        }
      }
    });
    
    
    
    JPanel panel_5 = new JPanel();
    panel_5.setBounds(new Rectangle(5, 5, 761, 26));
    panel_5.setBounds(5, 217, 761, 26);
    contentPane.add(panel_5);
    
    JLabel bigLabelAnimation = new JLabel("Add An Animation");
    panel_5.add(bigLabelAnimation);
    
    JPanel panel_1_2 = new JPanel();
    panel_1_2.setBounds(5, 245, 198, 26);
    contentPane.add(panel_1_2);
    
    JLabel lblNewLabel_1_2 = new JLabel("Type of Animation");
    lblNewLabel_1_2.setBounds(new Rectangle(0, 500, 0, 0));
    panel_1_2.add(lblNewLabel_1_2);
    
    JComboBox createAnimation = new JComboBox();
    createAnimation.setModel(new DefaultComboBoxModel(new String[] {
        "---Pease choose a type of animation---", "Change Color", "Scale", "Move"}));
    createAnimation.setSize(new Dimension(50, 0));
    createAnimation.setName("");
    createAnimation.setBounds(5, 272, 308, 27);
    contentPane.add(createAnimation);
    
    JPanel panel_1_1_1 = new JPanel();
    panel_1_1_1.setBounds(5, 296, 198, 26);
    contentPane.add(panel_1_1_1);
    
    JLabel lblNewLabel_1_1_1 = new JLabel("Name of Shape");
    lblNewLabel_1_1_1.setBounds(new Rectangle(0, 500, 0, 0));
    panel_1_1_1.add(lblNewLabel_1_1_1);
    
    animationName = new JTextField();
    animationName.setColumns(10);
    animationName.setBounds(43, 323, 130, 26);
    contentPane.add(animationName);
    
    JButton createTheAnimation = new JButton("Create the Animation");
    createTheAnimation.setBounds(30, 355, 158, 48);
    contentPane.add(createTheAnimation);
    
    JPanel panel_3_4 = new JPanel();
    panel_3_4.setBounds(325, 245, 120, 26);
    contentPane.add(panel_3_4);
    
    JLabel labelAnimationX = new JLabel("Coordinate X");
    panel_3_4.add(labelAnimationX);
    labelAnimationX.setVisible(false);
    
    JPanel panel_3_1_3 = new JPanel();
    panel_3_1_3.setBounds(458, 245, 120, 26);
    contentPane.add(panel_3_1_3);
    
    JLabel labelAnimationY = new JLabel("Coordinate Y");
    panel_3_1_3.add(labelAnimationY);
    labelAnimationY.setVisible(false);
    
    JPanel panel_3_1_1_1 = new JPanel();
    panel_3_1_1_1.setBounds(594, 245, 120, 26);
    contentPane.add(panel_3_1_1_1);
    
    JLabel labelAnimationStart = new JLabel("Start Time");
    panel_3_1_1_1.add(labelAnimationStart);
    
    animationX = new JTextField();
    animationX.setColumns(10);
    animationX.setBounds(325, 271, 130, 26);
    animationX.setVisible(false);
    contentPane.add(animationX);
    
    animationY = new JTextField();
    animationY.setColumns(10);
    animationY.setBounds(458, 271, 130, 26);
    animationY.setVisible(false);
    contentPane.add(animationY);
    
    animationStart = new JTextField();
    animationStart.setColumns(10);
    animationStart.setBounds(594, 271, 130, 26);
    contentPane.add(animationStart);
    
    JPanel panel_3_2_2 = new JPanel();
    panel_3_2_2.setBounds(325, 296, 120, 26);
    contentPane.add(panel_3_2_2);
    
    JLabel labelAnimationWidth = new JLabel("Width");
    panel_3_2_2.add(labelAnimationWidth);
    labelAnimationWidth.setVisible(false);
    
    JPanel panel_3_3_2 = new JPanel();
    panel_3_3_2.setBounds(458, 296, 120, 26);
    contentPane.add(panel_3_3_2);
    
    JLabel labelAnimationHeight = new JLabel("Height");
    panel_3_3_2.add(labelAnimationHeight);
    labelAnimationHeight.setVisible(false);
    
    JPanel panel_3_1_2_2 = new JPanel();
    panel_3_1_2_2.setBounds(594, 296, 120, 26);
    contentPane.add(panel_3_1_2_2);
    
    JLabel labelAnimationEnd = new JLabel("End Time");
    panel_3_1_2_2.add(labelAnimationEnd);
    
    animationWidth = new JTextField();
    animationWidth.setColumns(10);
    animationWidth.setBounds(325, 323, 130, 26);
    animationWidth.setVisible(false);
    contentPane.add(animationWidth);
    
    animationHeight = new JTextField();
    animationHeight.setColumns(10);
    animationHeight.setBounds(458, 323, 130, 26);
    animationHeight.setVisible(false);
    contentPane.add(animationHeight);
    
    animationEnd = new JTextField();
    animationEnd.setColumns(10);
    animationEnd.setBounds(594, 323, 130, 26);
    contentPane.add(animationEnd);
    
    JPanel panel_3_2_1_1 = new JPanel();
    panel_3_2_1_1.setBounds(325, 349, 120, 26);
    contentPane.add(panel_3_2_1_1);
    
    JLabel labelAnimationRed = new JLabel("Color Red");
    panel_3_2_1_1.add(labelAnimationRed);
    labelAnimationRed.setVisible(false);
    
    JPanel panel_3_3_1_1 = new JPanel();
    panel_3_3_1_1.setBounds(458, 349, 120, 26);
    contentPane.add(panel_3_3_1_1);
    
    JLabel labelAnimationGreen = new JLabel("Color Green");
    panel_3_3_1_1.add(labelAnimationGreen);
    labelAnimationGreen.setVisible(false);
    
    JPanel panel_3_1_2_1_1 = new JPanel();
    panel_3_1_2_1_1.setBounds(594, 349, 120, 26);
    contentPane.add(panel_3_1_2_1_1);
    
    JLabel labelAnimationBlue = new JLabel("Color Blue");
    panel_3_1_2_1_1.add(labelAnimationBlue);
    labelAnimationBlue.setVisible(false);
    
    animationRed = new JTextField();
    animationRed.setColumns(10);
    animationRed.setBounds(325, 377, 130, 26);
    animationRed.setVisible(false);
    contentPane.add(animationRed);
    
    animationGreen = new JTextField();
    animationGreen.setColumns(10);
    animationGreen.setBounds(458, 377, 130, 26);
    animationGreen.setVisible(false);
    contentPane.add(animationGreen);
    
    animationBlue = new JTextField();
    animationBlue.setColumns(10);
    animationBlue.setBounds(594, 377, 130, 26);
    animationBlue.setVisible(false);
    contentPane.add(animationBlue);
    
    JButton btnNewButton = new JButton("OK");
    btnNewButton.addActionListener(new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        
        switch (createAnimation.getSelectedItem().toString()) {
          case "Change Color":
            labelAnimationRed.setVisible(true);
            animationRed.setVisible(true);
            labelAnimationGreen.setVisible(true);
            animationGreen.setVisible(true);
            labelAnimationBlue.setVisible(true);
            animationBlue.setVisible(true);
            break;
          
          case "Scale":
            labelAnimationWidth.setVisible(true);
            animationWidth.setVisible(true);
            labelAnimationHeight.setVisible(true);
            animationHeight.setVisible(true);
            break;
          
          case "Move":
            labelAnimationX.setVisible(true);
            animationX.setVisible(true);
            labelAnimationY.setVisible(true);
            animationY.setVisible(true); 
            break;
          default:
        }
      } 
    }
    );
    btnNewButton.setBounds(209, 296, 104, 29);
    contentPane.add(btnNewButton);
    
    createTheAnimation.addActionListener(new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        
        switch (createAnimation.getSelectedItem().toString()) {
          case "Change Color":
            model.changeColor(animationName.getText(), Integer.parseInt(animationStart.getText()), 
                Integer.parseInt(animationEnd.getText()), Double.valueOf(animationRed.getText()),
                Double.valueOf(animationGreen.getText()), Double.valueOf(animationBlue.getText()));
            break;
          case "Scale":
          
            model.scale(animationName.getText(), Integer.parseInt(animationStart.getText()), 
                Integer.parseInt(animationEnd.getText()), Double.valueOf(animationWidth.getText()),
                Double.valueOf(animationHeight.getText()));
            break;
          case "Move":
          
            model.move(animationName.getText(), Integer.parseInt(animationStart.getText()), 
                Integer.parseInt(animationEnd.getText()), Double.valueOf(animationX.getText()),
                Double.valueOf(animationY.getText()));
            break;
          default:
        }
      }
    });
    
   
    
    
    JPanel panel_5_1 = new JPanel();
    panel_5_1.setBounds(new Rectangle(5, 5, 761, 26));
    panel_5_1.setBounds(0, 421, 761, 26);
    contentPane.add(panel_5_1);
    
    JLabel bigLableGenerateAnimation = new JLabel("Generate the Animation");
    panel_5_1.add(bigLableGenerateAnimation);
    
    JButton generateTheAnimation = new JButton("Generate the Animation");
    generateTheAnimation.setBounds(5, 459, 158, 48);
    contentPane.add(generateTheAnimation);
    
    JButton pauseAnimation = new JButton("Pause");
    pauseAnimation.setBounds(163, 459, 63, 48);
    contentPane.add(pauseAnimation);
    
    JButton playAnimation = new JButton("Play");
    playAnimation.setBounds(224, 459, 63, 48);
    contentPane.add(playAnimation);
    
    JPanel panel_1_1_1_1 = new JPanel();
    panel_1_1_1_1.setBounds(299, 471, 104, 26);
    contentPane.add(panel_1_1_1_1);
    
    JLabel lblNewLabel_1_1_1_1 = new JLabel("Speed");
    lblNewLabel_1_1_1_1.setBounds(new Rectangle(0, 500, 0, 0));
    panel_1_1_1_1.add(lblNewLabel_1_1_1_1);
    
    animationSpeed = new JTextField();
    animationSpeed.setColumns(10);
    animationSpeed.setBounds(299, 509, 104, 26);
    contentPane.add(animationSpeed);
    
    JButton setAnimationSpeed = new JButton("Set the Speed");
    setAnimationSpeed.setBounds(406, 459, 120, 48);
    contentPane.add(setAnimationSpeed);
    setAnimationSpeed.addActionListener(new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        
        AnimatorViewSVG v = new AnimatorViewSVG(model, "/Users/vino/Downloads/课程/samplGUI.svg");
        v.setSpeed(Integer.parseInt(animationSpeed.getText()));
        v.display(model);
      }
    });
    
    JButton btnRestart = new JButton("Restart");
    btnRestart.setBounds(5, 503, 158, 40);
    contentPane.add(btnRestart);
    
    JButton btnResume = new JButton("Resume");
    btnResume.setBounds(163, 503, 124, 40);
    contentPane.add(btnResume);
    
    JButton btnLoop = new JButton("Loop");
    btnLoop.setBounds(406, 503, 113, 40);
    contentPane.add(btnLoop);
    
    
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void display(AnimationModel m) {
    
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          AnimatorViewGUI frame = new AnimatorViewGUI(m);
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
    
  }

}
