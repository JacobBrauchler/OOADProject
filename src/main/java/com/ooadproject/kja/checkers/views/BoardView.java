package com.ooadproject.kja.checkers.views;
import java.awt.Color;
import java.awt.Graphics;
import com.ooadproject.kja.checkers.utilities.*;
import com.ooadproject.kja.checkers.models.*;

import javax.swing.*;
import java.awt.*;

public class BoardView extends JPanel{
  private static final Color firstGridSquareColor = new Color(192,192,192);
  private static final Color secondGridSquareColor = new Color(64,64,64);
  private static final Color userPieceColor = new Color(251,52,54);
  private static final Color aiPieceColor = new Color(105,180,218);
  private static final int hor_padding = 35;
  private static final int ver_padding = 15;
  private static final int hor_SPACE_PADDING = 40;
  private static final int ver_SPACE_PADDING = 22;


  private Board checkersBoard;

  private int viewHeight;
  private int viewWidth;

  private int spaceSize; 

  public BoardView(Board board, int width, int height) {
    viewWidth = width;
    viewHeight = height;
    spaceSize = (int)(width / 15);
    checkersBoard = board;
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

    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        int color = checkersBoard.piecesGrid[row][col].getColor();
        boolean isking = checkersBoard.piecesGrid[row][col].isKing();
        if(color == ConstantsHolder.RED && isking == true){
          g.setColor(userPieceColor);
          g.fillOval(hor_SPACE_PADDING + col * spaceSize, ver_SPACE_PADDING + row * spaceSize, 70, 70);
          g.setColor(Color.white);
          g.drawString("K", 120 + col*ConstantsHolder.multiplierColRow, 128 + row*ConstantsHolder.multiplierColRow);
        }
        else if(color == ConstantsHolder.BLACK && isking == true){
          g.setColor(aiPieceColor);
          g.fillOval(hor_SPACE_PADDING + col * spaceSize, ver_SPACE_PADDING + row * spaceSize, 70, 70);
          g.setColor(Color.white);
          g.drawString("K", 120 + col*ConstantsHolder.multiplierColRow, 128 + row*ConstantsHolder.multiplierColRow);
        }
        else if(color == ConstantsHolder.RED){
          g.setColor(userPieceColor);
          g.fillOval(hor_SPACE_PADDING + col * spaceSize, ver_SPACE_PADDING + row * spaceSize, 70, 70);
        }
        else if(color == ConstantsHolder.BLACK){
          g.setColor(aiPieceColor);
          g.fillOval(hor_SPACE_PADDING + col * spaceSize, ver_SPACE_PADDING + row * spaceSize, 70, 70);
        }

      }
    }
  }
}


