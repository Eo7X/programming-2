/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textanalyzer;

import beowulfanalyzer.BeowulfAnalyzer;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author eoreizy
 */
public class TextAnalyzer {
    private String filename;
    private String uselessFilename;
    private String documentTitle;
    private String usableTitle;
    
    private ArrayList<String> allWords = new ArrayList<>();
    private ArrayList<String> uselessWords = new ArrayList<>();
    private ArrayList<Tuple> tuples = new ArrayList<>();
    private ArrayList<Tuple> usefulTuples = new ArrayList<>();
    private ArrayList<Tuple> top10Tuples = new ArrayList<>();
    
    //A bunch of simple functions so that the user doesn't interact directly with the variables

    /**
     * @return ArrayList String of all the words in this text
     */
    public ArrayList<String> getAllWords() {
        return this.allWords;
    }
    
    /**
     * @return All the <b>word and word-count tuples</b>, sorted alphabetically by word.
     */
    public ArrayList<Tuple> getTuples() {
        return this.tuples;
    }
    
    /**
     * @return all the <b>word and word-count tuples not specified in the 'useless words' text file</b> in an arrayList of tuples.
     */
    public ArrayList<Tuple> getUsefulTuples() {
        return this.usefulTuples;
    }
    
    /**
     *
     * @return the most usable title of this text document.
     */
    public String getTitle(){
        return this.usableTitle;
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
     * @return the document title of the text document.
     * <b>Note:</b> if no document title was specified, this will return null.
     */
    public String getDocumentTitle() {
        return this.documentTitle;
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
    
    /**
     * Sets the title of the document.
     * @param newTitle the new title of the document.
     */
    public void setDocumentTitle(String newTitle) {
        this.documentTitle = newTitle;
        this.usableTitle = newTitle;
    }
    
    //Constructors- let you choose whether to provide a document title

    /**
     *
     * @param filename The filename of the text file to analyze.
     * @param uselessFilename The filename of the text file of 'useless' words to filter out. To set no filter, set this to <em>null</em>
     */
    public TextAnalyzer(String filename, String uselessFilename){
        this.filename = filename;
        this.uselessFilename = uselessFilename;
        this.usableTitle = filename;
        this.performAnalysis();
    }
    
    /**
     *
     * @param filename The filename of the text to analyze
     * @param uselessFilename The filename of the text file of 'useless' words to filter out. To set no filter, set this to <em>null</em>.
     * @param documentTitle The title of the document. Optional.
     */
    public TextAnalyzer(String filename, String uselessFilename, String documentTitle){
        this(filename, uselessFilename);
        this.documentTitle = documentTitle;
        this.usableTitle = documentTitle;
    }
    
    //Read the text file into an array list
    private ArrayList<String> createArrayListFromTextFile(String textfile){
        
        InputStream textStream = BeowulfAnalyzer.class.getResourceAsStream(textfile);
        Scanner text = new Scanner(textStream);
        
        ArrayList<String> arraylist = new ArrayList<>();
        
        while (text.hasNext()) {
            String word = text.next().toLowerCase().replaceAll("[^a-z]", "");
            arraylist.add(word);
        }
        
        return arraylist;
    }
    
    //create Tuples with word and frequency from arraylist. This is my original code that was weird and messy
    //and also didn't work well.
//    private ArrayList<Tuple> createTuplesFromArrayList(ArrayList<String> arraylist){
//        arraylist.sort(null);
//        
//        ArrayList<Tuple> resultTuples = new ArrayList<>();
//
//        //Fill the tuple arraylist
//        for (int i = 0; i < allWords.size(); i++) {
//            String thisWord = allWords.get(i);
//            String thisLine = thisWord;
//            int j;
//            for (j = 0; thisLine.equals(thisWord) && i + j < allWords.size(); j++) {
//                thisWord = allWords.get(i);
//                i++;
//            }
//            resultTuples.add(new Tuple(thisWord, j));
//        }
//        
//        return resultTuples;
//    }
    
    //better tuple code
    private ArrayList<Tuple> createTuplesFromArrayListEfficient(ArrayList<String> words){
        words.sort(null);
        ArrayList<Tuple> resultTuples = new ArrayList<>();
        
        //fill the tuple arraylist
        String prevWord = "";
        int count = 0;

        for (int i = 0; i < words.size(); i++) {
            String thisWord = words.get(i);
            
            count ++;
            
            if(!thisWord.equals(prevWord)){
                resultTuples.add(new Tuple(prevWord, count));
                prevWord = thisWord;
                count = 0;
            }
            
        }
        
        return resultTuples;
        //count until you see a new word, THEN set the previous tuple instead of the crazy thing i was doing.
    }
    
    //filter tuples out of an arraylist. remove unwanted words/tuples
    private ArrayList<Tuple> filterTuplesWithArrayList(ArrayList<Tuple> tuples, ArrayList<String> filter){
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
    private ArrayList<Tuple> setTop10Tuples(ArrayList<Tuple> inputTuples){
        inputTuples.sort(null);
        ArrayList<Tuple> result = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            Tuple thisTuple = inputTuples.get(i);
            result.add(thisTuple);
        }
        
        return result;
    }
    
    //This function basically just runs all the other functions.
    private void performAnalysis(){
        this.allWords = createArrayListFromTextFile(this.filename);
        
        if(this.uselessFilename == null){
            this.uselessWords = new ArrayList<>();
        } else {
            this.uselessWords = createArrayListFromTextFile(this.uselessFilename);
        }
        this.tuples = createTuplesFromArrayListEfficient(this.allWords);
        this.usefulTuples = filterTuplesWithArrayList(this.tuples, this.uselessWords);
        this.top10Tuples = setTop10Tuples(this.usefulTuples);  
    }
    
    /**
     * Prints the ten most common words (and their counts) in the text document.
     */
    public void printTop10Tuples() {
        System.out.println("The 10 most common words in " + this.usableTitle + " are:");
        for (Tuple t : this.top10Tuples) {
            System.out.println("- " + t.word + " (" + t.count + " times)");
        }
    }
    
    /**
     * Uses System.out.println()
     * Prints the all- and unique- word count of the text file.
     */
    public void printWordCountAnalysis() {
        System.out.println("There are " + this.getAllWords().size() + " total words and " + this.getTuples().size() + " unique words in Beowulf.");
    }
    
    public ArrayList<Tuple> getTop10TuplesForGraphing() {
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
    
}