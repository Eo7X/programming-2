/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beowulf;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author eoreizy
 */
public class Beowulf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String file = "beowulf_clean.txt";
        
        InputStream beowulf = Beowulf.class.getResourceAsStream(file);
        Scanner beowulfScanner = new Scanner(beowulf);

        //Count the words in beowulf_story.txt
        int count;
        for (count = 0; beowulfScanner.hasNext(); count++) {
            beowulfScanner.next();
        }

        System.out.println("There are " + count + " words in Beowulf.");

        //Make the array and fill it
        String[] words = new String[count];

        InputStream beowulf2 = Beowulf.class.getResourceAsStream(file);
        Scanner beowulfScanner2 = new Scanner(beowulf2);

        int i = 0;
        while (beowulfScanner2.hasNext()) {
            words[i] = beowulfScanner2.next();
            i++;
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the word you would like to count.");
        String word = input.nextLine();
        
        System.out.println("Beowulf contains the word " + word + " " + countWord(words, word) + " times.");

    }

    public static int countWord(String[] words, String word) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(word)) {
                count++;
            }
        }

        return count;
    }

}
