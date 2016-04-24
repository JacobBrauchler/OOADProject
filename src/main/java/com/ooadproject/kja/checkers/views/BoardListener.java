package com.ooadproject.kja.checkers.views;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.ooadproject.kja.checkers.utilities.ConstantsHolder;
import com.ooadproject.kja.checkers.views.*;

public class BoardListener implements MouseListener{
	int click = 0;

	public void mouseClicked(MouseEvent e) {
		if (click == 0){
		// TODO Auto-generated method stub
			int fromrow=(e.getY()-ConstantsHolder.RowSpacing)/ConstantsHolder.multiplierColRow;
			int fromcol=(e.getX()-ConstantsHolder.ColSpacing)/ConstantsHolder.multiplierColRow;
			System.out.println("fromrow " + fromrow+", fromcol "+fromcol);
			click ++;
		}
		else if (click == 1){
			int torow=(e.getY()-ConstantsHolder.RowSpacing)/ConstantsHolder.multiplierColRow;
			int tocol=(e.getX()-ConstantsHolder.ColSpacing)/ConstantsHolder.multiplierColRow;
			System.out.println("torow " + torow+", tocol "+tocol);
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

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}

