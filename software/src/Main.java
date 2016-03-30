/*
 * This class is simply for testing the build system and organization of our project. 
 * It will not be in our final product and will most likely be removed soon
 * However, our final project will require some kind of main driver class that ties everything together.
 * This file could be a start for that driver file
*/

import Models.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello from the main program!");
    BoardModel someModel = new BoardModel(5);
  }
}
