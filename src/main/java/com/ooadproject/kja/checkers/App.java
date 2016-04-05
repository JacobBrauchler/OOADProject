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

        BoardPrinter boardHelperUtil = BoardPrinter.getBoardPrinter();

  
        BoardLogic boardUtil = new BoardLogic();
        Board checkersBoard = new Board();
        boardUtil.populateGrid(checkersBoard);

        boardHelperUtil.printBoardWithStatus(checkersBoard);
        /*
        Move move = new Move(7,2,6,3);

        boardUtil.printGrid(checkersBoard);
        boardUtil.movePiece(checkersBoard, move);
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
