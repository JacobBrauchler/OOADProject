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
import javax.swing.SwingUtilities;

import java.awt.Shape;

import com.ooadproject.kja.checkers.utilities.*;

import com.ooadproject.kja.checkers.models.*;
import com.ooadproject.kja.checkers.views.*;
import com.ooadproject.kja.checkers.business_logic.*;

public class BoardViewDrawer {
  private static Board checkersBoard;	
  public static void drawBoard(Board Board){
	  checkersBoard = Board;
		
	  
	  JFrame.setDefaultLookAndFeelDecorated(true);
	    JFrame frame = new JFrame("Checkers Palooza");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //frame.setSize(800,800);
	    
	    //frame.getContentPane().add(new PieceView(checkersBoard));
	    //frame.setVisible(true);
	    //frame.setLayout(new GridLayout(0, 8));
	    frame.setBackground(Color.BLACK);
		frame.setSize(600,600);
		//frame.setTitle("Checkers Palooza");
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.BLACK); 
		frame.getContentPane().add(new PieceView(checkersBoard));
		frame.setVisible(true);
		frame.setOpacity(1);
		frame.getContentPane().add(new BoardView());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		SwingUtilities.updateComponentTreeUI(frame);
		/*
		frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.add(new JPanel()).setBackground(Color.BLUE);
	    frame.add(new JPanel()).setBackground(Color.LIGHT_GRAY);
	    frame.setVisible(true);
	   
		*/
		//frame.getContentPane().add(new BoardView());
		//frame.setLocationRelativeTo(null);
		//frame.setVisible(true);
		//frame.setLayout(new GridLayout(0,8));
		
		 
		//frame.setBackground(Color.BLACK); 
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		
  }
}
