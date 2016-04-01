package com.ooadproject.kja.checkers.models;

public class Board {
  Piece [][] piecesGrid = new Piece[8][8];
  public int selectedColumn;
  public int selectedRow;

  public Board()
  {
    System.out.println("Hello from the Board constructor");
  }



  
