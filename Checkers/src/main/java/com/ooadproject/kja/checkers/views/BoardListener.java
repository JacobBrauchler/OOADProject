package com.ooadproject.kja.checkers.views;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.ooadproject.kja.checkers.models.Board;
import com.ooadproject.kja.checkers.models.Move;
import com.ooadproject.kja.checkers.utilities.ConstantsHolder;
import com.ooadproject.kja.checkers.views.*;
import com.ooadproject.kja.checkers.business_logic.*;

public class BoardListener implements MouseListener, ActionListener{
	int click = 0;
	Move move;
	int fromcol;
	int fromrow;
	int torow;
	int tocol;
	
	private static final int hor_SPACE_PADDING = 40;
	private static final int ver_SPACE_PADDING = 90;
	private int spaceSize = 72;
	private static Board checkersBoard;
	private GameView gameView;

  public BoardListener(GameView gameView, Board board)
  {
    checkersBoard = board;
    this.gameView = gameView;
  }

	public void mouseClicked(MouseEvent e) {
    click ++;
		if (click == 1){
		// TODO Auto-generated method stub
			fromrow=(e.getY()-ver_SPACE_PADDING)/spaceSize;
			fromcol=(e.getX()-hor_SPACE_PADDING)/spaceSize;
      checkersBoard.selectedColumn = fromcol;
      checkersBoard.selectedRow = fromrow;
    
      gameView.reDrawBoard(checkersBoard);

			//hor_SPACE_PADDING + col * spaceSize
		}
		if (click == 2){
      checkersBoard.selectedColumn = 0;
      checkersBoard.selectedRow = 0;
			torow=(e.getY()-ver_SPACE_PADDING)/spaceSize;
			tocol=(e.getX()-hor_SPACE_PADDING)/spaceSize;
      gameView.reDrawBoard(checkersBoard);
		}
		
    if (click == 2) {
		move = new Move(fromrow, fromcol, torow, tocol);
    checkersBoard.potentialMove = move;
    click = 0;
    }
			
	}


	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}

