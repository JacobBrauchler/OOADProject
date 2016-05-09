package com.ooadproject.kja.checkers.views;

import java.awt.Color;

import javax.swing.JOptionPane;

import com.ooadproject.kja.checkers.models.Board;
import com.ooadproject.kja.checkers.utilities.ConstantsHolder;
import com.ooadproject.kja.checkers.*;
import com.ooadproject.kja.checkers.business_logic.BoardLogic;

public class GameOverView extends JOptionPane {
	private static Board checkersBoard;
	 public GameOverView(Board board) {
		 if (board.getPieceCount(ConstantsHolder.BLACK) < board.getPieceCount(ConstantsHolder.RED)){
			 //JOptionPane.showMessageDialog(GameOver,"Game Over You Win! :)");
			 int response = JOptionPane.showConfirmDialog(null, "Game Over You win! Do you want to play again?", "Confirm",
	                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	        if (response == JOptionPane.NO_OPTION) {
	                System.exit(0);
	        } 
	            else if (response == JOptionPane.YES_OPTION) {
	            //restart game 
	            BoardLogic boardUtil = BoardLogic.getBoardLogic();
	            boardUtil.populateGrid(checkersBoard);
	        } 
	            else if (response == JOptionPane.CLOSED_OPTION) {
	                System.exit(0);
	        }
	     }
	 
		 //if (board.getPieceCount(ConstantsHolder.RED) < board.getPieceCount(ConstantsHolder.BLACK)){
		 else{
			 //JOptionPane.showMessageDialog(GameOver,"Game Over You Lose! :(");
			 //System.exit(0);
			 int response = JOptionPane.showConfirmDialog(null, "Game Over You lose! Do you want to play again?", "Confirm",
	                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	        if (response == JOptionPane.NO_OPTION) {
	                System.exit(0);
	        } 
	            else if (response == JOptionPane.YES_OPTION) {
	                //restart game
	            	BoardLogic boardUtil = BoardLogic.getBoardLogic();
		            boardUtil.populateGrid(checkersBoard);
	        } 
	            else if (response == JOptionPane.CLOSED_OPTION) {
	                System.exit(0);
	        }
		 
	
		 }

	 }
}
