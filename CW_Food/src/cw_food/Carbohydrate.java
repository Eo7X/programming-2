/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw_food;

/**
 *
 * @author eoreizy
 */
public abstract class Carbohydrate extends Food {

    public Carbohydrate(int grams) {
        super(grams * 4, grams);
    }

}
