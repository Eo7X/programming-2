/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw_food;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author eoreizy
 */
public class CW_Food {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Food[] yum = new Food[10];
        ArrayList<String> yum2 = new ArrayList<>();

        //
        //
        //
//        for (Food f : yum) {
//            f.eat();
//        }
//        yum2.add("ssdfasdfasdfasasdsdfa");
//        yum2.add("afhuhd;ahshsa;dg asghas;gdl ga;h");
//
//        yum2.get(0);
//
//        for (String s : yum2) {
//            System.out.println(s);
//        }
//
//        System.out.println();
//        Collections.sort(yum2);
//        System.out.println("after SORT:");
//
//        for (String s : yum2) {
//            System.out.println(s);
//        }
        
        ArrayList<Pasta> ps = new ArrayList<>();
        
        ps.add(new Pasta("Gemelli", 5));
        ps.add(new Pasta("Gnocchi", 4));
        ps.add(new Pasta("Penne", 6));
        ps.add(new Pasta("Gnocchi", 7));
        ps.add(new Pasta("Rigatoni", 2));
        ps.add(new Pasta("Tortellini", 17));
        
        Collections.sort(ps);
        
        for( Pasta s : ps) {
            System.out.println(s);
        }
    }

}
