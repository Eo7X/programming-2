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
public class Bus {
    Bus() {}
    Bus(String id, String agency, int route, String destination, String via){
        this.id = id;
        this.agency = agency;
        this.route = route;
        this.destination = destination;
        this.via = via;
    }
    String agency;
    String id;
    int route;
    String destination;
    String via;
    int passengerCount;
    
    void printInfo() {
        System.out.println(this.agency + " bus with id " + this.id + " is on route " + this.route + " towards " + this.destination + " via " + this.via + ".");

    }
}
