/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs313.hw2.timothy.francis;
/**
 *
 * @author timothy.francis
 */
public class Cs313Hw2TimothyFrancis {
    
    public static int linearSearch(int[] a, int value){
        for(int i =0; i <a.length; i++){
            if(a[i] == value){
                return i;
            }
        }
        return -1;
    }
    
    public static int binarySearch(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            // Key is in a[lo..hi] or not present.
            int mid = low + (high - low) / 2;
            if      (value < a[mid]) high = mid - 1;
            else if (value > a[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = new int[1000000];
        for(int i = 0; i < array.length; i++){
            array[i] = i;
        }
        
        //linear searches
        //best case
        linearSearch(array, 0);
        //worst case
        linearSearch(array, 10000000);
       
        
        //binary searches
        //best case
        binarySearch(array,500000);
        //worst case
        binarySearch(array, 50000000);
        
    }
    
}
