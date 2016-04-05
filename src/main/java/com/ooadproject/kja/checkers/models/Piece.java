package com.ooadproject.kja.checkers.models;
public class Piece {

  private int color;
  private boolean isKing;
  private Move[] possibleMoves;
  private int column;
  private int row;

  public Piece(int color, int column, int row)
  {
    this.color = color;
    this.setRow(row);
    this.setColumn(column);
  }


  public int getColor() {
    return color;
  }

  public void setColor(int color) {
    this.color = color;
  }

  public boolean isKing() {
    return isKing;
  }

  public void setKing(boolean isKing) {
    this.isKing = isKing;
  }

  public Move[] getPossibleMoves() {
    return possibleMoves;
  }

  public void setPossibleMoves(Move[] possibleMoves) {
    this.possibleMoves = possibleMoves;
  }


public int getColumn() {
	return column;
}


public void setColumn(int column) {
	this.column = column;
}


public int getRow() {
	return row;
}


public void setRow(int row) {
	this.row = row;
}
}
