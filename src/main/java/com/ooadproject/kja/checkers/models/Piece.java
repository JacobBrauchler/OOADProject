package com.ooadproject.kja.checkers.models;
public class Piece {

  private int color;
  private boolean isKing;
  private Move[] possibleMoves;
  private int column;
  private int row;

  public Piece(int color, int column, int row)
  {
    System.out.println("Hello from the Piece constructor");
    this.color = color;
    this.row = row;
    this.column = column;
  }

  public int[] getPosition() {
    return position;
  }

  public void setPosition(int[] position) {
    this.position = position;
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
}
