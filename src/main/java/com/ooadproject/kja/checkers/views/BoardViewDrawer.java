package com.ooadproject.kja.checkers.views;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.ooadproject.kja.checkers.utilities.*;

import com.ooadproject.kja.checkers.models.*;
import com.ooadproject.kja.checkers.views.*;
import com.ooadproject.kja.checkers.business_logic.*;

public class BoardViewDrawer extends JFrame implements MouseListener {
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
/* (non-Javadoc)
 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
 */
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	int x = e.getX();
	int y = e.getY();
	System.out.println("Mouse Clicked at X: " + x + " - Y: " + y);

}
/* (non-Javadoc)
 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
 */
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	int x = e.getX();
    int y = e.getY();
    System.out.println("Mouse Pressed frame at X: " + x + " - Y: " + y);

}
/* (non-Javadoc)
 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
 */
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	int x = e.getX();
	int y = e.getY();
	System.out.println("Mouse Released at X: " + x + " - Y: " + y);
}
/* (non-Javadoc)
 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
 */
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	int x = e.getX();
    int y = e.getY();
    System.out.println("Mouse Entered frame at X: " + x + " - Y: " + y);
}
/* (non-Javadoc)
 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
 */
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	int x = e.getX();
	int y = e.getY();
	System.out.println("Mouse Exited at X: " + x + " - Y: " + y);
	
}
}
