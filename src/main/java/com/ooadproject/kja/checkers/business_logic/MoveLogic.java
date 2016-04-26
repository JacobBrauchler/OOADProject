package com.ooadproject.kja.checkers.business_logic;

import com.ooadproject.kja.checkers.utilities.*;
import com.ooadproject.kja.checkers.models.*;
//import com.ooadproject.kja.checkers.business_logic.*;

public class MoveLogic {
	private int moveMultiplier = 1;
	
	public MoveLogic(){
		
	}
	//does a quick prevalidation of a move
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
	//checks to make sure move is in bounds
	public boolean isInBounds(Move move){
		if(move.toRow < ConstantsHolder.BOARD_SIZE && move.toCol < ConstantsHolder.BOARD_SIZE){
			if(move.toRow >= 0 && move.toCol >= 0){
				return true;
			}		
		}
		return false;
	}
	//makes sure piece is moving diagonally
	public boolean isDiagonal(Move move){
		if(move.toCol == move.fromCol || move.toRow == move.fromRow){
			return false;
		}
		return Math.abs(move.toCol - move.fromCol) == Math.abs(move.toRow - move.fromRow);
	}
	//checks to see if a move is possible distance 
	public boolean isInRange(Move move){
		int colDiff = Math.abs(move.toCol - move.fromCol);
		int rowDiff = Math.abs(move.toRow - move.fromRow);
		
		if(colDiff > 2 || rowDiff > 2){
			return false;
		}
		
		return true;
	}
	
	//finalizes the validation of a move
	public boolean finalValidateMove(Board checkersBoard, Move move){
		boolean isValidDirection = checkDirection(checkersBoard, move);
		boolean isOpenSpot = checkSpot(checkersBoard, move);
		boolean canJump = true;
		if(move.hasJumpPotential){
			canJump = checkJumpee(checkersBoard, move);
		}
		
	    //System.out.println("isValidDirection = " + isValidDirection);
	    //System.out.println("isOpenSpot = " + isOpenSpot);
	    //System.out.println("canJump = " + canJump);
		
	    return (isValidDirection && isOpenSpot && canJump);
		
	}
	
	//checks to make sure a piece is moving in a valid direction
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
	
	//checks for an open spot
	public boolean checkSpot(Board checkersBoard, Move move){
		Piece selectedSpot = checkersBoard.piecesGrid[move.toRow][move.toCol];
		if(selectedSpot.getColor() != ConstantsHolder.EMPTY){
			return false;
		}
		return true;
	}
	
	//checks to make sure a piece is allowed to be jumped
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
	//gets middle piece coordinates (used for jump move checks)
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
	
	//checks to see if a piece can be jumped
	public boolean canBeJumped(Board checkersBoard, Move move){
		if(move.toCol < 7 && move.toCol > 0 && move.toRow > 0 && move.toRow < 7){
			//check right side
			int rightColor = checkersBoard.piecesGrid[move.toRow - 1][move.toCol + 1].getColor();
			if(rightColor == ConstantsHolder.RED){
				
				//check back left spot
				if(move.toCol - 1 == move.fromCol && move.toRow + 1 == move.fromRow){
					return true;
				}
				if(checkersBoard.piecesGrid[move.toRow+1][move.toCol-1].getColor() == ConstantsHolder.EMPTY){
					return true;
				}
			}
			//check left side
			int leftColor = checkersBoard.piecesGrid[move.toRow-1][move.toCol-1].getColor();
			if(leftColor == ConstantsHolder.RED){
				//check back right spot
				if(move.toCol + 1 == move.fromCol && move.toRow + 1 == move.fromRow){
					return true;
				}
				if(checkersBoard.piecesGrid[move.toRow+1][move.toCol+1].getColor() == ConstantsHolder.EMPTY){
					return true;
				}
			}
		}		
		return false;
	}
	
	//checks for whether or not a piece has another move it must take
	public JumpMove anotherMoveCheck(Board checkersBoard, Piece piece){
		JumpMove jumpBack = new JumpMove();
		JumpMove jumpForward = new JumpMove();
		JumpMove finalJump = new JumpMove();
		moveMultiplier = 1;
		int color = piece.getColor();
		if(color == ConstantsHolder.BLACK && !piece.isKing()){
			moveMultiplier = -1;
		}
		if(piece.isKing()){
			moveMultiplier *= -1;
			jumpBack = jumpMoveCheck(checkersBoard, piece, moveMultiplier);
		}
		jumpForward = jumpMoveCheck(checkersBoard, piece, moveMultiplier);
		
		finalJump.setBackLeft(jumpBack.isBackLeft());
		finalJump.setBackRight(jumpBack.isBackRight());
		finalJump.setForwardLeft(jumpForward.isForwardLeft());
		finalJump.setForwardRight(jumpForward.isForwardRight());
		
		return finalJump;
	}
	
	//checks to see if the passed in piece has available jump moves and assigns that information to JumpMove Object
	public JumpMove jumpMoveCheck(Board checkersBoard, Piece piece, int moveMultiplier){
		int curCol = piece.getColumn();
		int curRow = piece.getRow();
		boolean canJumpLeft = false;
		boolean canJumpRight = false;
		JumpMove jump = new JumpMove();
		
		Move leftMove = new Move(curRow, curCol, (curRow + (moveMultiplier * 2)), (curCol - 2));
		Move rightMove = new Move(curRow, curCol, (curRow + (moveMultiplier * 2)), (curCol + 2));
		
		boolean leftInBound = isInBounds(leftMove);
		boolean rightInBound = isInBounds(rightMove);
		
		if(!leftInBound && !rightInBound){
			return jump;
		}
		if(leftInBound){
			canJumpLeft = finalValidateMove(checkersBoard, leftMove);
		}
		if(rightInBound){
			canJumpRight = finalValidateMove(checkersBoard, rightMove);
		}
		if(canJumpRight && canJumpLeft){
			if(piece.isKing()){
				jump.setBackLeft(true);
				jump.setBackRight(true);
			}
			else{
				jump.setForwardLeft(true);
				jump.setForwardRight(true);
			}
			return jump;
		}
		if(canJumpRight){
			if(piece.isKing()){
				jump.setBackRight(true);
			}
			else{
				jump.setForwardRight(true);
			}
			return jump;
		}
		if(canJumpLeft){
			if(piece.isKing()){
				jump.setBackLeft(true);
			}
			else{
				jump.setForwardLeft(true);
			}
			return jump;
		}
		return jump;
	}
	
}
