package com.mahmud.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // 1. Create a HashMap with String keys and Integer values
        HashMap<String, Integer> studentAges = new HashMap<>();

        // 2. Add elements (key-value pairs) using put()
        studentAges.put("Alice", 20);
        studentAges.put("Bob", 19);
        studentAges.put("Charlie", 21);
        // Adding an existing key overwrites the old value
        studentAges.put("Alice", 21);

        System.out.println("HashMap: " + studentAges); // Output: HashMap: {Bob=19, Alice=21, Charlie=21}

        // 3. Access a value using get()
        int bobAge = studentAges.get("Bob");
        System.out.println("Bob's age: " + bobAge); // Output: Bob's age: 19

        // 4. Check if a key exists
        boolean hasCharlie = studentAges.containsKey("Charlie");
        System.out.println("Contains Charlie? " + hasCharlie); // Output: Contains Charlie? true

        // 5. Remove an element using remove()
        studentAges.remove("Bob");
        System.out.println("HashMap after removing Bob: " + studentAges); // Output: HashMap after removing Bob: {Alice=21, Charlie=21}

        // 6. Iterate through the HashMap using entrySet()
        System.out.println("Iterating through entries:");
        for (Map.Entry<String, Integer> entry : studentAges.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
