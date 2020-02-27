/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw_oop;

/**
 *
 * @author eoreizy
 */
public class HW_oop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Create an array of 10 different locations, varying between cities, homes, and lakes.
        Location[] places = new Location[10];
        places[0] = new City("Seattle", 47.3623, 122.1950, 730400, false, "Jenny Durkan");
        places[1] = new Home("Oreizy", 5, 3438, "E Huron", 47.6023, 122.2878);
        places[2] = new Lake("Object Oriented Programming", 48.6817, 91.9355, 500, 37);
        places[3] = new Lake("Tomb of Deleted Programs", 00.6262, 77.9572, 10000, 10007);
        places[4] = new City("Programmingville", 68.2784, 28.5917, 1998549434, true, "The Artificial Intelligence");
        places[5] = new Home("Microsoft Office", 7, 1901, "Windows", 86.3470, 47.5726);
        places[6] = new City("San Francisco", 37.7739, -122.4315, 883305, false, "London Breed");
        places[7] = new Lake("Baby Yoda Memes", 10.0001, -10.0001, 2000000000, 1);
        places[8] = new City("Dubai", 25.27, 55.29, 3330000, false, "Hussain Nasser Lootah");
        places[9] = new Lake("TMAC 007", 00.000, 00.000, 1, 65826);
        
        //Invoke the print method of each location in the array, printing the relevant information about each one.
        for (Location l : places) {
            l.print();
        }
        
    }
    
}
