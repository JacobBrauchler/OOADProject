package com.ooadproject.kja.checkers;

import com.ooadproject.kja.checkers.views.*;
import com.ooadproject.kja.checkers.models.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        someView sampleView = new someView(5, "Alex");
        someModel sampleModel = new someModel("JB and Kyle");
  
        BoardLogic boardUtil = new BoardLogic();
        Board checkersBoard = new Board();

        boardUtil.populateGrid(checkersBoard);



        mouse listener util controller returns users click coordinates
        create Move object containing those coordinates
        pass in that move object as well as board into boardUtil.validateMove

        if move is valid, pass in move object as well as board into boardUtil.makeMove


    }
}
