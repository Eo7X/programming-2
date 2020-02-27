/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw_oop;

/**
 *
 * @author eoreizy
 * An abstract location class with attributes used by its subclasses. The Location class is never just used by itself.
 */
abstract public class Location {
    Location() {} // Empty constructor
    double latitude;
    double longitude;
    String name;
    
    //Use an abstract print method because the minutia of what is inside will be different for each kind of Location.
    abstract void print();
}
