package com.ooadproject.kja.checkers;

//import com.ooadproject.kja.checkers.views.*;

import com.ooadproject.kja.checkers.models.*;
import com.ooadproject.kja.checkers.business_logic.*;
import com.ooadproject.kja.checkers.utilities.*;

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

        Board checkersBoard = new Board();
        boardUtil.populateGrid(checkersBoard);


        boardDisplayer.printBoardWithStatusAndCoords(checkersBoard);

        // First Move
        Move firstMove = new Move(2,7,3,6);
        boardUtil.makeMove(checkersBoard, firstMove);
       
        System.out.println("Making the Move: From "+ firstMove.fromRow + "," + firstMove.fromCol+ " To " + firstMove.toRow + "," + firstMove.toCol);
        boardDisplayer.printBoardWithStatusAndCoords(checkersBoard);
        boardUtil.checkForNextJump(checkersBoard, checkersBoard.piecesGrid[3][6]);
        System.out.println("------------------------------------------------------------------------\n");
        //
        // Second Move
        Move secondMove = new Move(3,6,4,5);
        boardUtil.makeMove(checkersBoard, secondMove);
        
        System.out.println("Making the Move: From "+ secondMove.fromRow + "," + secondMove.fromCol+ " To " + secondMove.toRow + "," + secondMove.toCol);
        boardDisplayer.printBoardWithStatusAndCoords(checkersBoard);
        boardUtil.checkForNextJump(checkersBoard, checkersBoard.piecesGrid[4][5]);
        System.out.println("------------------------------------------------------------------------\n");
       
        // Third Move
        Move thirdMove = new Move(5,4,3,6);
        boardUtil.makeMove(checkersBoard, thirdMove);
       
        System.out.println("Making the Move: From "+ thirdMove.fromRow + "," + thirdMove.fromCol+ " To " + thirdMove.toRow + "," + thirdMove.toCol);
        boardDisplayer.printBoardWithStatusAndCoords(checkersBoard);
        boardUtil.checkForNextJump(checkersBoard, checkersBoard.piecesGrid[3][6]);
        System.out.println("------------------------------------------------------------------------\n");
        
        //Fourth Move
        Move fourthMove = new Move(6,5,5,4);
        boardUtil.makeMove(checkersBoard, fourthMove);
        
        System.out.println("Making the Move: From "+ fourthMove.fromRow + "," + fourthMove.fromCol+ " To " + fourthMove.toRow + "," + fourthMove.toCol);
        boardDisplayer.printBoardWithStatusAndCoords(checkersBoard);
        boardUtil.checkForNextJump(checkersBoard, checkersBoard.piecesGrid[5][4]);
        System.out.println("------------------------------------------------------------------------\n");
        
        //Fifth Move
        Move fifthMove = new Move(2,5,4,7);
        boardUtil.makeMove(checkersBoard, fifthMove);
         
        System.out.println("Making the Move: From "+ fifthMove.fromRow + "," + fifthMove.fromCol+ " To " + fifthMove.toRow + "," + fifthMove.toCol);
        boardDisplayer.printBoardWithStatusAndCoords(checkersBoard); 
        boardUtil.checkForNextJump(checkersBoard, checkersBoard.piecesGrid[4][7]);
        
        Move sixthMove = new Move(1,6,2,7);
        boardUtil.makeMove(checkersBoard, sixthMove);
        
        Move seventhMove = new Move(0,5,1,6);
        boardUtil.makeMove(checkersBoard, seventhMove);
        
        Move eigththMove = new Move(2,3,3,4);
        boardUtil.makeMove(checkersBoard, eigththMove);
        
        Move ninethMove = new Move(5,4,4,5);
        boardUtil.makeMove(checkersBoard, ninethMove);
        
        Move tenthMove = new Move(2,1,3,0);
        boardUtil.makeMove(checkersBoard, tenthMove);
        
        Move eleventhMove = new Move(1,0,2,1);
        boardUtil.makeMove(checkersBoard, eleventhMove);
        
        Move twelfthMove = new Move(0,1,1,0);
        boardUtil.makeMove(checkersBoard, twelfthMove);
        
        Move lastMove = new Move(4,5,2,3);
        boardUtil.makeMove(checkersBoard, lastMove);
        boardDisplayer.printBoardWithStatusAndCoords(checkersBoard); 
        boardUtil.checkForNextJump(checkersBoard, checkersBoard.piecesGrid[2][3]);
        /*
        System.out.println("=================================================================");
        boardUtil.printGrid(checkersBoard);
        */

/*
        mouse listener util controller returns users click coordinates
        create Move object containing those coordinates
        pass in that move object as well as board into boardUtil.validateMove

        if move is valid, pass in move object as well as board into boardUtil.makeMove

*/
    }
}
