package com.ooadproject.kja.checkers.views;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
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
	
  public static void drawBoard(Board checkersBoard){
		
	  JFrame Board = new JFrame(); 
		Board.setSize(600,600); 
		Board.getContentPane().add(new BoardView()); 
		Board.setLocationRelativeTo(null); 
		Board.setBackground(Color.BLACK); 
		Board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		Board.setVisible(true);
		Board.setTitle("Checkers Palooza");
		Board.setLayout(new GridLayout(8,8));
		Board.getContentPane().add(new PieceView(checkersBoard)); 
	  
  }
  /*
  public void drawPiece(){
	  JPanel Piece = new JPanel();
	  Piece.add(new PieceView());
		//Piece.setShape(shape Oval);
		//Piece.getContentPane().add(new PieceView()); 
		//Piece.setLo
		//Piece.setBackground(Color.BLACK); 
		//Piece.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		Piece.setVisible(true);
	  
  }
  */
 

  
 
}
