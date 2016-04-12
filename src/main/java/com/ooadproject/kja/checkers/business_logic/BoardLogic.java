package com.ooadproject.kja.checkers.business_logic;

import com.ooadproject.kja.checkers.models.*;
import com.ooadproject.kja.checkers.utilities.*;


public class BoardLogic {

	private static BoardLogic boardLogic;
	public MoveLogic moveLogic = new MoveLogic();

	private BoardLogic() {}

	public static BoardLogic getBoardLogic(){
		if (boardLogic == null)
			boardLogic = new BoardLogic();
		return boardLogic;
	}

	public int getGridSize(Board checkersBoard) {
		return checkersBoard.piecesGrid[0].length;
	}

	public void populateGrid(Board checkersBoard) {
		int boardSize = getGridSize(checkersBoard);
		for (int row = 0; row < boardSize; row++) {
			for (int col = 0; col < boardSize; col++) {
				if (row % 2 != col % 2) {
					if (row < 3)
						checkersBoard.piecesGrid[row][col] = new Piece(ConstantsHolder.RED, row, col);
					else if (row > 4)
						checkersBoard.piecesGrid[row][col] = new Piece(ConstantsHolder.BLACK, row, col);
					else
						checkersBoard.piecesGrid[row][col] = new Piece(ConstantsHolder.EMPTY, row, col);
				} 
				else {
					checkersBoard.piecesGrid[row][col] = new Piece(ConstantsHolder.EMPTY, row, col);
				}
			}
		}
	}
	public Piece getPiece(Board checkersBoard, int col, int row) {
		return checkersBoard.piecesGrid[row][col];
	}


	public void movePiece(Board checkersBoard, Move move)
	{
		Piece pieceToBeMoved = checkersBoard.piecesGrid[move.fromRow][move.fromCol];
		pieceToBeMoved.setColumn(move.toCol);
		pieceToBeMoved.setRow(move.toRow);
		//pieceToBeMoved.printPiece();
		if(move.hasJumpPotential){

			int[] coordinates;
			coordinates = moveLogic.getMiddlePiece(checkersBoard, move);
			Piece jumpedPiece = checkersBoard.piecesGrid[coordinates[0]][coordinates[1]];
			int color = jumpedPiece.getColor();
			int currentCount = checkersBoard.getPieceCount(color);
			int newCount = currentCount - 1;
			checkersBoard.setPieceCount(color, newCount);
			//jumpPiece.printPiece();
			checkersBoard.piecesGrid[coordinates[0]][coordinates[1]] = new Piece(ConstantsHolder.EMPTY, coordinates[0], coordinates[1]);
		}
		checkersBoard.piecesGrid[move.toRow][move.toCol] = pieceToBeMoved;
		checkersBoard.piecesGrid[move.fromRow][move.fromCol] = new Piece(ConstantsHolder.EMPTY, move.fromRow, move.fromCol);
	}

	public boolean makeMove(Board checkersBoard, Move move){
		boolean initialCheck = moveLogic.preValidateMove(move);
		if(!initialCheck){
			System.out.println("Initial check failed! (there is no possible way that move is valid)");
			return false;
		}
		boolean finalCheck = moveLogic.finalValidateMove(checkersBoard, move);
		if(finalCheck){
			movePiece(checkersBoard, move);
			return true;
		}
		System.out.println("Sorry, cant make that move");
		return false;
	}

	public int checkForNextJump(Board checkersBoard, Piece piece, Move move){
		if(move.hasJumpPotential == false){
			System.out.println("Not jump move!");
			return 0;
		}
		int moveMultiplier = 1;
		int curCol = piece.getColumn();
		int curRow = piece.getRow();
		int color = piece.getColor();
		if(color == ConstantsHolder.BLACK && !piece.isKing()){
			moveMultiplier = -1;
		}
		
		int checkDiagonals = moveLogic.anotherMoveCheck(checkersBoard, piece);
		System.out.println(checkDiagonals);
		if(checkDiagonals == 0){
		}
		else if(checkDiagonals == 1){
			move.fromCol = move.toCol;
			move.fromRow = move.toRow;
			move.toCol = (curCol - 2);
			move.toRow = (curRow + (moveMultiplier * 2));
		}
		else if(checkDiagonals == 2){
			move.fromCol = move.toCol;
			move.fromRow = move.toRow;
			move.toCol = (curCol + 2);
			move.toRow = (curRow + (moveMultiplier * 2));
		}
		
		//call move or not based on return from anotherMoveCheck after UI
		return checkDiagonals;
	}

}
