package com.ooadproject.kja.checkers.utilities;
import java.awt.Toolkit.*;
public class GenHelper {
  private final int RED = 1;
  private final int BLACK = 2;
  private final int EMPTY = 0;
  private static GenHelper genHelper;

  private GenHelper()
  {
  }

  public static GenHelper getGenHelper(){
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
  public static int GetScreenWorkingWidth() {
    return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
  }

  public static int GetScreenWorkingHeight() {
    return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
  }
}
