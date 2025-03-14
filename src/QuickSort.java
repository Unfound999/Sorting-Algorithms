package src;
import java.util.Random;

public class QuickSort {
    public static void quickSort(int[] data, int begin, int end) {

        if (begin < end) {
            int partitionIndex = partition(data, begin, end);
            
            quickSort(data, begin, partitionIndex-1);
            quickSort(data, partitionIndex+1, end);
        }
    }

    private static int partition(int[] data, int begin, int end) {
        int pivot = data[end];
        int partitionIndex = begin-1;
        int temp;

        for (int i = begin; end > i; i++) {
            if (data[i] <= pivot) {
                i++;
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
        int[] data = new int[50];

        for (int i = 0; )
    }
}
