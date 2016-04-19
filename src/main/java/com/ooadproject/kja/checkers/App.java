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
        
        System.out.println( "Hello World!" );

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
            	else{
            		move = aiUtil.findMove(checkersBoard);
            		fromRow = move.fromRow;
                	fromCol = move.fromCol;
                	toRow = move.toRow;
                	toCol = move.toCol;
            	}
            	
            	isValid = boardUtil.makeMove(checkersBoard, move);
            	if(isValid){
            		System.out.println("Made the Move: From "+ move.fromRow + "," + move.fromCol+ " To " + move.toRow + "," + move.toCol);
            	}

            	int iter = 0;
            	while(moreMoves != 0 && isValid){
            		if(iter > 0){
            			moreMoves = boardUtil.checkForNextJump(checkersBoard, checkersBoard.piecesGrid[move.toRow][move.toCol], move);
            		}
            		else{
            			moreMoves = boardUtil.checkForNextJump(checkersBoard, checkersBoard.piecesGrid[toRow][toCol], move);
            		}
            		
            		if(moreMoves == 1 || moreMoves == 2){
            			System.out.println("Automatically making move");
            			boardUtil.makeMove(checkersBoard, move);
            			System.out.println("Made the Move: From "+ move.fromRow + "," + move.fromCol+ " To " + move.toRow + "," + move.toCol);
            		}
            		else if(moreMoves == 3){
            			int moveMultiplier = 1;
            			int curCol = move.toCol;
            			int curRow = move.toRow;
            			int color = checkersBoard.piecesGrid[toRow][toCol].getColor();
            			if(color == ConstantsHolder.BLACK && !checkersBoard.piecesGrid[toRow][toCol].isKing()){
            				moveMultiplier = -1;
            			}
            			
            			System.out.println("Choose direction: ('1' for left '2' for right)");
            			int direction = userInput.nextInt();
            			
            			if(direction == 1){
            				move.fromCol = move.toCol;
            				move.fromRow = move.toRow;
            				move.toCol = (curCol - 2);
            				move.toRow = (curRow + (moveMultiplier * 2));
            			}
            			else if(direction == 2){
            				move.fromCol = move.toCol;
            				move.fromRow = move.toRow;
            				move.toCol = (curCol + 2);
            				move.toRow = (curRow + (moveMultiplier * 2));
            			}
            			else{
            				System.out.println("Sorry, you didn't input correct string making right move");
            				move.fromCol = move.toCol;
            				move.fromRow = move.toRow;
            				move.toCol = (curCol + 2);
            				move.toRow = (curRow + (moveMultiplier * 2));
            			}
            			boardUtil.makeMove(checkersBoard, move);
            			
            			
            			System.out.println("Made the Move: From "+ move.fromRow + "," + move.fromCol+ " To " + move.toRow + "," + move.toCol);
            		}
            		iter++;
            	}
            	if(isValid){
            		checkersBoard.playerOneTurn = !checkersBoard.playerOneTurn;
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
        }
        
/*
        mouse listener util controller returns users click coordinates
        create Move object containing those coordinates
        pass in that move object as well as board into boardUtil.validateMove

        if move is valid, pass in move object as well as board into boardUtil.makeMove

*/
    }
}
