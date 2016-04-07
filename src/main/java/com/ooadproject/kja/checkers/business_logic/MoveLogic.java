package com.ooadproject.kja.checkers.business_logic;

import com.ooadproject.kja.checkers.utilities.*;
import com.ooadproject.kja.checkers.models.*;
//import com.ooadproject.kja.checkers.business_logic.*;

public class MoveLogic {
	private int moveMultiplier = 1;
	
	public MoveLogic(){
		
	}
	
	public boolean preValidateMove(Move move){
	    boolean inBounds = isInBounds(move);
	    boolean isDiag = isDiagonal(move);
	    boolean inRange = isInRange(move);

      //System.out.println("inBounds = "+ inBounds);
      //System.out.println("isDiag = "+ isDiag);
      //System.out.println("inRange = "+ inRange);
	    
	    if(inBounds && isDiag && inRange){
	    	return true;
	    }
		return false; 
	}
	
	public boolean isInBounds(Move move){
		if(move.toRow < ConstantsHolder.BOARD_SIZE && move.toCol < ConstantsHolder.BOARD_SIZE){
			if(move.toRow >= 0 && move.toCol >= 0){
				return true;
			}		
		}
		return false;
	}
	
	public boolean isDiagonal(Move move){
		return Math.abs(move.toCol - move.fromCol) == Math.abs(move.toRow - move.fromRow);
	}
	public boolean isInRange(Move move){
		int colDiff = Math.abs(move.toCol - move.fromCol);
		int rowDiff = Math.abs(move.toRow - move.fromRow);
		if(colDiff > 2 || rowDiff > 2){
			return false;
		}
		return true;
	}
	
	public boolean finalValidateMove(Board checkersBoard, Move move){
		boolean isValidDirection = checkDirection(checkersBoard, move);
		boolean isOpenSpot = checkSpot(checkersBoard, move);
		boolean canJump = true;
		if(move.hasJumpPotential){
			canJump = checkJumpee(checkersBoard, move);
		}
		
	    //System.out.println("isValidDirection = " + isValidDirection);
	    //System.out.println("isOpenSpot = " + isOpenSpot);
		
	    return (isValidDirection && isOpenSpot && canJump);
		
	}
	
	public boolean checkDirection(Board checkersBoard, Move move){
		moveMultiplier = 1;
		Piece selectedPiece = checkersBoard.piecesGrid[move.fromRow][move.fromCol];
		//selectedPiece.printPiece();
		if(selectedPiece.isKing()){
			return true;
		}
		if(selectedPiece.getColor() == ConstantsHolder.BLACK){
			moveMultiplier = -1;
		}
		int rowDiff = (move.toRow - move.fromRow) * moveMultiplier;
		if(rowDiff < 0){
			return false;
		}
		return true;
	}
	
	public boolean checkSpot(Board checkersBoard, Move move){
		Piece selectedSpot = checkersBoard.piecesGrid[move.toRow][move.toCol];
		if(selectedSpot.getColor() != ConstantsHolder.EMPTY){
			return false;
		}
		return true;
	}
	
	public boolean checkJumpee(Board checkersBoard, Move move){
		Piece selectedPiece = checkersBoard.piecesGrid[move.fromRow][move.fromCol];
		//Piece jumpedPiece = getMiddlePiece(checkersBoard, move);
		int[] coordinates;
		coordinates = getMiddlePiece(checkersBoard, move);
		//System.out.println("Coordinates: " + coordinates[0] + " " + coordinates[1]);
		Piece jumpedPiece = checkersBoard.piecesGrid[coordinates[0]][coordinates[1]];
		
		if( jumpedPiece.getColor() == selectedPiece.getColor()){
			return false;
		}
		if(jumpedPiece.getColor() == ConstantsHolder.EMPTY){
			return false;
		}
		return true;
	}
	public int[] getMiddlePiece(Board checkersBoard, Move move){
		moveMultiplier = 1;
		int[] coordinates = new int[2];
		Piece selectedPiece = checkersBoard.piecesGrid[move.fromRow][move.fromCol];
		if(selectedPiece.getColor() == ConstantsHolder.BLACK && !selectedPiece.isKing()){
			moveMultiplier = -1;
		}

		if(move.toCol < move.fromCol){
			coordinates[1]= move.fromCol - (Math.abs(move.fromCol - move.toCol)/2);
		}
		else{
			coordinates[1]= move.fromCol + 1 * (Math.abs(move.fromCol - move.toCol)/2);
		}
		coordinates[0] = move.fromRow + moveMultiplier * (Math.abs(move.fromRow - move.toRow)/2);
		
		return coordinates;
	}
	
	public String anotherMoveCheck(Board checkersBoard, Piece piece){
		int curCol = piece.getColumn();
		int curRow = piece.getRow();
		boolean canJumpLeft = false;
		boolean canJumpRight = false;

		moveMultiplier = 1;
		int color = piece.getColor();
		if(color == ConstantsHolder.BLACK && !piece.isKing()){
			moveMultiplier = -1;
		}
		Move leftMove = new Move(curRow, curCol, (curRow + (moveMultiplier * 2)), (curCol - 2));
		Move rightMove = new Move(curRow, curCol, (curRow + (moveMultiplier * 2)), (curCol + 2));
		
		boolean leftInBound = isInBounds(leftMove);
		boolean rightInBound = isInBounds(rightMove);
		
		if(!(leftInBound || rightInBound)){
			return "No more moves";
		}
		if(leftInBound){
			canJumpLeft = finalValidateMove(checkersBoard, leftMove);
		}
		if(rightInBound){
			canJumpRight = finalValidateMove(checkersBoard, rightMove);
		}
		if(canJumpRight && canJumpLeft){
			return "Must make another move!(either left or right)";
		}
		if(canJumpRight){
			return "Must take right jump move!";
		}
		if(canJumpLeft){
			return "Must take left jump move!";
		}
		return "No more moves";
	}
	
}
