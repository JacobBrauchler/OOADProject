package com.ooadproject.kja.checkers.business_logic;
import com.ooadproject.kja.checkers.models.*;
import java.util.*;
import java.util.Map.Entry;

import com.ooadproject.kja.checkers.utilities.*;

public class AILogic {
	MoveLogic moveUtil = new MoveLogic();
	
	public AILogic(){
		
	}
	
	public Move findMove(Board checkersBoard, int color, int difficulty){
		//for each black piece on board, check for moves(one or two turns deep) and find score (store in hash)
		//assuming black is AI (Player 2)
		HashMap<Move, Integer> moveAndScore = new HashMap<Move, Integer>();
		List<Move> jumpMoves = new ArrayList<Move>();
		List<Move> regularMoves = new ArrayList<Move>();
		int boardSize = ConstantsHolder.BOARD_SIZE;
		int score;
		int moveMultiplier = 1;
		if(color == ConstantsHolder.RED){
			moveMultiplier = -1;
		}
		for (int row = 0; row < boardSize; row++) {
			for (int col = 0; col < boardSize; col++) {
				if(checkersBoard.piecesGrid[row][col].getColor() == color){
					//check for jump move and grab scores (both ways)
					Piece piece = checkersBoard.piecesGrid[row][col];
					JumpMove jump = moveUtil.anotherMoveCheck(checkersBoard, piece);
					int jumpCheck = 0;
					if(jump.isBackLeft()){
						Move moveBL = new Move(row, col, (row + (moveMultiplier * 2)), (col - 2));
						score = findScore(checkersBoard, moveBL);
						moveAndScore.put(moveBL, score);
						jumpMoves.add(moveBL);
						jumpCheck = 1;
					}
					if(jump.isBackRight()){
						Move moveBR = new Move(row, col, (row + (moveMultiplier * 2)), (col + 2));
						score = findScore(checkersBoard, moveBR);
						moveAndScore.put(moveBR, score);
						jumpMoves.add(moveBR);
						jumpCheck = 1;
					}
					if(jump.isForwardLeft()){
						Move moveFL = new Move(row, col, (row - (moveMultiplier * 2)), (col - 2));
						score = findScore(checkersBoard, moveFL);
						moveAndScore.put(moveFL, score);
						jumpMoves.add(moveFL);
						jumpCheck = 1;
					}
					if(jump.isForwardRight()){
						Move moveFR = new Move(row, col, (row - (moveMultiplier * 2)), (col + 2));
						score = findScore(checkersBoard, moveFR);
						moveAndScore.put(moveFR, score);
						jumpMoves.add(moveFR);
						jumpCheck = 1;
					}
					
					//if no jump move, check regular moves (both directions) and get score
					if(jumpCheck == 0 && color == ConstantsHolder.BLACK){
						if(checkersBoard.piecesGrid[row][col].isKing()){
							Move rightRegMoveB = new Move(row, col, row + 1, col + 1);
							Move leftRegMoveB = new Move(row, col, row + 1, col - 1);
							if(moveUtil.preValidateMove(rightRegMoveB)){
								if(moveUtil.finalValidateMove(checkersBoard, rightRegMoveB)){
									score = findScore(checkersBoard, rightRegMoveB);
									moveAndScore.put(rightRegMoveB, score);
									regularMoves.add(rightRegMoveB);
								}
							}
							if(moveUtil.preValidateMove(leftRegMoveB)){
								if(moveUtil.finalValidateMove(checkersBoard, leftRegMoveB)){
									score = findScore(checkersBoard, leftRegMoveB);
									moveAndScore.put(leftRegMoveB, score);
									regularMoves.add(leftRegMoveB);
								}
							}	
						}
						Move rightRegMoveF = new Move(row, col, row - 1, col + 1);
						Move leftRegMoveF = new Move(row, col, row - 1, col - 1);
						if(moveUtil.preValidateMove(rightRegMoveF)){
							if(moveUtil.finalValidateMove(checkersBoard, rightRegMoveF)){
								score = findScore(checkersBoard, rightRegMoveF);
								moveAndScore.put(rightRegMoveF, score);
								regularMoves.add(rightRegMoveF);
							}
						}
						if(moveUtil.preValidateMove(leftRegMoveF)){
							if(moveUtil.finalValidateMove(checkersBoard, leftRegMoveF)){
								score = findScore(checkersBoard, leftRegMoveF);
								moveAndScore.put(leftRegMoveF, score);
								regularMoves.add(leftRegMoveF);
							}
						}	
					}
				}
			}
		}
		Move maxMove;
		Random rand = new Random();
		//choose move that has the best score out of the hash map
		if(difficulty == 2){
			Set set = moveAndScore.entrySet();
			Iterator moves = set.iterator();
			List<Move> keys = new ArrayList<Move>(moveAndScore.keySet());
			maxMove = keys.get(rand.nextInt(keys.size()));
			int maxMoveScore = 0;
			while(moves.hasNext()){
				Map.Entry<Move,Integer> entry = (Map.Entry<Move, Integer>) moves.next();
				Move temp = entry.getKey();
				int tempMoveScore = entry.getValue();
				if(tempMoveScore > maxMoveScore){
					maxMove = temp;
					maxMoveScore = tempMoveScore;
				}
			}
		}
		else{
			if(!jumpMoves.isEmpty()){
				maxMove = jumpMoves.get(rand.nextInt(jumpMoves.size()));
			}
			else{
				maxMove = regularMoves.get(rand.nextInt(regularMoves.size()));
			}
		}		
		//return highest move and make move in driver
		return maxMove;
	}
	
	public int findScore(Board checkersBoard, Move move){
		boolean isJumped;
		//if move passed in is a jump move, check for more jump moves and return score based on results
		if(move.hasJumpPotential){
			JumpMove jump = moveUtil.anotherMoveCheck(checkersBoard, checkersBoard.piecesGrid[move.toRow][move.toCol]);
			if(!jump.isBackLeft() && !jump.isBackRight() && !jump.isForwardLeft() && !jump.isForwardRight()){
				isJumped = moveUtil.canBeJumped(checkersBoard, move.toRow, move.toCol);
				if(!isJumped){
					return 6;
				}
				return 5;
			}
			
			else{
				boolean isJumpedBR = true;
				boolean isJumpedBL = true;
				boolean isJumpedFR = true;
				boolean isJumpedFL = true;
				if(jump.isBackLeft()){
					isJumpedBL = moveUtil.canBeJumped(checkersBoard, (move.toRow + 2), (move.toCol - 2));
				}
				if(jump.isBackRight()){
					isJumpedBR = moveUtil.canBeJumped(checkersBoard, (move.toRow + 2), (move.toCol + 2));
				}
				if(jump.isForwardLeft()){
					isJumpedFL = moveUtil.canBeJumped(checkersBoard, (move.toRow - 2), (move.toCol - 2));
				}
				if(jump.isForwardRight()){
					isJumpedFR = moveUtil.canBeJumped(checkersBoard, (move.toRow - 2), (move.toCol + 2));
				}
				if(!isJumpedBR || !isJumpedFR || !isJumpedBL || !isJumpedFL){
					return 7;
				}
				return 6;
			}
		}
		
		//check for jump move after a regular move
		JumpMove jumpPostReg = moveUtil.anotherMoveCheck(checkersBoard, checkersBoard.piecesGrid[move.toRow][move.toCol]);
		if(jumpPostReg.isBackLeft() || jumpPostReg.isBackRight() || jumpPostReg.isForwardLeft() || jumpPostReg.isForwardRight()){
			return 4;
		}
		else{
			//check to see if current piece can be jumped as is
			if(moveUtil.canBeJumped(checkersBoard, move.fromRow, move.fromCol)){
				if(!moveUtil.canBeJumped(checkersBoard, move.toRow, move.toCol)){
					return 5; 
				}
			}
		}
		return 0;
	}
}
