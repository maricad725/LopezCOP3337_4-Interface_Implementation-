package Util;

import java.util.Random;

public class ArrayUtil {
    
    private static Random Generator;
    
    public static int[] randomIntArray(int length, int n){
        Generator = new Random();
        int [] a = new int[length];
        
        for (int i = 0; i < a.length; i++){
            a[i] = Generator.nextInt(n) + 1;
        }
        return a;
    }
    
    public static void Swap(int [] a, int i , int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
