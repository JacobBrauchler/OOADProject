package com.ooadproject.kja.checkers.views;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel{

  public SidePanel() {
    ButtonsPanel buttonsPanel = new ButtonsPanel();
    setBackground(Color.RED);
    setPreferredSize(new Dimension(400, 300));  
    BoxLayout boxLayout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
    setLayout(boxLayout);
    add(new JButton("SidePanelButton"));
    add(buttonsPanel);

  }
}

	
