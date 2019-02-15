// =============================================================================
// Merge Sorter: Sorter class object that has a sorting algorithm that utilizes 
// Recursion to sort an array
//==============================================================================
package Sorter;

//imports from Utility package
import Util.Printer;
import Util.StopWatch;

public class MergeSorter implements Sorter, Printer{
    //----------------------------------------------
    // default empty constructor for object
    //----------------------------------------------
    public MergeSorter(){
    }
    //-------------------------------------------------------
    // // Main sort method: Sorter interface implementation  
    //-------------------------------------------------------
    @Override
    public void sort(int[] a){
        // checks to see if array only has one element 
        if (a.length <=1){
            return;
        }
        //------------------------------------------------------------
        // Splits an array into two different arrays w/ half the size 
        // Fills first array with first half of original array
        // second array gets second half 
        //------------------------------------------------------------
        int [] first = new int [a.length/2];
        int [] second = new int [a.length - first.length];
        
        for (int i= 0; i < first.length; i++){
            first[i] = a[i];
        }
        
        for (int i = 0; i < second.length; i++){
            second[i] = a[first.length + i]; 
        }
        
        //---------------------------------------------------------------------
        // Recursive Calls to split array further
        // Utilizes merge function call to merge and sort the split arrays 
        //---------------------------------------------------------------------
        sort(first);
        sort(second);
        merge(first, second, a);
    }
    
    //--------------------------------------------------------
    // private method that merges and sorts two split arrays
    // Utilized to create one fully sorted array
    //--------------------------------------------------------
    private void merge(int[] first, int[] second, int[] a){
        int iFirst = 0;
        int iSecond = 0;
        int j = 0;
        
        while (iFirst < first.length && iSecond < second.length){    
            if(first[iFirst] < second[iSecond]){
                a[j] = first[iFirst];
                iFirst++;
            }
            else{
                a[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
         
        while (iFirst < first.length){
             a[j] = first[iFirst];
             iFirst++;
             j++;
         }
         
        while (iSecond < second.length){  
            a[j] = second[iSecond];
            iSecond++;
            j++;
         }
    }
    
    //--------------------------------------------------------------------------
    // Printer interface method that prints out runtime of MergeSorter algorithm
    //--------------------------------------------------------------------------
    @Override
    public void outputToConsole(StopWatch stopwatch, int size){
       //Formatting
       System.out.printf( "%13d",size);
       System.out.printf("%11d %1s", stopwatch.getElapsedtTime(),"milliseconds"); 
       System.out.printf("\t\t%-22s\n","Merge Sort");  
       
    }
    
}// end of file 