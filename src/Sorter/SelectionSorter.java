//=========================================================================================
// Selection Sorter: Sorter class object that has a sorting algorithm that utilizes
// a private iterative method and utility swap method to sort array from least to greatest
//=========================================================================================
package Sorter;

// Utility package imports
import Util.ArrayUtil;
import Util.Printer;
import Util.StopWatch;

public class SelectionSorter implements Sorter,Printer{
    //-------------------------------------------------
    // Default empty constructor
    //-------------------------------------------------
    public SelectionSorter(){
    }
    
    //----------------------------------------------------
    // Main sort method: Sorter interface implementation
    //----------------------------------------------------
    @Override
    public void sort(int[] a){
        // For loop that sorts the array by searching and swapping elements 
        // from least to greatest 
        for (int i = 0; i < a.length - 1; i++){
              int minpos = minimumPosition(a, i);
              ArrayUtil.Swap(a, minpos, i);
        }
        
    }
    //--------------------------------------------------------------
    // method that finds the position of smallest array within
    // current search range of array in sort method and returns it
    //--------------------------------------------------------------
    private int minimumPosition(int[] a, int from){
        
        int position = from;
        for (int i = from + 1; i < a.length; i++){
            
            if (a[i] < a[position]){
                position = i;
            }
        }
        return position;
    }
    
    //-------------------------------------------------------------------------------
    // Printer interface method that prints out runtime of SelectionSorter algorithm
    //-------------------------------------------------------------------------------
    @Override
    public void outputToConsole(StopWatch stopwatch, int size){
       
       //Formatting
       System.out.printf("%13d",size);
       System.out.printf("%11d %1s", stopwatch.getElapsedtTime(),"milliseconds"); 
       System.out.printf("\t\t%-22s\n","Selection Sort");  
    }
}// end of file 