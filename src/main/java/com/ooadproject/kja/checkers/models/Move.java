package com.ooadproject.kja.checkers.models;
public class Move {
	//singleton?
	public int fromCol;
	public int fromRow;
	public int toCol;
	public int toRow;
	
	public Move(int fromCol, int fromRow, int toCol, int toRow)
	{
		this.fromCol = fromCol;
		this.toCol = toCol;
		this.toRow = toRow;
		this.fromRow = fromRow;
	}
	
}
