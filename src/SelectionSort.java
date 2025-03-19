package src;

//This is a selection sort. It is comprised of nested for loops that loop through the arrays and swaps values depending on if the values are greater or lesser.
public class SelectionSort {
    public static <T extends Comparable<T>> void selectionSort(T[] Array) {

        for(int i = 0; i < Array.length; i++) {
            for(int j = 0; j < Array.length; j++) {
                if(Array[i].compareTo(Array[j]) < 0) {
                    T tempVar = Array[i];
                    Array[i] = Array[j];
                    Array[j] = tempVar;
                }
            }

        }
    }
}
