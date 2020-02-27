/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw_food;

/**
 *
 * @author eoreizy
 */
public abstract class Food {
    public Food() {}
    
    int calories;
    int amountInGrams;
    
    abstract void eat();
    
    public Food (int cals, int grams) {
        this.calories = cals;
        this.amountInGrams = grams;
    }
}
