package com.ooadproject.kja.checkers;
import java.util.*;

//import com.ooadproject.kja.checkers.views.*;

import com.ooadproject.kja.checkers.models.*;
import com.ooadproject.kja.checkers.business_logic.*;
import com.ooadproject.kja.checkers.utilities.*;
import com.ooadproject.kja.checkers.views.*;

public class App 
{
  public static void main( String[] args )
  {
    /* Helper class for printing ascii representation of board. Will likely not use this anymore  */
    BoardPrinter boardDisplayer = BoardPrinter.getBoardPrinter();

    /* Util Class used to manipulate and update the contents of the board */
    BoardLogic boardUtil = BoardLogic.getBoardLogic();

    /* Util Class used for AI */
    AILogic aiUtil = new AILogic();

    /* Calls the Board class constructor that instantiates our 8x8 logical piecesGrid */
    Board checkersBoard = new Board();

    /* Populates our logical grid by contstructing instances of our Piece class at each square */
    boardUtil.populateGrid(checkersBoard);

    /* Sets up the GUI with all the buttons, grid drawn, and the pieces drawn */
    GameView gameView = new GameView(checkersBoard);
    Scanner userInput = new Scanner(System.in);
    String userMoveString;

    int moreMoves = 1;
    while(true){
    
      //check to see who's turn it is
      if(checkersBoard.playerOneTurn){
        System.out.println("Player One's Turn!");
      }
      else{
        System.out.println("Player Two's Turn!");
      }
      boolean isValid = true;
      Move move;
      if (((checkersBoard.getPieceCount(ConstantsHolder.BLACK) == 0)) || ((checkersBoard.getPieceCount(ConstantsHolder.RED) == 0))){
    	  GameOverView GameOver = new GameOverView(checkersBoard);
    	  
      }
      //get user input if it's user's turn
      while(checkersBoard.playerOneTurn){
    	int aiDifficulty = Player.getDifficulty();
        System.out.println("beginning of player 1 turn: Press Enter to continue");
        //userMoveString = userInput.nextLine();
        //userMoveString = userInput.nextLine();
        while(checkersBoard.potentialMove == null)
        {
          System.out.print("aaa");
        }
        System.out.println("Updated state of potentialMove");
        System.out.println(checkersBoard.potentialMove.printMove());
        move = checkersBoard.potentialMove;
        //make sure user makes jump if available
        // if the current move is not a jump
        if(!move.hasJumpPotential){
          boolean otherJumpMovesAvailable = true;
          while (otherJumpMovesAvailable == true)
          {
            otherJumpMovesAvailable = boardUtil.userJumpCheck(checkersBoard, ConstantsHolder.RED, move);
            if (otherJumpMovesAvailable == true)
            {
              checkersBoard.potentialMove = null;
              while(checkersBoard.potentialMove == null)
              {
                System.out.print("bbb");
              }
              move = checkersBoard.potentialMove;
            }
          }
        }
        
        
        isValid = boardUtil.makeMove(checkersBoard, move);
        if (isValid == true)
        {
          System.out.println("inside of isValid");
          //userMoveString = userInput.nextLine();
          //check for more jump moves
          if (move.hasJumpPotential) {
            System.out.println("We have a jump move that just got made");
            //userMoveString = userInput.nextLine();
            moreMoves = 1;
            while(moreMoves != 0){
              JumpMove jump = new JumpMove();
              jump = boardUtil.checkForNextJump(checkersBoard, checkersBoard.piecesGrid[move.toRow][move.toCol], move);
              moreMoves = areMoreMoves(jump);
              gameView.reDrawBoard(checkersBoard);
              if(moreMoves > 0){
                System.out.println("User has more jump moves that they can make with this piece");
                //userMoveString = userInput.nextLine();
                System.out.println("User will now have to click on their next move");
                System.out.println(checkersBoard.potentialMove.printMove());
                //userMoveString = userInput.nextLine();
                boolean correctJumpMove = false;
                while (correctJumpMove == false)
                {
                  checkersBoard.potentialMove = null;
                  while(checkersBoard.potentialMove == null)
                  {
                    System.out.print("ccc");
                  }
                  correctJumpMove = boardUtil.userJump(jump, checkersBoard.potentialMove);
                }
                boardUtil.makeMove(checkersBoard, checkersBoard.potentialMove);
                gameView.reDrawBoard(checkersBoard);
                move = checkersBoard.potentialMove;
                checkersBoard.potentialMove = null;
              }
              else{
                System.out.println("User doesn't have any more proceeding moves");
                if (((checkersBoard.getPieceCount(ConstantsHolder.BLACK) == 0)) || ((checkersBoard.getPieceCount(ConstantsHolder.RED) == 0))){
              	  GameOverView GameOver = new GameOverView(checkersBoard);
              	  
                }
                //end game 
                ////userMoveString = userInput.nextLine();
                if(move.toRow == 7 ){
                  checkersBoard.piecesGrid[move.toRow][move.toCol].setKing(true);
                }
                checkersBoard.potentialMove = null;
              }
            }
            checkersBoard.potentialMove = null;
            checkersBoard.playerOneTurn = !checkersBoard.playerOneTurn;
          }
          else{
            System.out.println("User made a regular move");
            //userMoveString = userInput.nextLine();
            checkersBoard.potentialMove = null;
            gameView.reDrawBoard(checkersBoard);
            checkersBoard.playerOneTurn = !checkersBoard.playerOneTurn;
          }
        }
        if (move.toRow == 7) {
          checkersBoard.piecesGrid[move.toRow][move.toCol].setKing(true);
        }
      }
      // AI
      int fromRow = 0;
      int fromCol = 0;
      int toRow = 0;
      int toCol = 0;
      wait(1);
      int aiDifficulty = Player.getDifficulty();
      System.out.println(aiDifficulty);
      //ai stuff
      move = aiUtil.findMove(checkersBoard, ConstantsHolder.BLACK, aiDifficulty);
      fromRow = move.fromRow;
      fromCol = move.fromCol;
      toRow = move.toRow;
      toCol = move.toCol;
      //make move if valid
      isValid = boardUtil.makeMove(checkersBoard, move);
      int iter = 0;
      if (move.hasJumpPotential) {
        moreMoves = 1;
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
            boardUtil.aiJump(jump, move);
          }
          boardUtil.makeMove(checkersBoard, move);
          iter++;
        }
      }
      System.out.println("Finished the AI move about to flip turn and draw");
      checkersBoard.playerOneTurn = !checkersBoard.playerOneTurn;
      if (move.toRow == 0) {
        checkersBoard.piecesGrid[move.toRow][move.toCol].setKing(true);
      }
      gameView.reDrawBoard(checkersBoard);
    }
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
  private static void wait(int seconds)
  {
    try
    {
      Thread.sleep(1000 * seconds); // argument must represent
      // milliseconds, thus we multiply *
      // 1000
    } catch (InterruptedException ex)
    {
      Thread.currentThread().interrupt();
    }
  } 
}
