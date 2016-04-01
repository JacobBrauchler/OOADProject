package com.ooadproject.kja.checkers.business_logic;

import com.ooadproject.kja.checkers.models.Board;


public class BoardLogic {

  public BoardLogic()
  {

  }

  public Board populateGrid(Board checkersBoard)
  {

    for (int row = 0; row < 8; row++)
    {
      for (int col = 0; col < 8; col++)
      {
        if (row % 2 != col % 2)
        {
          if (row < 3)
            checkersBoard[col][row] = new Piece(RED, col, row);
          else if (row > 4)
            checkersBoard[col][row] = new Piece(BLACK, col, row);
          else
            checkersBoard[col][row] = null;
        } else
        {
          checkersBoard[col][row] = null;
        }
      }
    }



      }
    }
    for 1 to 8
      for 1 to 8
        set some to created red piece
        set some to created black piece
        set some to null

  }
  public piece getPiece(coorpair)
  {

  }


  public void movePiece(Move move)
  {

  }

  public boolean validateMove(Boardgrid, Move)

  
}
