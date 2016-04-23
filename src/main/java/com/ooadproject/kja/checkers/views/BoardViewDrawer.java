package com.ooadproject.kja.checkers.views;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
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
	    //frame.setSize(800,800);
	    
	    //frame.getContentPane().add(new PieceView(checkersBoard));
	    //frame.setVisible(true);
	    //frame.setLayout(new GridLayout(0, 8));
	    frame.setBackground(Color.BLACK);
	    
		frame.setSize(800,600);
		//frame.setTitle("Checkers Palooza");
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
		frame.addMouseListener(new MouseListener() {
		    public void mouseClicked(MouseEvent e) {
		    	int fromrow=(e.getX()-ConstantsHolder.RowSpacing)/ConstantsHolder.multiplierColRow;
		        int fromcol=(e.getY()-ConstantsHolder.ColSpacing)/ConstantsHolder.multiplierColRow;
		        
		        System.out.println(fromcol+","+fromrow);
		    }
		    public void mousePressed(MouseEvent e) {}
		    
		    public void mouseEntered(MouseEvent e) {}

		    public void mouseExited(MouseEvent e) {}
		   
		    public void mouseReleased(MouseEvent e) {}
		});
		SwingUtilities.updateComponentTreeUI(frame);		
		
  }
 
}
