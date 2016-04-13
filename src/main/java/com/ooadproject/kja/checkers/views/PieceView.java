package com.ooadproject.kja.checkers.views;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.ooadproject.kja.checkers.models.*;
import com.ooadproject.kja.checkers.utilities.*;


public class PieceView extends JComponent{
	public void paint(Graphics g, Board checkersBoard ){
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
               switch (checkersBoard.piecesGrid[row][col].getColor()) {
               case Piece.RED:
                  g.setColor(Color.RED);
                  g.fillOval(4 + col*20, 4 + row*20, 60, 160);
                  break;
               case ConstantsHolder.BLACK:
                  g.setColor(Color.BLACK);
                  g.fillOval(4 + col*20, 4 + row*20, 60, 60);
                  break;
               case ConstantsHolder.EMPTY:
                  g.setColor(Color.WHITE);
                  g.fillOval(4 + col*20, 4 + row*20, 60, 60);
                  break;
               }
            }
		
		}
	}
}

