/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oreizy.everest.analysiseo;

/**
 *
 * @author eoreizy
 */
public class Tuple implements Comparable<Tuple>{

    //Define properites. the tuple only needs two.
    String word;
    int count;

    //Simple constructor
    Tuple(String word, int count) {
        this.word = word;
        this.count = count;
    }
    
    //For testing purposes, this wasn't part of the assignment
    @Override
    public String toString() {
        return "{" + word + ", " + count + "}";
    }

    //Add the method that lets Java know how to compare and sort tuples
    @Override
    public int compareTo(Tuple t) {
        return t.count - this.count;
    }
}
