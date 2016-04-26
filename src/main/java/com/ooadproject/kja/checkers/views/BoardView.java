package com.ooadproject.kja.checkers.views;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoardView extends JPanel{

  public BoardView() {
  }
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(100, 100, 400, 400); 
		for(int i = 100; i <= 400; i+=100){ 
			for(int j = 100; j <= 400; j+=100){ 
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(i, j, 50, 50); 
				} 
			}
		for(int i = 150; i <= 450; i+=100){ 
			for(int j = 150; j <= 450; j+=100){ 
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(i, j, 50, 50); 
				} 
			}
		
		}
	/*
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawOval(100, 100, 10, 10);
	}
	*/
	
}

	
