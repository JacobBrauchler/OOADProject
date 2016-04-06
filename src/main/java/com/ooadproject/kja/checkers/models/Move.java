package com.ooadproject.kja.checkers.models;
public class Move {
	public int fromRow;
	public int fromCol;
	public int toRow;
	public int toCol;
	public boolean hasJumpPotential = false;
	
	public Move(int fromRow, int fromCol, int toRow, int toCol)
	{
		this.fromRow = fromRow;
		this.fromCol = fromCol;
		this.toRow = toRow;
		this.toCol = toCol;
		
		int rowDiff = Math.abs(fromRow - toRow);
		int colDiff = Math.abs(fromCol - toCol);
		
		if(rowDiff == 2 && colDiff == 2){
			hasJumpPotential = true;
		}
	}
	
}
