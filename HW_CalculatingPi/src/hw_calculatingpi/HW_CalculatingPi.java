/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw_calculatingpi;

/**
 *
 * @author eoreizy
 */
public class HW_CalculatingPi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Pi is approximately " + pi_until(2100000000));
    }
    
    // Declare function to calculate the sum until variable k
    public static double pi_until(double k) {
        double result = 0;
        for (int i = 0; i <= k; i++) {
            result += term(i);
        }
        return result * 4;
    }
    
    // Function to calculate the exponent of -1 to the k without having to use Math.pow()
    public static double exp_negative_one(double k) {
        if( k%2 == 1) {
            //k is odd
            return -1;
        } else {
            //k is even
            return 1;
        }
    }
    
    public static double term(double k) {
        return exp_negative_one(k) / (2*k + 1);
    }
    
}
