package com.ooadproject.kja.checkers;
import java.util.*;

//import com.ooadproject.kja.checkers.views.*;

import com.ooadproject.kja.checkers.models.*;
import com.ooadproject.kja.checkers.business_logic.*;
import com.ooadproject.kja.checkers.utilities.*;
import com.ooadproject.kja.checkers.views.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BoardPrinter boardDisplayer = BoardPrinter.getBoardPrinter();
        BoardLogic boardUtil = BoardLogic.getBoardLogic();
        AILogic aiUtil = new AILogic();
        
        Board checkersBoard = new Board();
        boardUtil.populateGrid(checkersBoard);

        BoardViewDrawer.drawBoard(checkersBoard);
        //BoardViewDrawer.drawPieces(checkersBoard);
        boardDisplayer.printBoardWithStatusAndCoords(checkersBoard);
        
        Scanner userInput = new Scanner(System.in);
        int running = 1;
        int moreMoves = 1;
        while(running == 1){
        	//check to see who's turn it is
        	if(checkersBoard.playerOneTurn){
        		System.out.println("Player One's Turn!");
        	}
        	else{
        		System.out.println("Player Two's Turn!");
        	}
        	System.out.println("Select What you want to do:");
            System.out.println("1) Make Move \n2) Print Current Board \n3) Quit\n");
            int selection = userInput.nextInt();
          
            if(selection == 1){
            	boolean isValid = true;
            	moreMoves = 1;
            	Move move;
            	int fromRow;
            	int fromCol;
            	int toRow;
            	int toCol;
            	//get user input if it's user's turn
            	if(checkersBoard.playerOneTurn){
            		System.out.println("Enter From Row: ");
                	fromRow = userInput.nextInt();
                	System.out.println("Enter From Col: ");
                	fromCol = userInput.nextInt();
                	System.out.println("Enter To Row: ");
                	toRow = userInput.nextInt();
                	System.out.println("Enter To Col: ");
                	toCol = userInput.nextInt();
                	move = new Move(fromRow, fromCol, toRow, toCol);
            	}
            	//get best move from ai
            	else{
            		move = aiUtil.findMove(checkersBoard);
            		fromRow = move.fromRow;
                	fromCol = move.fromCol;
                	toRow = move.toRow;
                	toCol = move.toCol;
            	}
            	//make move if valid
            	isValid = boardUtil.makeMove(checkersBoard, move);
            	if(isValid){
            		System.out.println("Made the Move: From "+ move.fromRow + "," + move.fromCol+ " To " + move.toRow + "," + move.toCol);
            	}
            	int iter = 0;
            	//check for more jump moves
            	while(moreMoves != 0 && isValid){
            		JumpMove jump = new JumpMove();
            		if(iter > 0){
            			jump = boardUtil.checkForNextJump(checkersBoard, checkersBoard.piecesGrid[move.toRow][move.toCol], move);
            		}
            		else{
            			jump = boardUtil.checkForNextJump(checkersBoard, checkersBoard.piecesGrid[toRow][toCol], move);
            		}
            		moreMoves = areMoreMoves(jump);
            		if(moreMoves > 0){
            			if(checkersBoard.playerOneTurn){
            				boardUtil.userJump(jump, move);
            			}
            			else{
            				boardUtil.aiJump(jump, move);
            			}
            			boardUtil.makeMove(checkersBoard, move);
            		}
            	iter++;
            	}
            	//if move was valid, change turns and check to see if move was a king move
            	if(isValid){
            		checkersBoard.playerOneTurn = !checkersBoard.playerOneTurn;
            		//check for king
            		if(move.toRow == 0 || move.toRow == 7){
            			checkersBoard.piecesGrid[move.toRow][move.toCol].setKing(true);
            		}
            	}
                System.out.println("------------------------------------------------------------------------\n");
            	
            }
            else if(selection == 2){
            	boardDisplayer.printBoardWithStatusAndCoords(checkersBoard);
            	BoardViewDrawer.drawBoard(checkersBoard);
            }
            else{
            	System.out.println("Session Ended.");
            	running = 0;
            }
            moreMoves = 1;
        }
        userInput.close();
        
    }
    
    public static int areMoreMoves(JumpMove jump){
    	if(jump.isBackLeft()){
    		return 1;
    	}
    	if(jump.isBackRight()){
    		return 1;
    	}
    	if(jump.isForwardLeft()){
    		return 1;
    	}
    	if(jump.isForwardRight()){
    		return 1;
    	}
    	
    	return 0;
    }
}
