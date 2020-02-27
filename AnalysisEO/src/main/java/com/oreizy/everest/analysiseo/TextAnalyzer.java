/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oreizy.everest.analysiseo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.control.TextInputDialog;

/**
 *
 * @author eoreizy
 */
public class TextAnalyzer {

    private String filename;
    private String documentTitle;

    private String uselessType;
    
    private File file;
    private File uselessFile;


    private ArrayList<String> allWords = new ArrayList<>();
    private ArrayList<String> uselessWords = new ArrayList<>();
    private ArrayList<Tuple> tuples = new ArrayList<>();
    private ArrayList<Tuple> usefulTuples = new ArrayList<>();
    private ArrayList<Tuple> top10Tuples = new ArrayList<>();

    //A bunch of simple functions so that the user doesn't interact directly with the variables.
    //i don't really know why I made them.
    /**
     * @return ArrayList String of all the words in this text
     */
    public ArrayList<String> getAllWords() {
        return this.allWords;
    }

    /**
     * @return All the <b>word and word-count tuples</b>, sorted alphabetically
     * by word.
     */
    public ArrayList<Tuple> getTuples() {
        return this.tuples;
    }

    /**
     * @return all the <b>word and word-count tuples not specified in the
     * 'useless words' text file</b> in an arrayList of tuples.
     */
    public ArrayList<Tuple> getUsefulTuples() {
        return this.usefulTuples;
    }

    /**
     *
     * @return the most usable title of this text document.
     */
    public String getTitle() {
        return this.documentTitle;
    }

    /**
     *
     * @return the filename of the text document.
     */
    public String getFilename() {
        return this.filename;
    }


    /**
     *
     * @return The total number of words in the text.
     */
    public int getWordCount() {
        return this.allWords.size();
    }

    /**
     *
     * @return The total number of unique words in the text.
     */
    public int getUniqueWordCount() {
        return this.tuples.size();
    }

    /**
     *
     * @return The total number of useful (non-'useless') words in the text.
     */
    public int getUsefulWordCount() {
        return this.usefulTuples.size();
    }
    
    public ArrayList<String> getUselessWords() {
        return this.uselessWords;
    }

    /**
     * Sets the title of the document.
     *
     * @param newTitle the new title of the document.
     */
    public void setDocumentTitle(String newTitle) {
        this.documentTitle = newTitle;
    }

    //This constructor takes two files, the document title in a String, and another string specifying what the user wants as a useless text file. if something other than
    //      "ext" is specified for String uselessType, File useless will just be null.
    public TextAnalyzer(File file, File useless, String uselessType, String docTitle) throws IOException {
        this.filename = file.getPath();
        this.file = file;
        if (useless != null) {
            this.uselessFile = useless;
        }
        this.documentTitle = docTitle;
        this.uselessType = uselessType;
        this.performAnalysis();
    }

    //Read the text file into an array list
    private ArrayList<String> createArrayListFromScanner(Scanner text) {

        ArrayList<String> arraylist = new ArrayList<>();

        while (text.hasNext()) {
            String word = text.next().toLowerCase().replaceAll("[^a-z]", "");
            arraylist.add(word);
        }

        return arraylist;
    }

    //Create a scanner object from a text file located in src/main/resources
    private Scanner createScannerInternal(String path){
        InputStream textStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        Scanner result = new Scanner(textStream);
        return result;
    }
    
    //create a scanner object from a text file located elsewhere on the user's hard drive
    private Scanner createScannerExternal(File file) throws FileNotFoundException {
        Scanner result = new Scanner(file);
        return result;
    }

    //better tuple code
    private ArrayList<Tuple> countIntoTuples(ArrayList<String> words) {
        words.sort(null);
        ArrayList<Tuple> resultTuples = new ArrayList<>();

        //fill the tuple arraylist
        String prevWord = "";
        int count = 0;

        for (int i = 0; i < words.size(); i++) {
            String thisWord = words.get(i);

            count++;

            if (!thisWord.equals(prevWord)) {
                resultTuples.add(new Tuple(prevWord, count));
                prevWord = thisWord;
                count = 0;
            }

        }

        return resultTuples;
        //count until you see a new word, THEN set the previous tuple instead of the crazy thing i was doing.
    }

    //filter tuples out of an arraylist. remove unwanted words/tuples
    private ArrayList<Tuple> filterUselessWords(ArrayList<Tuple> tuples, ArrayList<String> filter) {
        //Create an arraylist for useful tuples.
        ArrayList<Tuple> goodTuples = new ArrayList<>();
        for (Tuple t : tuples) {
            if (!filter.contains(t.word) && !t.word.equals("")) {
                goodTuples.add(t);
            }
        }

        return goodTuples;
    }

    //set the top 10 tuples variable using an array of choosing
    private ArrayList<Tuple> setTop10Tuples(ArrayList<Tuple> inputTuples) {
        inputTuples.sort(null);
        ArrayList<Tuple> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Tuple thisTuple = inputTuples.get(i);
            result.add(thisTuple);
        }

        return result;
    }

    //This function basically just runs all the other functions based on what the String uselessType is.
    private void performAnalysis() throws FileNotFoundException, IOException {

        
        this.allWords = createArrayListFromScanner(createScannerExternal(this.file));
        
        switch (this.uselessType) {
            case "ext":
                this.uselessWords = createArrayListFromScanner(createScannerExternal(this.uselessFile));
                break;
            case "sys":
                this.uselessWords = createArrayListFromScanner(createScannerInternal("useless.txt"));
                break;
            case "emp":
                this.uselessWords = new ArrayList<>();
                this.uselessWords.add("");
                break;
            default:
                break;
        }
        
        this.tuples = countIntoTuples(this.allWords);
        this.usefulTuples = filterUselessWords(this.tuples, this.uselessWords);
        this.top10Tuples = setTop10Tuples(this.usefulTuples);

    }

    /**
     * Prints the ten most common words (and their counts) in the text document.
     */
    public void printTop10Tuples() {
        System.out.println("The 10 most common words in " + this.documentTitle + " are:");
        for (Tuple t : this.top10Tuples) {
            System.out.println("- " + t.word + " (" + t.count + " times)");
        }
    }

    /**
     * Uses System.out.println() Prints the all- and unique- word count of the
     * text file.
     */
    public void printWordCountAnalysis() {
        System.out.println("There are " + this.getAllWords().size() + " total words and " + this.getTuples().size() + " unique words in Beowulf.");
    }

    //returns the top 10 ten tuples plus a [*] tuple with the rest of the words
    public ArrayList<Tuple> getTop10TuplesAll() {
        ArrayList<Tuple> result = new ArrayList<>();
        result.addAll(this.top10Tuples);

        this.tuples.sort(null);

        int count = 0;
        for (int i = 10; i < this.tuples.size(); i++) {
            count += this.tuples.get(i).count;
        }

        result.add(new Tuple("*", count));

        return result;
    }

    //returns the top 10 tuples
    public ArrayList<Tuple> getTop10Tuples() {
        ArrayList<Tuple> result = new ArrayList<>();
        result.addAll(this.top10Tuples);

        this.tuples.sort(null);

        int count = 0;
        for (int i = 10; i < this.tuples.size(); i++) {
            count += this.tuples.get(i).count;
        }

        return result;
    }

    //deprecated function: i used to ask for the document title in a dialog box, but changed it to being on the main screen.
    public void askForDocumentTitle() {
        TextInputDialog input = new TextInputDialog("My Document");
        input.setTitle("Document Title");
        input.showAndWait();
        String result = input.getResult();
        this.documentTitle = result;
    }
}
