/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw_arraypractice;

/**
 *
 * @author eoreizy
 */
public class HW_ArrayPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] myarray = {15, 39, 99, 50, 5, 19, 2, 18, 93, 77, 89, 35, 33, 47};
        System.out.println("Minimum of int[] myarray: " + minimum(myarray));
        
        int[] b = new int[myarray.length/2];
        int[] c = new int[myarray.length/2];
        split(myarray, b, c);
        
        comparePrint(b,c);

    }
    
    // Write a function that computes the minimum value of all the items in an array
    /**
     *
     * @param a the array you would like to return the minimum of
     * @return int: the minimum number
     */
    public static int minimum(int[] a){
        int result = 2000000000;
        for(int item : a){
            if(item < result){
                result = item;
            }
        }
        return result;
    }
    
    //Write a function that makes two half-size arrays out of a bigger array
    //- alternating (first item goes into array 1, second into 2, third into 1,
    //fourth into 2 and so on.
    //Yes, I know I'm doing integer math but I actually want it to discard the
    //remainder.

    /**
     *
     * @param a the array you would like to split
     * @param b the first array to put items into
     * @param c the second array to put items into
     */
    public static void split(int[] a, int[] b, int[] c){
        for (int i = 0; i < a.length; i++) {
            if(i % 2 == 0){
                b[i/2] = a[i];
            } else {
                c[i/2] = a[i];
            }
        }
    }
    
    //3) Write a function that takes both arrays as input, and prints them 
    //like this: (useful for comparing 2 values at the same index in an array)
    //Array1[0]: ..., Array2[0]: ...
    //Array1[1]: ..., Array2[1]: ... 
    public static void comparePrint(int[] a, int[] b){
        if(a.length != b.length){
            System.out.println("Error: arrays are not the same length");
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]=" + a[i] + " & b[" + i + "]=" + b[i]);
        }
    }
    
}
