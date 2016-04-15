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
	private Board checkersBoard;
	public PieceView(Board Board) {
		checkersBoard = Board;
	}
	
	
	
	/*
	private JPanel piecePanel = new JPanel();
	public PieceView(Board checkersBoard) {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				int colorpiece = checkersBoard.piecesGrid[row][col].getColor();
				if(colorpiece == ConstantsHolder.RED){
					setOpaque(false);
		            setBackground(Color.RED);
		            
				}
				else if(colorpiece == ConstantsHolder.BLACK){
						setOpaque(false);
			            setBackground(Color.BLACK);
		
				}
	         }		
		}
	}
	*/
	/*
	public Board checkersBoard;
	public PieceView(Board checkersBoard) {
	       this.checkersBoard = checkersBoard;
	}
	*/
	@Override
	public void paint(Graphics g){
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				int color = checkersBoard.piecesGrid[row][col].getColor();
	              if(color == ConstantsHolder.RED){
	            	  g.setColor(Color.RED);
					  g.fillOval(ConstantsHolder.multiplierColRow*col+ConstantsHolder.ColSpacing, ConstantsHolder.multiplierColRow*row+ConstantsHolder.RowSpacing, ConstantsHolder.pieceSize, ConstantsHolder.pieceSize);
				  }
	              else if(color == ConstantsHolder.BLACK){
					  g.setColor(Color.BLACK);
					  g.fillOval(ConstantsHolder.multiplierColRow*col+ConstantsHolder.ColSpacing, ConstantsHolder.multiplierColRow*row+ConstantsHolder.RowSpacing, ConstantsHolder.pieceSize, ConstantsHolder.pieceSize);
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


