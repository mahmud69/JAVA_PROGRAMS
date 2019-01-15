package com.mahmud.BookExamples.Chapter26_Multithreading;

// Fig. 26.6: ArrayWriter.java
// Adds integers to an array shared with other Runnables
import java.lang.Runnable;

public class ArrayWriter implements Runnable
{
    private final SimpleArray sharedSimpleArray;
    private final int startValue;

    public ArrayWriter( int value, SimpleArray array )
    {
        startValue = value;
        sharedSimpleArray = array;
    } // end constructor

    public void run()
    {
        for ( int i = startValue; i < startValue + 3; i++ )
        {
            sharedSimpleArray.add( i ); // add an element to the shared array
        } // end for
    } // end method run
} // end class ArrayWriter