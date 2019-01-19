package Sorter;

import Util.Printer;
import Util.StopWatch;

public class MergeSorter implements Sorter, Printer{
    
    public MergeSorter(){
    }
    
    @Override
    public void sort(int[] a){
        
        if (a.length <=1){
            return;
        }
        
        int [] first = new int [a.length/2];
        int [] second = new int [a.length - first.length];
        
        for (int i= 0; i < first.length; i++){
            first[i] = a[i];
        }
        
        for (int i = 0; i < second.length; i++){
            second[i] = a[first.length + i]; 
        }
        
        sort(first);
        sort(second);
        merge(first, second, a);
    }
        
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
    
    @Override
    public void outputToConsole(StopWatch stopwatch, int size){
       
        System.out.printf( "%13d",size);
       System.out.printf("%11d %1s", stopwatch.getElapsedtTime(),"milliseconds"); 
       System.out.printf("\t\t%-22s\n","Merge Sort");  


        
    }
    
}