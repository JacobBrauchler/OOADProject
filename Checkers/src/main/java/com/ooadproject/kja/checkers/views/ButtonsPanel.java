package com.ooadproject.kja.checkers.views;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
import java.awt.*;


public class ButtonsPanel extends JPanel{
  private static final Color mainGreenColor = new Color(136,217,89);
  public ButtonsPanel() {
    setBackground(Color.BLACK);
    setPreferredSize(new Dimension(400, 200));
    BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
    setLayout(boxLayout);

    CustomButton showAvailableMovesButton = new CustomButton("Show Available Moves");
    showAvailableMovesButton.setFont(new Font("Herculanum", Font.PLAIN, 20));
    showAvailableMovesButton.setForeground(Color.WHITE);
    


    CustomButton motivateButton = new CustomButton("Motivate Me!");
    motivateButton.setFont(new Font("Herculanum", Font.PLAIN, 20));
    motivateButton.setForeground(mainGreenColor);
    motivateButton.setForeground(Color.WHITE);


    add(showAvailableMovesButton);
    add(motivateButton);

  }
}

	
