/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eastsideprep.tron_m;

/**
 *
 * @author gmein
 */
public class YourCycle extends LightCycle{

    @Override
    int getDirection(Grid grid, int col, int row, int currentDir) {
        return currentDir;
    }
    
}
