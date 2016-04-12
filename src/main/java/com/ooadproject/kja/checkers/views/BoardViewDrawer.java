package com.ooadproject.kja.checkers.views;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ooadproject.kja.checkers.utilities.*;

import com.ooadproject.kja.checkers.models.*;
import com.ooadproject.kja.checkers.views.*;
import com.ooadproject.kja.checkers.business_logic.*;

public class BoardViewDrawer {
  public static void drawBoard(){
		JFrame frame = new JFrame(); 
		frame.setSize(600,600); 
		frame.getContentPane().add(new BoardView()); 
		frame.setLocationRelativeTo(null); 
		frame.setBackground(Color.BLACK); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setVisible(true);
		frame.setLayout((LayoutManager) new GridLayout(8,8,0,3));
  }
}
