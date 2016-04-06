package com.ooadproject.kja.checkers.models;

import com.ooadproject.kja.checkers.utilities.ConstantsHolder;

public class MoveLogic {
	
	public MoveLogic(){
		
	}
	
	public boolean preValidateMove(Move move){
	    boolean inBounds = isOutOfBounds(move);
	    boolean isDiag = isDiagonal(move);
	    boolean inRange = isInRange(move);
	    
	    if(inBounds && isDiag && inRange){
	    	return true;
	    }
		return false; 
	}
	
	public boolean isOutOfBounds(Move move){
		if(move.toRow < ConstantsHolder.BOARD_SIZE && move.toCol < ConstantsHolder.BOARD_SIZE){
			if(move.toRow >= 0 && move.toCol >= 0){
				return true;
			}		
		}
		return false;
	}
	
	public boolean isDiagonal(Move move){
		return Math.abs(move.toCol - move.fromCol) == Math.abs(move.toRow - move.toCol);
	}
	public boolean isInRange(Move move){
		int colDiff = Math.abs(move.toCol - move.fromCol);
		int rowDiff = Math.abs(move.toRow - move.toCol);
		if(colDiff > 2 || rowDiff > 2){
			return false;
		}
		return true;
	}
}
