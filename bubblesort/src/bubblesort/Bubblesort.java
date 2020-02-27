/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

/**
 *
 * @author eoreizy
 */
public class Bubblesort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Sorting test1");
        int[] test1 = {1,6,2,6,7,2,9,2,9,24,86,2,6,125,1,4,1,7};
        bubblesort(test1);
        printarray(test1);
        
        System.out.println("");
        
        System.out.println("Sorting test2");
        int[] test2 = {6,7,1,7,13,8,3,78,2,8,24,15,7,13,7,12,16,83,24};
        bubblesort(test2);
        printarray(test2);
        
    }
    
    /**
     *
     * @param a an integer array to sort via the BubbleSort method
     */
    public static void bubblesort(int[] a){
        while(pass(a));
    }
    
    public static boolean pass(int[] a){
        boolean swapped = false;
        for (int i = 0; i < a.length -1; i++) {
            if(a[i] > a[i+1]){
                swap(a, i, i+1);
                swapped = true;
            }
        }
        return swapped;
    }
    
    public static void swap(int[] a, int i1, int i2){
        int temp = a[i2];
        a[i2] = a[i1];
        a[i1] = temp;
    }
    
    public static void printarray(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
