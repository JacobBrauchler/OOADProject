package com.ooadproject.kja.checkers.views;



public class someView {

  private int someInt;
  private String someString;

  public someView(int _someInt, String _someString)
  {
    this.someInt = _someInt;
    this.someString = _someString;
    System.out.println("Congrats on constructing someView!");
    System.out.println("You passed into me: someInt = " + someInt + " someString = " + someString);
  }
}
