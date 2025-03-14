
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
}
