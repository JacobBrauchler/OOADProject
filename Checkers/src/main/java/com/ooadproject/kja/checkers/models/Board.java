package com.ooadproject.kja.checkers.models;

import com.ooadproject.kja.checkers.utilities.*;

public class Board {
	public Piece [][] piecesGrid = new Piece[ConstantsHolder.BOARD_SIZE][ConstantsHolder.BOARD_SIZE];
	public int selectedColumn;
	public int selectedRow;
	public Move potentialMove;
	public static int redPieceCount = 12;
	public static int blackPieceCount = 12;
	public boolean playerOneTurn = true; 

	public Board()
	{
    potentialMove = null;
	}

	public int getPieceCount(int color) {
		if(color == ConstantsHolder.BLACK){
			return blackPieceCount; 
		}
		return redPieceCount;
	}

	public void setPieceCount(int color, int pieceCount) {
		if(color == ConstantsHolder.BLACK){
			blackPieceCount = pieceCount; 
		}
		else{
			redPieceCount = pieceCount; 
		}
	}
}




