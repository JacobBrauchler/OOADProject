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
    }
}
