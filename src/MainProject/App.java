//=============================================================================
// PROGRAMMER: Alex Lopez  
// PANTHER ID:  6132200
//
// CLASS: COP3337      
// SECTION: U10   
// SEMESTER: Fall
// CLASSTIME: 7:50-9:05 p.m.
//
// Project #4    
// DUE:  11/26/18       
//
// CERTIFICATION: I certify that this work is my own and that
//                 none of it is the work of any other person.
//=============================================================================

//=============================================================================
// This porject utilizes interfaces, sorting methods, and documented java class
// programs to create a time table comparing the runtime of two different sorting 
// Sorting algorithms: Selection sort and Merge sort
//==============================================================================

package MainProject;

// imports from Sorter package
import Sorter.MergeSorter;
import Sorter.SelectionSorter;
import Sorter.Sorter;

// imports from Util package
import Util.ArrayUtil;
import Util.Printer;
import Util.StopWatch;

// import Arrays utility class from Java API
import java.util.Arrays;

// Main class that runs the program
public class App {

    public static void main(String[] args) {
    //=========================================================
    // Stopwatch and Sorting Objects
    //=========================================================
        StopWatch stopWatch = new StopWatch();
        SelectionSorter selectionSorter = new SelectionSorter();
        MergeSorter mergeSorter = new MergeSorter();
        
        //======================================================================
        // Header of sort array time table 
        //======================================================================
        System.out.println("Size of Array\t       Sort Time\t\tSort Type");
        System.out.println("---------------------------------------------------------------");
        
        
        //======================================================================
        // Main Sort Time algorithm:
        // Size of arrays are in powers of ten from 1-6
        // Utilizes analyzeSort method to time the sorting objects 
        // =====================================================================
        
        for (int i = 1; i < 6; i++){

        int size =(int)Math.pow(10, i);
        int[] a = ArrayUtil.randomIntArray((int)size,100);
        int[] b =Arrays.copyOf(a, a.length);

        analyzeSort(stopWatch, selectionSorter, a);
        analyzeSort(stopWatch, mergeSorter, b);
        
        }//end for
        
}// end main

//==============================================================================
// Helper Functions 
//==============================================================================
    
    //==========================================================================
    // Measures the runtime of the sorting algorithms for sorter objects
    // Then it prints out the results in milliseconds using seperate function 
    //==========================================================================
    public static void analyzeSort(StopWatch stopWatch, Sorter sorter, int[] a){
        
        stopWatch.start();            
        sorter.sort(a);
        stopWatch.stop();

        output((Printer)sorter, stopWatch, a.length);
    }
    
    //==========================================================================
    // Handles the printing aspect of analyzeSort method:
    // Calls the implemented Printer method from sorting objects
    //==========================================================================
    public static void output(Printer printer, StopWatch stopWatch, int size){
        
        printer.outputToConsole(stopWatch, size);
        stopWatch.reset();
    }    
    
}// end of file
    
