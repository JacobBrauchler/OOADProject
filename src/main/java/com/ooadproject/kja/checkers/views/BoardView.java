package com.ooadproject.kja.checkers.views;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ooadproject.kja.checkers.utilities.*;

import com.ooadproject.kja.checkers.models.*;
import com.ooadproject.kja.checkers.business_logic.*;


public class BoardView extends JPanel{
	public void paint(Graphics g){
		g.setColor(Color.DARK_GRAY);
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
}

	
