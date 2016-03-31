package com.ooadproject.kja.checkers.models;



public class someModel {

  private String someString;

  public someModel(String _someString)
  {
    this.someString = _someString;
    System.out.println("Congrats on constructing someModel!");
    System.out.println("You passed into me: someString = " + someString);
  }
}
