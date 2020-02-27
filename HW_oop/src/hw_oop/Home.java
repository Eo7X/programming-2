/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw_oop;

/**
 *
 * @author eoreizy
 * A class defining the properties of a home.
 */
public class Home extends Location {
    Home(String familyName, int inhabitantsNum, int streetAddress, String streetName, double latitude, double longitude){
        this.familyName = familyName;
        this.inhabitantsNum = inhabitantsNum;
        this.streetAddress = streetAddress;
        this.streetName = streetName;
        this.name = streetAddress + " " + streetName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    int inhabitantsNum;
    String familyName;
    String streetName;
    int streetAddress;
    
    @Override
    void print(){
        System.out.println("The " + this.inhabitantsNum + " members of the " + this.familyName + " family live at " + this.streetAddress + " " + this.streetName + " street.");
    }
}
