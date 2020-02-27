/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw_starwarsnamegenerator;

/* INSTRUCTIONS
Don't forget to click "next". You are mostly interested in the "substring" method.
Then create a function and (!) a test program that asks the user for their first name, last name, favorite city, and first name of a good friend. In the program, create the person's StarWars name like this:
First name: Last 3 letters of favorite city + first 3 letters of first name
Last name: Last 3 letter of friend's name + first 4 letters of last name
Your method should take the 4 inputs as parameters, and return the combined string with first name and last name (fn+" "+ln). You must create the scanner in your main method, gather the 4 inputs, call your method to construct the StarWars name, and then print (System.out.println) the result from your main method. There are deductions for not following instructions. 
0.5 pts extra credit: Generate the name with proper capitalization. Use the  toUpperCase() and toLowerCase() methods.

 */
import java.util.Scanner;

/**
 *
 * @author eoreizy
 */
public class HW_StarWarsNameGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Your Star Wars name is " + makeStarWarsName(getInfo()));
    }

    //A function that takes inputs and puts together the Star Wars Name.
    public static String makeStarWarsName(String[] info) {

        String swFirstName = getLastx(info[2], 3) + getFirstx(info[0], 3);
        String swLastName = getLastx(info[3], 3) + getFirstx(info[1], 4);
        
        String swFullName = capitalize(swFirstName) + " " + capitalize(swLastName);
        
        return swFullName;
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
    public static String getLastx(String in, int amount) {
        String lastx = "";
        if(in.length() < amount) {
            amount = in.length();
        }
        for (int i = in.length() - amount; i <= in.length() - 1; i++) {
            lastx += in.charAt(i);
        }
        return lastx;
    }

    //A simple function to get the last x characters in a string.
    public static String getFirstx(String in, int amount) {
        String firstx = "";
        if(in.length() < amount) {
            amount = in.length();
        }
        for (int i = 0; i < amount; i++) {
            firstx += in.charAt(i);
        }
        return firstx;
    }
    
    //A simple function to put a string in proper capitalization (only first letter capitalized).
    public static String capitalize(String in) {
        String result = "";
        for(int i = 0; i < in.length(); i++) {
            if(i == 0){
                result += String.valueOf(in.charAt(i)).toUpperCase();
            } else {
                result += String.valueOf(in.charAt(i)).toLowerCase();
            }
        }
        return result;
    }
}