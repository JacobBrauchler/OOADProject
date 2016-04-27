package com.ooadproject.kja.checkers.views;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomButton extends JButton  {
  private static final Color darkGreenColor = new Color(53,148,32);
  private static final Color lightGreenColor = new Color(122,211,72);
  private static final Color mainGreenColor = new Color(136,217,89);
  public CustomButton(String title) {
    super(title);
    //setOpaque(true);
    //setBorderPainted(false);
    setContentAreaFilled(false);
    //setFocusPainted(false); // used for demonstration
    addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent evt)
      {
        setForeground(mainGreenColor);
        repaint();
      }
      @Override
      public void mouseExited(MouseEvent evt)
      {
        setForeground(Color.WHITE);
        repaint();
      }
    });
  }

  @Override
  protected void paintComponent(Graphics g) {
    final Graphics2D g2 = (Graphics2D) g.create();
    g2.setPaint(new GradientPaint(
          new Point(0, 0), 
          lightGreenColor, 
          new Point(0, getHeight()), 
          darkGreenColor));
    g2.fillRect(0, 0, getWidth(), getHeight());
    g2.dispose();

    super.paintComponent(g);
  }
}
