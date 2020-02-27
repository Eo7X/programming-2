/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw_babylon5namegenerator;

import java.util.Scanner;

/**
 *
 * @author eoreizy
 */
public class HW_Babylon5NameGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Prepare arrays from data from 5 people.
        String[] everest = {"Everest", "Oreizy", "Seattle", "Rayhan"};
        String[] sophie = {"Sophie", "Gershaft", "Seattle", "David"};
        String[] grant = {"Grant", "Fellows", "Seattle", "Jackson"};
        String[] subi = {"Subi", "Lumala", "Dont really have one", "Bill"};
        String[] jsun = {"Jonathan", "Sun", "Seattle", "William"};
        String[] drwhitmer = {"Señor", "Whitmer", "Paris", "Caroline"};

        //Make and print Babylon 5 names for those people.
        System.out.println("Everest's Babylon 5 name is " + makeBabylon5Name(everest));
        System.out.println("Sophie's Babylon 5 name is " + makeBabylon5Name(sophie));
        System.out.println("Grant's Babylon 5 name is " + makeBabylon5Name(grant));
        System.out.println("Subi's Babylon 5 name is " + makeBabylon5Name(subi));
        System.out.println("Jsun's Babylon 5 name is " + makeBabylon5Name(jsun));
        System.out.println("Dr. Whitmer's Babylon 5 name is " + makeBabylon5Name(drwhitmer));
                
        //Ask the person running the program to make their own.
        System.out.println("Now make your own Babylon 5 name!");
        System.out.println("Your Babylon 5 name is " + makeBabylon5Name(getInfo()));

    }

    //A function that takes inputs (a 4-length string array) and puts together the Star Wars Name.
    public static String makeBabylon5Name(String[] info) {

        String b5FirstName = getLastx(info[2], 3) + getFirstx(info[0], 3);
        String b5LastName = getLastx(info[3], 3) + getFirstx(info[1], 4);

        String b5FullName = capitalize(addApostrophe(b5FirstName)) + " " + capitalize(addApostrophe(b5LastName));

        return b5FullName;
    }

    //A simple function to get all the inputs we'll need.
    public static String[] getInfo() {
        String[] info = new String[4];

        Scanner sc = new Scanner(System.in);
        System.out.println("First name: ");
        info[0] = sc.nextLine();

        System.out.println("Last name: ");
        info[1] = sc.nextLine();

        System.out.println("Favorite city: ");
        info[2] = sc.nextLine();

        System.out.println("Friend's name: ");
        info[3] = sc.nextLine();

        return info;
    }

    //A simple function to get the last three characters in a string.
    //It also checks to see if the input string is shorter than the amount to take and corrects for that.
    public static String getLastx(String in, int amount) {
        if (amount > in.length()) {
            return in;
        }
        return in.substring(in.length() - amount, in.length());
    }

    //A simple function to get the last x characters in a string.
    //It also checks to see if the input string is shorter than the amount to take and corrects for that.
    public static String getFirstx(String in, int amount) {
        if (amount > in.length()) {
            return in;
        }
        return in.substring(0, amount);
    }

    //A simple function to put a string in proper capitalization (only first letter capitalized).
    public static String capitalize(String in) {
        String result = "";
        for (int i = 0; i < in.length(); i++) {
            if (i == 0) {
                result += String.valueOf(in.charAt(i)).toUpperCase();
            } else {
                result += String.valueOf(in.charAt(i)).toLowerCase();
            }
        }
        return result;
    }

    //A function to add an apostrophe before the first consonant (but not as the first character) in a String.
    public static String addApostrophe(String in) {
        String result = "" + in.charAt(0);
        boolean placed = false;
        for (int i = 1; i < in.length(); i++) {
            char c = in.charAt(i);
            if (placed) {
                result += c;
            } else if (c == 97 || c == 101 || c == 105 || c == 111 || c == 117) {
                result += c;
            } else {
                result += "'" + c;
                placed = true;
            }

        }

        return result;
    }
}
