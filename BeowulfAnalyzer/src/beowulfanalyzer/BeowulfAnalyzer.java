/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beowulfanalyzer;

import textanalyzer.TextAnalyzer; //import my TextAnalyzer class

/**
 *
 * @author eoreizy
 */
public class BeowulfAnalyzer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TextAnalyzer beowulf = new TextAnalyzer("beowulf.txt", "useless.txt", "Beowulf: An Anglo-Saxon Poem");
        beowulf.printTop10Tuples();

        TextAnalyzer destruction = new TextAnalyzer("destruction.txt", "useless.txt");
        destruction.setDocumentTitle("A Brief Account of the Destruction of the Indies");
        destruction.printTop10Tuples();
        
        TextAnalyzer theBeetle = new TextAnalyzer("beetle.txt", "useless.txt", "The Beetle: A Novel");
        theBeetle.printTop10Tuples();
        
    }

}