package com.mphasis;

import java.util.Random;

public class RandomPersonPickedUp {
    public static void main(String[] args) {
        // Define an array
        String[] person = {"Sham", "Varsha", "Naresh", "Bhuvan", "Dhaarnai", "Srinithi","Ashiwni","Aditya","Anirudha","Bharagav","Daiveek","Keerthika","Praveenanyagam","PraveenBanu",
        		"Sirajudeen"};

        // Create Random object
        Random rand = new Random();

        // Generate a random index between 0 and array length - 1
        int randomIndex = rand.nextInt(person.length);

        // Print the random index and the value at that index
        System.out.println("Random Index: " + randomIndex);
        System.out.println("Value at Random Index: " + person[randomIndex]);
    }
}
