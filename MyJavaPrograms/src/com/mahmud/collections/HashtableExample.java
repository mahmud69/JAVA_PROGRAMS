package com.mahmud.collections;


import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

public class HashtableExample {

    public static void main(String a[]){

        Hashtable<String, String> ht = new Hashtable<String, String>();
        //add key-value pair to Hashtable
        ht.put("first", "FIRST INSERTED");
        ht.put("second", "SECOND INSERTED");
        ht.put("third","THIRD INSERTED");

        System.out.println(ht);

        System.out.println("Size of the Hashtable: "+ ht.size());
        //getting value for the given key from hashtable
        System.out.println("Value of key 'second': "+ht.get("second"));
        System.out.println("Is Hashtable empty? "+ht.isEmpty());

        // Serarch for a value
        if(ht.containsValue("SECOND INSERTED")){
            System.out.println("The Hashtable contains value SECOND INSERTED");
        } else {
            System.out.println("The Hashtable does not contains value SECOND INSERTED");
        }

        //Enumerating the hastable using the keys
        Enumeration<String> ekeys = ht.keys();
        while(ekeys.hasMoreElements()) {
            String key = ekeys.nextElement();
            System.out.println("Value of " + key + " is: " + ht.get(key));
        }

        Set<String> keys = ht.keySet();

        for(String key: keys){
            System.out.println("Value of "+key+" is: "+ht.get(key));
        }
    }
}
