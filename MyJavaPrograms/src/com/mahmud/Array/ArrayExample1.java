package com.mahmud.Array;

public class ArrayExample1 {
    public static void main (String argv [] )
    {
        int[] array1 = { 32, 27, 64, 18, 95, 14, 90, 70, 60, 37 };

        // output each array element's value
        for (int counter = 0; counter < array1.length; counter++)
            System.out.printf("%5d%8d%n", counter, array1[counter]);

        System.out.println ("\nTraversing Array with Enhance for Laoop\n");
        // Enhanced For Loop
        int counter = 0;
        for (int x: array1)
        {
            System.out.printf("%5d%8d%n", counter, array1[counter]);
            counter++;
        }

        final int ARRAY_LENGTH = 10; // declare constanct

        int [] array_squares = new int[ARRAY_LENGTH];

        for (counter = 0; counter < ARRAY_LENGTH; counter++)
        {
            array_squares[counter] = (counter + 1) * (counter + 1);
        }

        // output each array element's value
        for ( counter = 0; counter < array1.length; counter++)
            System.out.printf("%5d%8d%n", counter, array_squares[counter]);


        sumArray();

    }

    public static void sumArray ()
    {
      int[] array = { 87, 68, 94, 100, 83, 78, 85, 91, 76, 87 };
      int total = 0;

      for (int x : array)
      {
          total += x;
      }
      displayArray(array);
      System.out.printf("Total of array elements: %d%n", total);
    }

    public static void displayArray (int [] x)
    {
        int index = 0;
        System.out.println("****************************************");
        for (int counter : x)
        {
            System.out.printf("%5d%8d%n", index++, counter);
        }
    }
}
