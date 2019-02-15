//==============================================================================
// Utility Class with methods for arrays and sorting algorithms
//==============================================================================
package Util;

import java.util.Random;

public class ArrayUtil {
    // private class objects 
    private static Random Generator;
    
    //----------------------------------------------    
    // method that fills an array w/ Random object 
    //----------------------------------------------
    public static int[] randomIntArray(int length, int n){
        Generator = new Random();
        int [] a = new int[length];
        
        for (int i = 0; i < a.length; i++){
            a[i] = Generator.nextInt(n) + 1;
        }
        return a;
    }
    
    //--------------------------------------------------------------
    // Method that Swaps values within array between two positions
    // Selection Sort class utilizes it for its sorting algorithm
    //--------------------------------------------------------------
    public static void Swap(int [] a, int i , int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}// end of file 
