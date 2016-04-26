package com.ooadproject.kja.checkers.views;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import com.ooadproject.kja.checkers.models.*;
import com.ooadproject.kja.checkers.utilities.*;
import com.ooadproject.kja.checkers.business_logic.*;


public class PieceView extends JPanel{
  private static final Color userPieceColor = new Color(251,52,54);
  private static final Color aiPieceColor = new Color(105,180,218);
  private static final int SPACE_PADDING = 47;
  private static final int hor_padding = 35;
  private static final int ver_padding = 15;

  private int viewHeight;
  private int viewWidth;

  private int spaceSize; 

  private Board checkersBoard;
  public PieceView(Board board, int width, int height) {
    viewWidth = width;
    viewHeight = height;
    spaceSize = (int)(width / 15);
    checkersBoard = board;
  }



  @Override
  public void paint(Graphics g){
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        int color = checkersBoard.piecesGrid[row][col].getColor();
        boolean isking = checkersBoard.piecesGrid[row][col].isKing();
        if(color == ConstantsHolder.RED && isking == true){
          g.setColor(userPieceColor);
          g.fillOval(SPACE_PADDING + col * spaceSize, SPACE_PADDING + row * spaceSize, 70, 70);
          g.setColor(Color.white);
          g.drawString("K", 120 + col*ConstantsHolder.multiplierColRow, 128 + row*ConstantsHolder.multiplierColRow);
        }
        else if(color == ConstantsHolder.BLACK && isking == true){
          g.setColor(aiPieceColor);
          g.fillOval(SPACE_PADDING + col * spaceSize, SPACE_PADDING + row * spaceSize, 70, 70);
          g.setColor(Color.white);
          g.drawString("K", 120 + col*ConstantsHolder.multiplierColRow, 128 + row*ConstantsHolder.multiplierColRow);
        }
        else if(color == ConstantsHolder.RED){
          g.setColor(userPieceColor);
          g.fillOval(SPACE_PADDING + col * spaceSize, SPACE_PADDING + row * spaceSize, 70, 70);
        }
        else if(color == ConstantsHolder.BLACK){
          g.setColor(aiPieceColor);
          g.fillOval(SPACE_PADDING + col * spaceSize, SPACE_PADDING + row * spaceSize, 70, 70);
        }

      }
    }
  }
}
/*
 * 
 */



/*
   int color = checkersBoard.piecesGrid[row][col].getColor();
   if(color == ConstantsHolder.RED){
   g.setColor(Color.RED);
   g.fillOval(col, row, 60, 60);
   }
   else if(color == ConstantsHolder.BLACK){
   g.setColor(Color.BLACK);
   g.fillOval(col, row, 60, 60);
   }
   */    

/*
   @Override
   protected void paintComponent(Graphics g) {
   super.paintComponent(g);
   Graphics2D g2d = (Graphics2D) g.create();
   g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   int dim = Math.max(600 - 4, 600 - 4);
   int x = (600 - dim) / 2;
   int y = (600 - dim) / 2;
   g2d.setColor(getBackground());
   g2d.fillOval(x, y, dim, dim);
   g2d.dispose();
   }
   */


