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
public class Pasta extends Carbohydrate implements Comparable {

    String name;
    
    public Pasta(String name, int grams) {
        super(grams);
        this.name = name;
    }

    @Override
    void eat() {
        System.out.println("Pasta! Yumm!");
    }

    @Override
    public int compareTo(Object o) {
        //make sure we are comparing to another pasta
        if(!(o instanceof Pasta)){
            return -1;
        }
        Pasta p = (Pasta) o;
        
        int comparison = this.name.compareTo(p.name);
        
        //if equal names, sort by grams, otherwise by names
        if (comparison == 0) {
            return this.amountInGrams - p.amountInGrams;
        }else{
            return comparison;
        }
        
    }
    
    @Override
    public String toString() {
        return this.name + ", " + this.amountInGrams;
    }

}
