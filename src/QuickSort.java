package src;
import java.util.Random;

public class QuickSort {
    public static <T extends Comparable<T>> void quickSort(T[] data, int begin, int end) {

        if (begin < end) {
            int partitionIndex = partition(data, begin, end);
            
            quickSort(data, begin, partitionIndex-1);
            quickSort(data, partitionIndex+1, end);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] data, int begin, int end) {
        T pivot = data[end];
        int partitionIndex = begin-1;
        T temp;

        for (int i = begin; end > i; i++) {
            if (data[i].compareTo(pivot) == -1|| data[i].compareTo(pivot) == 0) {
                partitionIndex++;
                temp = data[partitionIndex];
                data[partitionIndex] = data[i];
                data[i] = temp;
            }
        }

        temp = data[partitionIndex+1];
        data[partitionIndex+1] = data[end];
        data[end] = temp;

        return partitionIndex+1;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Integer[] data = new Integer[50];

        for (int i = 0; 50 > i; i++) {
            data[i] = rand.nextInt(50) + 1;
        }

        System.out.println("Unsorted data");
        for (int i = 0; 50 > i; i++) {
            System.out.print(data[i] + " ");
        }

        quickSort(data, 0, 49);

        System.out.println("\n\nSorted data");
        for (int i = 0; 50 > i; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
