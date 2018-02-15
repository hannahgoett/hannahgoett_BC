/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs313.lab04.timothy.francis;

import java.util.Random;

/**
 *
 * @author timothy.francis
 */
public class Cs313Lab04TimothyFrancis {

    static int[] gaps = {7, 3, 1};
    //{5000, 1750, 701, 301, 132, 57, 23, 10, 4, 1};
    static int[] a10 = new int[10];
    static int[] a100 = new int[100];
    static int[] a500 = new int[500];
    static int[] a1000 = new int[1000];
    static int[] a5000 = new int[5000];
    static int[] a10000 = new int[10000];
    static int[] a50000 = new int[50000];
    static int[] a100000 = new int[100000];
    static int[] a500000 = new int[500000];
    static int[] a1000000 = new int[1000000];
    static long swaps = 0;
    static long compares = 0;

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void fillArray(int[] a) {
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(a.length);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
        swaps++;
    }

    public static boolean compareLessThan(int i, int j) {
        compares++;
        return i <= j;

    }

    public static boolean compareGreaterThan(int i, int j) {
        compares++;
        return i >= j;

    }

    public static void selectionSort(int[] a) {
        /* a[0] to a[n-1] is the array to sort */
        swaps = 0;
        compares = 0;
        int i, j;

        /* advance the position through the entire array */
        /*   (could do j < n-1 because single element is also min element) */
        for (j = 0; j < a.length - 1; j++) {
            /* find the min element in the unsorted a[j .. n-1] */

            /* assume the min is the first element */
            int iMin = j;
            /* test against elements after j to find the smallest */
            for (i = j + 1; i < a.length; i++) {
                /* if this element is less, then it is the new minimum */
                if (compareLessThan(a[i], a[iMin])) {
                    /* found new minimum; remember its index */
                    iMin = i;
                }
            }

            if (iMin != j) {
                swap(a, iMin, j);
            }
            printArray(a);
            System.out.println("");
        }
    }

    public static void insertionSort(int[] a) {
        swaps = 0;
        compares = 0;
        for (int i = 1; i < a.length; i++) {
            int x = a[i];
            int j = i - 1;
            while (j >= 0 && compareLessThan(x, a[j])) {
                swap(a, j, j + 1);
                j--;
            }
            a[j + 1] = x;
            printArray(a);
            System.out.println("");
        }
        printArray(a);
        System.out.println("");

    }

    public static void mergeSort(int[] a, int iBegin, int iEnd) {
        swaps = 0;
        compares = 0;
        if (iEnd - iBegin < 2) {
            return;
        }
        int iMiddle = (iEnd + iBegin) / 2;
        mergeSort(a, iBegin, iMiddle);
        mergeSort(a, iMiddle, iEnd);
        merge(a, iBegin, iMiddle, iEnd);
    }

    public static void merge(int[] a, int iBegin, int iMiddle, int iEnd) {
        int i = iBegin;
        int j = iMiddle;
        int[] b = new int[a.length];

        for (int k = iBegin; k < iEnd; k++) {
            if (i < iMiddle && (j >= iEnd || compareLessThan(a[i], a[j]))) {
                b[k] = a[i];
                swaps++;
                i++;
            } else {
                b[k] = a[j];
                swaps++;
                j++;
            }
        }

        for (int k = iBegin; k < iEnd; k++) {
            a[k] = b[k];
        }
    }

    public static void quickSort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int p = partition(a, lo, hi);
            printArray(a);
            System.out.println(" ");
            quickSort(a, lo, p - 1);
            quickSort(a, p + 1, hi);
        }
    }

    public static int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (compareLessThan(a[j], pivot)) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, hi);
        return i;
    }

    public static void shellSort(int[] a) {
        for (int gap : gaps) {
            for (int i = gap; i < a.length; i++) {
                int j = i;
                while (j >= gap && compareGreaterThan(a[j - gap], a[j])) {
                    swap(a, j - gap, j);
                    j = j - gap;
                }
                printArray(a);
                System.out.println("");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
//open up this block to test selection sort
//        
//        fillArray(a10);
//        int[] testArray = (int[]) a10.clone();
//        printArray(testArray);
//        long i = System.nanoTime();
//        selectionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//  
//       fillArray(a100);
//        testArray = (int[]) a100.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        selectionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a500);
//        testArray = (int[]) a100.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        selectionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a1000);
//        testArray = (int[]) a1000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        selectionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//     
//     
//     fillArray(a5000);
//        testArray = (int[]) a5000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        selectionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a10000);
//        testArray = (int[]) a10000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        selectionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a50000);
//        testArray = (int[]) a50000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        selectionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a100000);
//        testArray = (int[]) a100000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        selectionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a500000);
//        testArray = (int[]) a500000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        selectionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a1000000);
//        testArray = (int[]) a1000000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        selectionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//         

//open up this block for insertion sort
//        fillArray(a10);
//        int[] testArray = (int[]) a10.clone();
//        printArray(testArray);
//        long i = System.nanoTime();
//        insertionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//        fillArray(a100);
//        testArray = (int[]) a100.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        insertionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//
//        fillArray(a500);
//        testArray = (int[]) a500.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        insertionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//
//        fillArray(a1000);
//        testArray = (int[]) a1000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        insertionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//
//        fillArray(a5000);
//        testArray = (int[]) a5000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        insertionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//        fillArray(a10000);
//        testArray = (int[]) a10000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        insertionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a50000);
//        testArray = (int[]) a50000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        insertionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a100000);
//        testArray = (int[]) a100000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        insertionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//        fillArray(a500000);
//        testArray = (int[]) a500000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        insertionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a1000000);
//        testArray = (int[]) a1000000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        insertionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//
//        fillArray(a10);
//        int[] testArray = (int[]) a10.clone();
//        printArray(testArray);
//        long i = System.nanoTime();
//        selectionSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//open this block for merge sort
//        fillArray(a10);
//        int[] testArray = (int[]) a10.clone();
//        printArray(testArray);
//        long i = System.nanoTime();
//        mergeSort(testArray, 0, testArray.length - 1);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a100);
//        testArray = (int[]) a100.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        mergeSort(testArray, 0, testArray.length - 1);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a500);
//        testArray = (int[]) a500.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        mergeSort(testArray, 0, testArray.length - 1);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a1000);
//        testArray = (int[]) a1000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        mergeSort(testArray, 0, testArray.length - 1);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a5000);
//        testArray = (int[]) a5000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        mergeSort(testArray, 0, testArray.length - 1);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a10000);
//        testArray = (int[]) a10000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        mergeSort(testArray, 0, testArray.length - 1);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a50000);
//        testArray = (int[]) a50000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        mergeSort(testArray, 0, testArray.length - 1);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a100000);
//        testArray = (int[]) a100000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        mergeSort(testArray, 0, testArray.length - 1);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a500000);
//        testArray = (int[]) a500000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        mergeSort(testArray, 0, testArray.length - 1);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a1000000);
//        testArray = (int[]) a1000000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        mergeSort(testArray, 0, testArray.length - 1);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
        int[] a = {89, 76, 46, 25, 11, 33, 63, 71, 61, 42, 15, 30};
        insertionSort(a);
//        printArray(a);
//        System.out.println("");
//        quickSort(a, 0, a.length - 1);
//        System.out.println(" ");
//        printArray(a);
//        System.out.println(" ");
//        System.out.println(" ");

//        fillArray(a100);
//        testArray = (int[]) a100.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        quickSort(testArray, 0, testArray.length - 1);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a500);
//        testArray = (int[]) a500.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        quickSort(testArray, 0, testArray.length - 1);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a1000);
//        testArray = (int[]) a1000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        quickSort(testArray, 0, testArray.length - 1);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a5000);
//        testArray = (int[]) a5000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        quickSort(testArray, 0, testArray.length - 1);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a10000);
//        testArray = (int[]) a10000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        quickSort(testArray, 0, testArray.length - 1);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a50000);
//        testArray = (int[]) a50000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        quickSort(testArray, 0, testArray.length - 1);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a100000);
//        testArray = (int[]) a100000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        quickSort(testArray, 0, testArray.length - 1);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a500000);
//        testArray = (int[]) a500000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        quickSort(testArray, 0, testArray.length - 1);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a1000000);
//        testArray = (int[]) a1000000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        quickSort(testArray, 0, testArray.length - 1);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//
//open this block if you wish to test shell sort
//        fillArray(a10);
//        int[] testArray = (int[]) a10.clone();
//        printArray(testArray);
//        long i = System.nanoTime();
//        shellSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray);
//        System.out.println(" ");
//        System.out.println(" ");
//  
//       fillArray(a100);
//        testArray = (int[]) a100.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        shellSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a500);
//        testArray = (int[]) a100.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        shellSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a1000);
//        testArray = (int[]) a1000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        shellSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//     
//     
//     fillArray(a5000);
//        testArray = (int[]) a5000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        shellSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a10000);
//        testArray = (int[]) a10000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        shellSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a50000);
//        testArray = (int[]) a50000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        shellSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a100000);
//        testArray = (int[]) a100000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        shellSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a500000);
//        testArray = (int[]) a500000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        shellSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
//        
//        fillArray(a1000000);
//        testArray = (int[]) a1000000.clone();
//        printArray(testArray);
//        i = System.nanoTime();
//        shellSort(testArray);
//        System.out.println(" ");
//        System.out.println((System.nanoTime() - i) * 1e-9 + " seconds");
//        System.out.println(swaps + " swaps");
//        System.out.println(compares + " compares");
//        printArray(testArray); 
//        System.out.println(" ");
//        System.out.println(" ");
    }

}
