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
	private static Board checkersBoard;

	public void mouseClicked(MouseEvent e) {
		if (click == 0){
		// TODO Auto-generated method stub
			fromrow=(e.getY()-ConstantsHolder.RowSpacing)/ConstantsHolder.multiplierColRow;
			fromcol=(e.getX()-ConstantsHolder.ColSpacing)/ConstantsHolder.multiplierColRow;
			System.out.println("fromrow " + fromrow+", fromcol "+fromcol);
			click ++;
		}
		else if (click == 1){
			torow=(e.getY()-ConstantsHolder.RowSpacing)/ConstantsHolder.multiplierColRow;
			tocol=(e.getX()-ConstantsHolder.ColSpacing)/ConstantsHolder.multiplierColRow;
			System.out.println("torow " + torow+", tocol "+tocol);
			click = 0;
			
			
		}
		
		move = new Move(fromrow, fromcol, torow, tocol);
			
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

