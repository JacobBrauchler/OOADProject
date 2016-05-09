package com.ooadproject.kja.checkers.views;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import com.ooadproject.kja.checkers.models.*;;


public class ButtonsPanel extends JPanel{
  private static final Color mainGreenColor = new Color(136,217,89);
  public ButtonsPanel() {
    setBackground(Color.BLACK);
    setPreferredSize(new Dimension(400, 200));
    BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
    setLayout(boxLayout);
    
    CustomButton difficultyButton = new CustomButton("Toggle Difficulty");
    difficultyButton.setFont(new Font("Herculanum", Font.PLAIN, 20));
    difficultyButton.setForeground(mainGreenColor);
    difficultyButton.setForeground(Color.WHITE);
    difficultyButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	Player.setDifficulty(1);
        	
            
        }
    });

    CustomButton showAvailableMovesButton = new CustomButton("Show Available Moves");
    showAvailableMovesButton.setFont(new Font("Herculanum", Font.PLAIN, 20));
    showAvailableMovesButton.setForeground(Color.WHITE);
    showAvailableMovesButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	
            
        }
    });
    
    CustomButton motivateButton = new CustomButton("Motivate Me!");
    motivateButton.setFont(new Font("Herculanum", Font.PLAIN, 20));
    motivateButton.setForeground(mainGreenColor);
    motivateButton.setForeground(Color.WHITE);
    motivateButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            
        }
    });
    
    

    add(difficultyButton);
    add(showAvailableMovesButton);
    add(motivateButton);
    

  }
}

	
