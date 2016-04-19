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
					int jumpMove = moveUtil.anotherMoveCheck(checkersBoard, piece);
					if(jumpMove == 1){
						Move leftJump = new Move(row, col, (row - 2), (col - 2));
						score = findScore(checkersBoard, leftJump);
						moveAndScore.put(leftJump, score);
					}
					else if(jumpMove == 2){
						Move rightJump = new Move(row, col, (row -2), (col + 2));
						score = findScore(checkersBoard, rightJump);
						moveAndScore.put(rightJump, score);
					}
					else if(jumpMove == 3){
						Move leftJump = new Move(row, col, (row - 2), (col - 2));
						Move rightJump = new Move(row, col, (row -2), (col + 2));
						score = findScore(checkersBoard, leftJump);
						moveAndScore.put(leftJump, score);
						score = findScore(checkersBoard, rightJump);
						moveAndScore.put(rightJump, score);
					}
					//if no jump move, check regular moves (both directions)
					else{
						Move rightRegMove = new Move(row, col, row - 1, col + 1);
						Move leftRegMove = new Move(row, col, row - 1, col - 1);
						if(moveUtil.preValidateMove(rightRegMove)){
							if(moveUtil.finalValidateMove(checkersBoard, rightRegMove)){
								score = findScore(checkersBoard, rightRegMove);
								moveAndScore.put(rightRegMove, score);
							}
						}
						if(moveUtil.preValidateMove(leftRegMove)){
							if(moveUtil.finalValidateMove(checkersBoard, leftRegMove)){
								score = findScore(checkersBoard, leftRegMove);
								moveAndScore.put(leftRegMove, score);
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
			int canJumpAgain = moveUtil.anotherMoveCheck(checkersBoard, checkersBoard.piecesGrid[move.toRow][move.toCol]);
			if(canJumpAgain != 0){
				//pass in second jump coordinates
				if(canJumpAgain == 1){
					isJumped = moveUtil.canBeJumped(checkersBoard, (move.toRow - 2), (move.toCol - 2));
				}
				else if(canJumpAgain == 2){
					isJumped = moveUtil.canBeJumped(checkersBoard, (move.toRow - 2), (move.toCol + 2));
				}
				else{
					isJumped = moveUtil.canBeJumped(checkersBoard, (move.toRow - 2), (move.toCol - 2)) && moveUtil.canBeJumped(checkersBoard, (move.toRow - 2), (move.toCol + 2));
				}
				if(!isJumped){
					return 3;
				}
				return 2;
			}
			//pass in first jump coordinates
			isJumped = moveUtil.canBeJumped(checkersBoard, move.toRow, move.toCol);
			if(!isJumped){
				return 2;
			}
			return 1;
		}
		//check for jump move after a regular move
		if(moveUtil.anotherMoveCheck(checkersBoard, checkersBoard.piecesGrid[move.toRow][move.toCol]) != 0){
			return 1;
		}
		return 0;
	}

}
