package com.ooadproject.kja.checkers.utilities;


public class BoardPrinter {

  private static BoardPrinter boardPrinter;

  private BoardPrinter()
  {
  }

  public static BoardPrinter getBoardPrinter(){
    System.out.println("Getting your board printer");
    if (boardPrinter == null)
        boardPrinter = new BoardPrinter();
    return boardPrinter;
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
