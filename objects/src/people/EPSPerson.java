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
public class EPSPerson extends Person {
    
    public EPSPerson (String name, String email, int startYear){
        super(name);
        this.email = email;
        this.startYear = startYear;
    }
    
    public EPSPerson () {}
    
    int startYear;
    int phoneNum;
    String email;
    
    @Override
    public String toString() {
        return "EPSPerson: "+ super.toString() + " email:" + email + " startYear:" + startYear;
    }
    
}
