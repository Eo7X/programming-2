/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

/**
 *
 * @author eoreizy
 */
public class Person {
    public Person(String name){
        this.name = name;
    }
    
    public Person() {}
    
    String name;
    
    @Override
    public String toString() {
        return "Person: " + name;
    }
}