package com.ooadproject.kja.checkers.views;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.ooadproject.kja.checkers.models.*;
import com.ooadproject.kja.checkers.utilities.*;
import com.ooadproject.kja.checkers.business_logic.*;


public class PieceView extends JPanel{
	private Board checkersBoard;
	public PieceView(Board checkersBoard) {
	       this.checkersBoard = checkersBoard;
	}
	@Override
	public void paint(Graphics g){
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
               int color = checkersBoard.piecesGrid[row][col].getColor();
               if(color == ConstantsHolder.RED){
                  g.setColor(Color.RED);
                  g.fillOval(col, row, 60, 60);
               }
               else if(color == ConstantsHolder.BLACK){
                   g.setColor(Color.BLACK);
                   g.fillOval(col, row, 60, 60);
               }
                   
            }		
		}
	}
}

