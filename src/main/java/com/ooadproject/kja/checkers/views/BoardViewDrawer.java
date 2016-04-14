package com.ooadproject.kja.checkers.views;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.Shape;

import com.ooadproject.kja.checkers.utilities.*;

import com.ooadproject.kja.checkers.models.*;
import com.ooadproject.kja.checkers.views.*;
import com.ooadproject.kja.checkers.business_logic.*;

public class BoardViewDrawer {
  private static Board checkersBoard;	
  public static void drawBoard(Board Board){
	  checkersBoard = Board;
		
	  JFrame frame = new JFrame();
		frame.setSize(600,600);
		frame.setTitle("Checkers Palooza");
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.BLACK); 
		frame.getContentPane().add(new PieceView(checkersBoard));
		frame.setVisible(true);
		frame.setOpacity(1);
		frame.getContentPane().add(new BoardView());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		 
		//frame.setBackground(Color.BLACK); 
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		//frame.setLayout(new GridLayout(8,8));
		
		
  }
  /*
  public void paint(Graphics g){
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				int color = checkersBoard.piecesGrid[row][col].getColor();
	              if(color == ConstantsHolder.RED){
	            	  g.setColor(Color.RED);
					  g.fillOval(50*col, 50*row, 60, 60);
				  }
				  else if (row > 4){
					  g.setColor(Color.BLACK);
					  g.fillOval(50*col, 50*row, 60, 60);
				  }
							
			}
		}
	}
  /*
  protected void paintComponent(Graphics g)
  {
      super.paintComponent(g);
      g.setColor(Color.RED);
      g.drawString("MyString", x, y);
      x += 10;
      y += 10;
  }
  */
  
 
  /*
  public static void drawPieces(Board checkersBoard){
	  JPanel Piece = new JPanel();
	  Piece.add(new PieceView(checkersBoard));
		//Piece.setShape(shape Oval);
		//Piece.getContentPane().add(new PieceView()); 
		//Piece.setLo
		//Piece.setBackground(Color.BLACK); 
		//Piece.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		Piece.setVisible(true);
	  
  }
 */ 
  
 

  
 
}
