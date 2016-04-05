package com.ooadproject.kja.checkers.models;

import com.ooadproject.kja.checkers.utilities.*;

public class Board {
	public Piece [][] piecesGrid = new Piece[ConstantsHolder.BOARD_SIZE][ConstantsHolder.BOARD_SIZE];
	public int selectedColumn;
	public int selectedRow;

	public Board()
	{
		System.out.println("Hello from the Board constructor");
	}

}




