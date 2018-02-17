package com.mahmud.collections;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // create a new ArrayList of Strings with an initial capacity of 10
        ArrayList<String> items = new ArrayList<>();

        items.add("red"); // append an item to the list
        items.add(0, "yellow"); // insert "yellow" at index 0

        // header
        System.out.print("Display list contents with counter-controlled loop:");
        // display the colors in the list
        for (int i = 0; i < items.size(); i++)
            System.out.printf(" %s", items.get(i));
        
        // display colors using enhanced for in the display method
        display(items,"%nDisplay list contents with enhanced for statement:");
    }

    // display the ArrayList's elements on the console
    public static void display(ArrayList<String> items, String header)
    {
        System.out.printf(header); // display header

        // display each element in items
        for (String item : items)
            System.out.printf(" %s", item);
        System.out.println();
    }
}


