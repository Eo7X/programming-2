/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author eoreizy
 */
public class ElectricCar extends Car{
    int batteryPercent;
    void charge(){
        this.batteryPercent += 25;
        System.out.println("You have charged your electric car and it is now " + this.batteryPercent + " percent!");
    }
    
    @Override
    void fillTank() {
        System.out.println("You can't fill a gas tank in an electric car!");
    }
}
