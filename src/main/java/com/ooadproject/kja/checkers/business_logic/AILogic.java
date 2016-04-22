package com.ooadproject.kja.checkers.business_logic;
import com.ooadproject.kja.checkers.models.*;
import java.util.*;
import java.util.Map.Entry;

import com.ooadproject.kja.checkers.utilities.*;

public class AILogic {
	MoveLogic moveUtil = new MoveLogic();
	
	public AILogic(){
		
	}
	
	public Move findMove(Board checkersBoard){
		//for each black piece on board, check for moves(one or two turns deep) and find score (store in hash?)
		//assuming black is AI (Player 2)
		HashMap<Move, Integer> moveAndScore = new HashMap<Move, Integer>();
		
		int boardSize = ConstantsHolder.BOARD_SIZE;
		int score;
		for (int row = 0; row < boardSize; row++) {
			for (int col = 0; col < boardSize; col++) {
				if(checkersBoard.piecesGrid[row][col].getColor() == ConstantsHolder.BLACK){
					//check for jump move (both ways)
					Piece piece = checkersBoard.piecesGrid[row][col];
					JumpMove jump = moveUtil.anotherMoveCheck(checkersBoard, piece);
					int jumpCheck = 0;
					if(jump.isBackLeft()){
						Move moveBL = new Move(row, col, (row + 2), (col - 2));
						score = findScore(checkersBoard, moveBL);
						moveAndScore.put(moveBL, score);
						jumpCheck = 1;
					}
					if(jump.isBackRight()){
						Move moveBR = new Move(row, col, (row + 2), (col + 2));
						score = findScore(checkersBoard, moveBR);
						moveAndScore.put(moveBR, score);
						jumpCheck = 1;
					}
					if(jump.isForwardLeft()){
						Move moveFL = new Move(row, col, (row - 2), (col - 2));
						score = findScore(checkersBoard, moveFL);
						moveAndScore.put(moveFL, score);
						jumpCheck = 1;
					}
					if(jump.isForwardRight()){
						Move moveFR = new Move(row, col, (row - 2), (col + 2));
						score = findScore(checkersBoard, moveFR);
						moveAndScore.put(moveFR, score);
						jumpCheck = 1;
					}
					//if no jump move, check regular moves (both directions)
					if(jumpCheck == 0){
						if(checkersBoard.piecesGrid[row][col].isKing()){
							Move rightRegMoveB = new Move(row, col, row + 1, col + 1);
							Move leftRegMoveB = new Move(row, col, row + 1, col - 1);
							if(moveUtil.preValidateMove(rightRegMoveB)){
								if(moveUtil.finalValidateMove(checkersBoard, rightRegMoveB)){
									score = findScore(checkersBoard, rightRegMoveB);
									moveAndScore.put(rightRegMoveB, score);
								}
							}
							if(moveUtil.preValidateMove(leftRegMoveB)){
								if(moveUtil.finalValidateMove(checkersBoard, leftRegMoveB)){
									score = findScore(checkersBoard, leftRegMoveB);
									moveAndScore.put(leftRegMoveB, score);
								}
							}	
						}
						Move rightRegMoveF = new Move(row, col, row - 1, col + 1);
						Move leftRegMoveF = new Move(row, col, row - 1, col - 1);
						if(moveUtil.preValidateMove(rightRegMoveF)){
							if(moveUtil.finalValidateMove(checkersBoard, rightRegMoveF)){
								score = findScore(checkersBoard, rightRegMoveF);
								moveAndScore.put(rightRegMoveF, score);
							}
						}
						if(moveUtil.preValidateMove(leftRegMoveF)){
							if(moveUtil.finalValidateMove(checkersBoard, leftRegMoveF)){
								score = findScore(checkersBoard, leftRegMoveF);
								moveAndScore.put(leftRegMoveF, score);
							}
						}	
					}
				}
			}
		}
		Set set = moveAndScore.entrySet();
		Iterator moves = set.iterator();
		Random rand = new Random();
		List<Move> keys = new ArrayList<Move>(moveAndScore.keySet());
		Move maxMove = keys.get(rand.nextInt(keys.size()));
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
		//return highest move and make move in driver
		return maxMove;
	}
	
	public int findScore(Board checkersBoard, Move move){
		boolean isJumped;
		
		if(move.hasJumpPotential){
			JumpMove jump = moveUtil.anotherMoveCheck(checkersBoard, checkersBoard.piecesGrid[move.toRow][move.toCol]);
			if(!jump.isBackLeft() && !jump.isBackRight() && !jump.isForwardLeft() && !jump.isForwardRight()){
				isJumped = moveUtil.canBeJumped(checkersBoard, move.toRow, move.toCol);
				if(!isJumped){
					return 2;
				}
				return 1;
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
					return 3;
				}
				return 2;
			}
		}
		
		//check for jump move after a regular move
		JumpMove jumpPostReg = moveUtil.anotherMoveCheck(checkersBoard, checkersBoard.piecesGrid[move.toRow][move.toCol]);
		if(jumpPostReg.isBackLeft() || jumpPostReg.isBackRight() || jumpPostReg.isForwardLeft() || jumpPostReg.isForwardRight()){
			return 1;
		}
		return 0;
	}

}
