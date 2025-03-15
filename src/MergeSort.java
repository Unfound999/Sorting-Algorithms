/*
 * Authors: Christopher Waschke, Jackson Jenks, Brody Weinkauf
 * Assignment: Week 11 - Sorting Algorithms
 * Description: This file contains a Merge Sort Algorithm.
 * 
 * Citation: "Learn Merge Sort in 13 Minutes (Knife Emoji)" - Bro code (https://www.youtube.com/watch?v=3j0SWDX4AtU)
 */

package src;

import java.util.Arrays;

/*
 * Utility Class MergeSort
 * Provides the utility method MergeSort to sort Arrays of comparable values.
 */
public class MergeSort{

    /*
     * static void Method (uses references for modifications)
     * Performs the comparison and merging of our two arrays.
     * After the split performed in the mergeSort method, we then iterate over the values in each array
     * Swapping their positions in the original array, depending upon which value is lesser.
     * 
     * Parameters:
     *  left  (T Array), the split array on the left to compare.
     *  right (T Array), the split array on the right to compare.
     *  arr   (T Array), the original array, in which our sorted values will go into.
     */
    private static <T extends Comparable<T>> void merge(T[] left, T[] right, T[] arr){
        
        // Get the size of our two arrays.
        int leftLength = left.length; 
        int rightLength = right.length;
        
        int i = 0, l = 0 , r = 0; // Initialize index counters.

        // Iterate through both arrays, checking if left is greater than the right.
        // The array at index of i should contain the lesser value of the two arrays.
        while(l < leftLength && r < rightLength){
            if(left[l].compareTo(right[r]) < 0){
                arr[i] = left[l];
                l++;
                i++;
            } else {
                arr[i] = right[r];
                r++;
                i++;
            }
        }

        // Handle potential remaining values in arrays.
        while(l < leftLength){
            arr[i] = left[l];
            i++;
            l++;
        }
        while(r < rightLength){
            arr[i] = right[r];
            i++;
            r++;
        }
    }

    /*
     * static void mergeSort (Modifies through reference)
     * This method takes in the original array we wish to sort.
     * The method will split our array down by recursively calling this method.
     * Base case is when the array called upon has a length of 1, which means it can no longer split.
     * Once the arrays have been fully split, we call the merge function, to sort each split array.
     * It is the merge function that actually performs the sorting of the array, with the comparison.
     */
    public static <T extends Comparable<T>> void mergeSort(T[] arr){

        // Base Case. We don't continue to split once our arrays are already at length of one.
        if(arr.length == 1){
            return;
        }

        // Find the middle of the array, rounded down by default in Java, and copy those values into new arrays.
        int arrSplit = arr.length / 2;
        T[] arr1 = Arrays.copyOfRange(arr, 0, arrSplit);
        T[] arr2 = Arrays.copyOfRange(arr, arrSplit, arr.length);
        
        // Recurse through these arrays, continuing to split until we hit base case.
        mergeSort(arr1);
        mergeSort(arr2);

        // Finally, once completed split, move onto the merge method to compare and finally sort.
        merge(arr1, arr2, arr);
    }
}