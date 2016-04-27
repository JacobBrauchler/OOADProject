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
    System.out.println(spaceSize);
  }
  @Override
  public void paintComponent(Graphics g){
    for (int row = 0; row < 8; row++)
    {
      for (int col = 0; col < 8; col++)
      {
        if (row % 2 == col % 2)
          g.setColor(secondGridSquareColor);
        else
          g.setColor(firstGridSquareColor);
        g.fillRect(hor_padding + col * spaceSize, ver_padding + row * spaceSize, spaceSize, spaceSize);

        /** draws the coordinate pair of the given square in the upper right corner of the square */
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        g.drawString("" + row + col, hor_padding + 4 + col * spaceSize, ver_padding + 14 + row * spaceSize);
      }
    }

    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        int color = checkersBoard.piecesGrid[row][col].getColor();
        boolean isking = checkersBoard.piecesGrid[row][col].isKing();
        if(color == ConstantsHolder.RED && isking == true){
          g.setColor(userPieceColor);
          g.fillOval(hor_SPACE_PADDING + col * spaceSize, ver_SPACE_PADDING + row * spaceSize, 60, 60);
          g.setColor(Color.white);
          g.drawString("K", hor_SPACE_PADDING + 25 + col * spaceSize, ver_SPACE_PADDING + 30 + row * spaceSize);
        }
        else if(color == ConstantsHolder.BLACK && isking == true){
          g.setColor(aiPieceColor);
          g.fillOval(hor_SPACE_PADDING + col * spaceSize, ver_SPACE_PADDING + row * spaceSize, 60, 60);
          g.setColor(Color.white);
          g.drawString("K", hor_SPACE_PADDING + 25 + col * spaceSize, ver_SPACE_PADDING + 30 + row * spaceSize);
        }
        else if(color == ConstantsHolder.RED){
          g.setColor(userPieceColor);
          g.fillOval(hor_SPACE_PADDING + col * spaceSize, ver_SPACE_PADDING + row * spaceSize, 60, 60);
          g.setColor(Color.white);
          
        }
        else if(color == ConstantsHolder.BLACK){
          g.setColor(aiPieceColor);
          g.fillOval(hor_SPACE_PADDING + col * spaceSize, ver_SPACE_PADDING + row * spaceSize, 60, 60);
        }

      }
    }

    if (!( (checkersBoard.selectedColumn == 0) && (checkersBoard.selectedRow == 0) )) {
      g.setColor(Color.GREEN);
      g.fillOval(hor_SPACE_PADDING + checkersBoard.selectedColumn * spaceSize, ver_SPACE_PADDING + checkersBoard.selectedRow * spaceSize, 60, 60);
    }
  }
}


