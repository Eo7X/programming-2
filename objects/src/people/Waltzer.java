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
public class Waltzer extends EPSPerson implements Parent {

    public Waltzer () {
        super("Adam Waltzer", "awaltzer@eastsideprep.org", 2007);
    }
    
    @Override
    public void addStudent(EPSPerson student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void contact() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
