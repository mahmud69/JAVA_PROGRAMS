package com.mahmud.codeExamples;

/**
 * Created by khali on 6/24/2017.
 */
/*
Given Given two sorted arrays of size m and n of distinct elements. Given a value x. The problem is to count all pairs from both arrays whose sum is equal to x.

Note: The pair has an element from each array.

*/

public class FindOccurenceTest {

    public static void main (String argv[])
    {
        int [] a1 = {1,3, 5, 7};
        int [] a2 = {2,3, 5, 8};
        int x = 8;
        System.out.printf("count = %d", countPairs (a1, a2, x));
    }

    // function to count all pairs from both the
    // sorted arrays whose sum is equal to a given
    // value
    private static int countPairs (int [] a1, int []a2, int x)
    {
        int count = 0;

        // generating pairs from both the arrays
        for (int element1 : a1)
        {
            for (int element2 : a2) {

                // if sum of pair is equal to 'x'
                // increment count
                // System.out.println("Element: " + element2);
                if (element1+element2 == x)
                    count++;
            }
        }
        return count;


    }

}
