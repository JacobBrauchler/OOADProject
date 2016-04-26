package com.ooadproject.kja.checkers.views;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel{

  public ButtonsPanel() {
    setBackground(Color.BLACK);
    setPreferredSize(new Dimension(400, 200));
    BoxLayout boxLayout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
    setLayout(boxLayout);
    add(new JButton("Button 1"));
    add(new JButton("Button 2"));
    add(new JButton("Button 3"));
  }
}

	
