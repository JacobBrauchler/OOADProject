package com.ooadproject.kja.checkers.views;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import com.ooadproject.kja.checkers.models.*;
import com.ooadproject.kja.checkers.utilities.*;

public class SidePanel extends JPanel{
  private static final Color mainGreenColor = new Color(136,217,89);
  private static Board checkersBoard;
  
  public SidePanel(Board board) {
	  int redPieceCount = board.getPieceCount(ConstantsHolder.RED);
	  int blackPieceCount = board.getPieceCount(ConstantsHolder.BLACK);
    setBackground(Color.BLACK);
    ButtonsPanel buttonsPanel = new ButtonsPanel();
    //BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
    //setLayout(boxLayout);
    //
    setLayout(new BorderLayout());

    JLabel scoreLabel = new JLabel("Score");
    scoreLabel.setFont(new Font("Herculanum", Font.PLAIN, 45));
    scoreLabel.setForeground(mainGreenColor);
    scoreLabel.setBorder( new EmptyBorder( 0, 10, 0, 0 ) ); 
    //scoreLabel.setHorizontalAlignment(JLabel.CENTER);
    scoreLabel.setVerticalAlignment(JLabel.CENTER);
    
    JLabel score = new JLabel("Player = " + redPieceCount + " " + "CPU = " + blackPieceCount);
    score.setFont(new Font("Herculanum", Font.PLAIN, 35));
    score.setForeground(mainGreenColor);
    score.setBorder( new EmptyBorder( 0, 10, 0, 0 ) ); 
    score.setVerticalAlignment(JLabel.CENTER);

    add(scoreLabel, BorderLayout.PAGE_START);
    add(score, BorderLayout.CENTER);
    add(buttonsPanel, BorderLayout.PAGE_END);
  }
}

	
