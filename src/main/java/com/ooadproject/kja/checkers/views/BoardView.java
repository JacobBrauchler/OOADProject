package com.ooadproject.kja.checkers.views;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
import java.awt.*;

public class BoardView extends JPanel{
  private static final Color firstGridSquareColor = new Color(192,192,192);
  private static final Color secondGridSquareColor = new Color(64,64,64);
  private static final Color userPieceColor = new Color(251,52,54);
  private static final Color aiPieceColor = new Color(105,180,218);
  private static final int hor_padding = 35;
  private static final int ver_padding = 15;


  private int viewHeight;
  private int viewWidth;

  private int spaceSize; 

  public BoardView(int width, int height) {
    viewWidth = width;
    viewHeight = height;
    spaceSize = (int)(width / 15);
  }
  public void paint(Graphics g){
    for (int row = 0; row < 8; row++)
    {
      for (int col = 0; col < 8; col++)
      {
        if (row % 2 == col % 2)
          g.setColor(secondGridSquareColor);
        else
          g.setColor(firstGridSquareColor);
        g.fillRect(hor_padding + col * spaceSize, ver_padding + row * spaceSize, spaceSize, spaceSize);
      }
    }
  }
}


