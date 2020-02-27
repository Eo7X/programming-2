/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw_oop;

/**
 *
 * @author eoreizy
 * A city class with important information about the city.
 */
public class City extends Location {
    int population;
    boolean landlocked;
    String mayorName;
    
    City(String name, double latitude, double longitude, int population, boolean landlocked, String mayorName) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.population = population;
        this.landlocked = landlocked;
        this.mayorName = mayorName;
    }
    
    @Override
    void print(){
        System.out.println("The city of " + this.name + " is located at " + this.latitude + ", " + this.longitude + ". It has a population of " + this.population + " and its mayor is " + this.mayorName + ".");
    }
}
