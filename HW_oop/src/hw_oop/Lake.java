/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw_oop;

/**
 *
 * @author eoreizy
 * A class defining the location and properties of a lake.
 */
public class Lake extends Location {
    Lake(String name, double latitude, double longitude, int width, int depth){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.width = width;
        this.depth = depth;
    }
    
    int width;
    int depth;
    
    @Override
    void print(){
        System.out.println("Lake " + this.name + " is located at " + this.latitude + ", " + this.longitude + " and is " + this.width + " feet wide and " + this.depth + " feet deep.");
    }
}
