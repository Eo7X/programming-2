/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import people.*;

/**
 *
 * @author eoreizy
 */
public class Objects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*
        Car c = new Car();
        ElectricCar ec = new ElectricCar();
        
        ec.charge();
        
        Bus[] buses = new Bus[1000];
        buses[0] = new Bus("kc7141", "King County Metro", 255, "Brickyard P&R", "Kirkland");
        buses[1] = new Bus("ct8897", "Community Transit", 512, "Everett Station", "I-5");
        buses[2] = new Bus("st4815", "Sound Transit", 541, "Overlake P&R", "SR-520");
        buses[3] = new Bus("st6136", "Sound Transit", 545, "Downtown Seattle", "SR-520");
        buses[4] = new Bus("kc6018", "King County Metro", 255, "Totem Lake Transit Center", "Kirkland");
        buses[5] = new Bus("kc9617", "King County Metro", 48, "Mount Baker Transit Center", "Central District");
        
        for( Bus bus : buses ){
            if (bus != null){
                bus.printInfo();
            }
        }

        */
        
        Person p = new Person("Gunnar Mein");
        System.out.println(p);
        
        Person ep = new EPSPerson ("Xavier Galanes", "xgalanes@eastsideprep.org", 2018);
        System.out.println(ep);
        
        Waltzer w = new Waltzer();
        System.out.println(w);
    }
    
}
