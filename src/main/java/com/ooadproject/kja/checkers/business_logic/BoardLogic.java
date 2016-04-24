package com.ooadproject.kja.checkers.business_logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
		if(move.hasJumpPotential){

			int[] coordinates;
			coordinates = moveLogic.getMiddlePiece(checkersBoard, move);
			Piece jumpedPiece = checkersBoard.piecesGrid[coordinates[0]][coordinates[1]];
			int color = jumpedPiece.getColor();
			int currentCount = checkersBoard.getPieceCount(color);
			int newCount = currentCount - 1;
			checkersBoard.setPieceCount(color, newCount);
			checkersBoard.piecesGrid[coordinates[0]][coordinates[1]] = new Piece(ConstantsHolder.EMPTY, coordinates[0], coordinates[1]);
		}
		checkersBoard.piecesGrid[move.toRow][move.toCol] = pieceToBeMoved;
		checkersBoard.piecesGrid[move.fromRow][move.fromCol] = new Piece(ConstantsHolder.EMPTY, move.fromRow, move.fromCol);
	}

	public boolean makeMove(Board checkersBoard, Move move){
		if(checkersBoard.piecesGrid[move.fromRow][move.fromCol].getColor() == ConstantsHolder.BLACK && checkersBoard.playerOneTurn == true){
			System.out.println("Not your Color! Your color is Red");
			return false;
		}
		if(checkersBoard.piecesGrid[move.fromRow][move.fromCol].getColor() == ConstantsHolder.RED && checkersBoard.playerOneTurn == false){
			System.out.println("Not your Move!");
			return false;
		}
		
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
	//if another jump move is available, allow user to choose
	public void userJump(JumpMove jump, Move move){
		int curCol = move.fromCol;
		int curRow = move.fromRow;
		
		if(jump.isBackLeft()){
    		System.out.println("If you wish to jump back left, press 1");
    	}
    	if(jump.isBackRight()){
    		System.out.println("If you wish to jump back right, press 2");
    	}
    	if(jump.isForwardLeft()){
    		System.out.println("If you wish to jump forward left, press 3");
    	}
    	if(jump.isForwardRight()){
    		System.out.println("If you wish to jump forward right, press 4");
    	}
    	Scanner userInput = new Scanner(System.in);
    	int choice = userInput.nextInt();
    	move.fromCol = move.toCol;
		move.fromRow = move.toRow;
    	if(choice == 1){
			move.toCol = (curCol - 2);
			move.toRow = (curRow - 2);
    	}
    	else if(choice == 2){
			move.toCol = (curCol + 2);
			move.toRow = (curRow - 2);
    	}
    	else if(choice == 3){
			move.toCol = (curCol - 2);
			move.toRow = (curRow + 2);
    	}
    	else if(choice == 4){
			move.toCol = (curCol + 2);
			move.toRow = (curRow + 2);
    	}
	}

	//if another move is available, ai takes random jump
	public void aiJump(JumpMove jump, Move move){
		int curCol = move.fromCol;
		int curRow = move.fromRow;
		List<Integer> choices = new ArrayList<Integer>();
		Random rand = new Random();
		
		if(jump.isBackLeft()){
    		choices.add(1);
    	}
    	if(jump.isBackRight()){
    		choices.add(2);
    	}
    	if(jump.isForwardLeft()){
    		choices.add(3);
    	}
    	if(jump.isForwardRight()){
    		choices.add(4);
    	}
    	int index = rand.nextInt(choices.size());
    	int choice = choices.get(index);
    	move.fromCol = move.toCol;
		move.fromRow = move.toRow;
    	if(choice == 1){
			move.toCol = (curCol - 2);
			move.toRow = (curRow + 2);
    	}
    	else if(choice == 2){
			move.toCol = (curCol + 2);
			move.toRow = (curRow + 2);
    	}
    	else if(choice == 3){
			move.toCol = (curCol - 2);
			move.toRow = (curRow - 2);
    	}
    	else if(choice == 4){
			move.toCol = (curCol + 2);
			move.toRow = (curRow - 2);
    	}
	}
	
	public JumpMove checkForNextJump(Board checkersBoard, Piece piece, Move move){
		JumpMove jump = new JumpMove();
		if(move.hasJumpPotential == false){
			System.out.println("Not jump move!");
			return jump;
		}
		
		jump = moveLogic.anotherMoveCheck(checkersBoard, piece);
		return jump;
	}

}
