package com.ooadproject.kja.checkers.utilities;

import com.ooadproject.kja.checkers.models.*;
import com.ooadproject.kja.checkers.business_logic.*;
import com.ooadproject.kja.checkers.utilities.*;

/*
 * This class is a helper class for printing several different variations of our checkers board including generic empty boards, boards with coordinates, specific game boards containing pieces, etc. It will be super useful to see the state of the board and all of its pieces when debugging various parts of our app. With that being said, this single file is perhaps the worst example of good coding that I have ever created. It contains hardcoded values galore, it contains repeated code, it contains ridiculous nesting of loops and conditional statements, and worst of all it contains specific number of spaces in certain print statements that are only defined by the comments next to them. It is a nightmare that was constructed at 1 am. However, it prints pretty boards and its use is purely as a utility, not as a core essential part of the program. So, freeily call all the methods, enjoy the drawings, and don't look at this code too much because its terrible
 */

public class BoardPrinter {

  private static BoardPrinter boardPrinter;
  private BoardLogic boardUtil = BoardLogic.getBoardLogic();

  private BoardPrinter()
  {
  }

  public static BoardPrinter getBoardPrinter(){
    if (boardPrinter == null)
        boardPrinter = new BoardPrinter();
    return boardPrinter;
  }

  public void printBoardWithStatusAndCoords(Board board)
  {
    GenHelper genHelperUtil = GenHelper.getGenHelper();
    int size = boardUtil.getGridSize(board);
    if ( (size <= 0) || (size % 2 == 1)) {
      System.out.println("Please provide a positive even size greater than 0");
      return;
    }

    String dashLine = new String(new char[(size*12)+9]).replace("\0", "-");
    System.out.println(dashLine);
    for (int i = 0; i <= size*3; i++) {
      for (int j = 0; j <= size; j++){
        if (i ==  (size*3))
          break;
        if ( j == size) {
          System.out.print("|");
          break;
        }
        if ( (i % 3) == 0) {
          int pieceColor = board.piecesGrid[i/3][j].getColor();
          String pieceColorString = genHelperUtil.pieceColorConverter(pieceColor);
          if (pieceColor == ConstantsHolder.RED)
            // | + three spaces + pieceColorString + six spaces
            System.out.print("|   " + pieceColorString + "      ");
          else if (pieceColor == ConstantsHolder.EMPTY)
            // 12 spaces 
            System.out.print("|            ");
          else
            // | + three spaces + pieceColorString + four spaces
            System.out.print("|   " + pieceColorString + "    ");
        }
        else if ( (i % 3) == 2) {
          // | + three spaces + row + , + col + six spaces
          System.out.print("|   " + (i/3) + "," + j + "      ");
        }
        else
          // 12 spaces
          System.out.print("|            ");
      }
      System.out.println("");
      if (i % 3 == 2)
        System.out.println(dashLine);
    }
  }

  public void printBoardWithStatus(Board board)
  {
    GenHelper genHelperUtil = GenHelper.getGenHelper();
    int size = boardUtil.getGridSize(board);
    if ( (size <= 0) || (size % 2 == 1)) {
      System.out.println("Please provide a positive even size greater than 0");
      return;
    }

    String dashLine = new String(new char[(size*12)+9]).replace("\0", "-");
    System.out.println(dashLine);
    for (int i = 0; i <= size*3; i++) {
      for (int j = 0; j <= size; j++){
        if (i ==  (size*3))
          break;
        if ( j == size) {
          System.out.print("|");
          break;
        }
        if ( (i % 3) == 1) {
          int pieceColor = board.piecesGrid[i/3][j].getColor();
          String pieceColorString = genHelperUtil.pieceColorConverter(pieceColor);
          if (pieceColor == ConstantsHolder.RED)
            // | + three spaces + pieceColorString + six spaces
            System.out.print("|   " + pieceColorString + "      ");
          else if (pieceColor == ConstantsHolder.EMPTY)
            // 12 spaces 
            System.out.print("|            ");
          else
            // | + three spaces + pieceColorString + four spaces
            System.out.print("|   " + pieceColorString + "    ");
          }
        else
          // 12 spaces
          System.out.print("|            ");
      }
      System.out.println("");
      if (i % 3 == 2)
        System.out.println(dashLine);
    }
  }

  public void printEmptyBoardWithCoords(int size)
  {
    if ( (size <= 0) || (size % 2 == 1)) {
      System.out.println("Please provide a positive even size greater than 0");
      return;
    }

    String dashLine = new String(new char[(size*10)+1]).replace("\0", "-");
    System.out.println(dashLine);
    for (int i = 0; i <= size*3; i++) {
      for (int j = 0; j <= size; j++){
        if (i ==  (size*3))
          break;
        if ( j == size) {
          System.out.print("|");
          break;
        }
        if ( (i % 3) == 1) {
          // | + two spaces + row + , + col + four spaces
          System.out.print("|  " + (i/3) + "," + j + "    ");
          }
        else
          // nine spaces
          System.out.print("|         ");
      }
      System.out.println("");
      if (i % 3 == 2)
        System.out.println(dashLine);
    }
  }

  public void printEmptyBoard(int size)
  {
    if (size <= 0) {
      System.out.println("Please provide a positive size greater than 0");
      return;
    }

    String dashLine = new String(new char[(size*9)+1]).replace("\0", "-");
    System.out.println(dashLine);
    for (int i = 0; i <= size*3; i++) {
      for (int j = 0; j <= size; j++){
        if (i ==  (size*3))
          break;
        // 6 spaces
        System.out.print("|        ");
      }
      System.out.println("");
      if (i % 3 == 2)
        System.out.println(dashLine);
    }
  }
}
