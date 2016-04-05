package com.ooadproject.kja.checkers.utilities;
public class GenHelper {
	private final int RED = 1;
	private final int BLACK = 2;
	private final int EMPTY = 0;
  private static GenHelper genHelper;

  private GenHelper()
  {
  }

  public static GenHelper getGenHelper(){
    System.out.println("Getting your board printer");
    if (genHelper == null)
        genHelper = new GenHelper();
    return genHelper;
  }


  public String pieceColorConverter(int color)
  {
    switch (color) {
    case RED:
      return "RED";
    case BLACK:
      return "BLACK";
    case EMPTY:
      return "EMPTY";
    }
    return "oops";
  }
}
