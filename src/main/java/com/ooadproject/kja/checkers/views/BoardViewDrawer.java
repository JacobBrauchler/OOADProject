package com.ooadproject.kja.checkers.views;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	    JButton showmoves = new JButton("Show Available Moves");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBackground(Color.BLACK);
	    
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.BLACK); 
		frame.getContentPane().add(new PieceView(checkersBoard));
		frame.setVisible(true);
		frame.setOpacity(1);
		frame.getContentPane().add(new BoardView());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		JLabel score = new JLabel("Score");
		frame.setLayout(null);
	    score.setBounds(ConstantsHolder.buttonPositionX,100,150,60);
		JButton button = new JButton("Pause Game");
		button.setBackground(Color.GREEN);
		button.setOpaque(true);
	    button.setBounds(ConstantsHolder.buttonPositionX,240,ConstantsHolder.buttonWidth,ConstantsHolder.buttonHeight);
		JButton button1 = new JButton("Show Available Moves");
		button1.setBackground(Color.GREEN);
		button1.setOpaque(true);
	    button1.setBounds(ConstantsHolder.buttonPositionX,300,ConstantsHolder.buttonWidth,ConstantsHolder.buttonHeight);
	    JButton button2 = new JButton("Get Best Move");
		button2.setBackground(Color.GREEN);
		button2.setOpaque(true);
	    button2.setBounds(ConstantsHolder.buttonPositionX,360,ConstantsHolder.buttonWidth,ConstantsHolder.buttonHeight);
	    JButton button3 = new JButton("Motivate Me");
		button3.setBackground(Color.GREEN);
		button3.setOpaque(true);
	    button3.setBounds(ConstantsHolder.buttonPositionX,420,ConstantsHolder.buttonWidth,ConstantsHolder.buttonHeight);
	    frame.add(button);
	    frame.add(button1);
	    frame.add(button2);
	    frame.add(button3);
	    BoardListener click = new BoardListener();
		frame.addMouseListener(click); 
		
		
		SwingUtilities.updateComponentTreeUI(frame);
	    button.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evt){
	    		System.out.println("Pause Game clicked");
	    	}
	    });
	    button1.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evt){
	    		System.out.println("Show Available Moves clicked");
	    	
	    	}
	    	
	    });
	    button2.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evt){
	    		System.out.println("Get Best Moves clicked");
	    	
	    	}
	    	
	    });
	    button3.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent evt){
	    		System.out.println("Motivate Me clicked");
	    	
	    	}
	    	
	    });
		
  }
 
}
