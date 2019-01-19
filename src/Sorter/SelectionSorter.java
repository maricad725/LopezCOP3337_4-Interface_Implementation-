package Sorter;

import Util.ArrayUtil;
import Util.Printer;
import Util.StopWatch;

public class SelectionSorter implements Sorter,Printer{
    
    public SelectionSorter(){
    }
    
    @Override
    public void sort(int[] a){
        
        for (int i = 0; i < a.length - 1; i++){
              int minpos = minimumPosition(a, i);
              ArrayUtil.Swap(a, minpos, i);
        }
        
    }
    
    private int minimumPosition(int[] a, int from){
        
        int position = from;
        for (int i = from + 1; i < a.length; i++){
            
            if (a[i] < a[position]){
                position = i;
            }
        }
        return position;
    }
    
    @Override
    public void outputToConsole(StopWatch stopwatch, int size){
         
       System.out.printf("%13d",size);
       System.out.printf("%11d %1s", stopwatch.getElapsedtTime(),"milliseconds"); 
       System.out.printf("\t\t%-22s\n","Selection Sort");  
    }
}