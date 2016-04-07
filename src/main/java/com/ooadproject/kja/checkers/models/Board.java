package com.ooadproject.kja.checkers.models;

import com.ooadproject.kja.checkers.utilities.*;

public class Board {
	public Piece [][] piecesGrid = new Piece[ConstantsHolder.BOARD_SIZE][ConstantsHolder.BOARD_SIZE];
	public int selectedColumn;
	public int selectedRow;
	private int redPieceCount = 12;
	private int blackPieceCount = 12;

	public Board()
	{
	}

	public int getPieceCount(int color) {
		if(color == ConstantsHolder.BLACK){
			return this.blackPieceCount; 
		}
		return this.redPieceCount;
	}

	public void setPieceCount(int color, int pieceCount) {
		if(color == ConstantsHolder.BLACK){
			this.blackPieceCount = pieceCount; 
		}
		else{
			this.redPieceCount = pieceCount; 
		}
	}

	
	

}




