package coinpurse;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.PrintConversionEvent;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author your name
 */
public class Main {

    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
    	//TODO follow the steps in the sequence diagram on Lab sheet.
        // 1. create a Purse
    	Purse purse = new Purse(1);
        // 2. create a ConsoleDialog with a reference to the Purse object
//    	ConsoleDialog ui = new ConsoleDialog(purse);
//        // 3. run the ConsoleDialog
//    	ui.run();
    	System.out.println(purse.isFull());
    	System.out.println(purse.insert(new Coin(10, "Bath")));
    	System.out.println(purse.insert(new Coin(0, "Bath")));
    	System.out.println(purse.isFull());
    	System.out.println(purse.insert(new Coin(-2, "Bath")));
    }
}
