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


        boardDisplayer.printBoardWithStatus(checkersBoard);
        Move move = new Move(2,7,3,6);

        boardUtil.movePiece(checkersBoard, move);
        System.out.println("Making the Move: From "+ move.fromRow + "," + move.fromCol+ " To " + move.toRow + "," + move.toCol);
        boardDisplayer.printBoardWithStatus(checkersBoard);
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
