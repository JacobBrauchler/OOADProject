package com.ooadproject.kja.checkers.business_logic;

import com.ooadproject.kja.checkers.models.*;


public class BoardLogic {
	
	private final int RED = 1;
	private final int BLACK = 2;
	private final int EMPTY = 0;
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
						checkersBoard.piecesGrid[row][col] = new Piece(RED, col, row);
					else if (row > 4)
						checkersBoard.piecesGrid[row][col] = new Piece(BLACK, col, row);
					else
						checkersBoard.piecesGrid[row][col] = new Piece(EMPTY, col, row);
				} else
				{
					checkersBoard.piecesGrid[row][col] = new Piece(EMPTY, col, row);
				}
			}
		}
	
		return checkersBoard;

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
	  checkersBoard.piecesGrid[move.fromCol][move.fromRow].setColor(EMPTY);
	  return checkersBoard;
  }

  public boolean validateMove(Board checkersBoard, Move move){
	 return true; 
  }
  
  public void printGrid(Board checkersBoard){
	  int color;
	  for (int row = 0; row < 8; row++)
		{
			for (int col = 0; col < 8; col++)
			{
				color = checkersBoard.piecesGrid[col][row].getColor();
				switch(color){
					case BLACK: 
						System.out.print("" + row + "," + col + " equals black | ");
						break;
					case RED: 
						System.out.print("" + row + "," + col + " equals red | ");
						break;
					case EMPTY: 
						System.out.print("" + row + "," + col + " equals empty | ");
						break;	
				}	
			}
			System.out.println("");
		}
  }

  
}
