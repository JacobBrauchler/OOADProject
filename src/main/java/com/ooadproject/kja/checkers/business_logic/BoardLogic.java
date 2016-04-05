package com.ooadproject.kja.checkers.business_logic;

import com.ooadproject.kja.checkers.models.*;
import com.ooadproject.kja.checkers.utilities.*;


public class BoardLogic {

  private static BoardLogic boardLogic;

  private BoardLogic()
  {
  }

  public static BoardLogic getBoardLogic(){
    System.out.println("Getting your board printer");
    if (boardLogic == null)
        boardLogic = new BoardLogic();
    return boardLogic;
  }

  public int getGridSize(Board checkersBoard)
  {
    return checkersBoard.piecesGrid[0].length;
  }

  public void populateGrid(Board checkersBoard)
  {
    int boardSize = getGridSize(checkersBoard);
    for (int row = 0; row < boardSize; row++)
    {
      for (int col = 0; col < boardSize; col++)
      {
        if (row % 2 != col % 2)
        {
          if (row < 3)
            checkersBoard.piecesGrid[row][col] = new Piece(ConstantsHolder.RED, row, col);
          else if (row > 4)
            checkersBoard.piecesGrid[row][col] = new Piece(ConstantsHolder.BLACK, row, col);
          else
            checkersBoard.piecesGrid[row][col] = new Piece(ConstantsHolder.EMPTY, row, col);
        } else
        {
          checkersBoard.piecesGrid[row][col] = new Piece(ConstantsHolder.EMPTY, row, col);
        }
      }
    }
  }
  public Piece getPiece(Board checkersBoard, int col, int row)
  {
    return checkersBoard.piecesGrid[col][row];
  }

  //Fix this
  public Board movePiece(Board checkersBoard, Move move)
  {
    checkersBoard.piecesGrid[move.toCol][move.toRow].setColor(checkersBoard.piecesGrid[move.fromCol][move.fromRow].getColor());
    //checkersBoard.piecesGrid[move.toCol][move.toRow] = checkersBoard.piecesGrid[move.fromCol][move.fromRow];
    checkersBoard.piecesGrid[move.fromCol][move.fromRow].setColor(ConstantsHolder.EMPTY);
    return checkersBoard;
  }

  public boolean validateMove(Board checkersBoard, Move move){
    return true; 
  }
}
