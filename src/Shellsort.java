import java.util.Arrays;

public class Shellsort {
    static <T extends Comparable<T>> T[] shellSort(T[] items) {
        int sublistcount = items.length / 2;
        while (sublistcount > 0) {
          for (int start = 0; start < sublistcount; start++) {
            gapInsertionSort(items, start, sublistcount);
          }
          sublistcount = sublistcount / 2;
        }
        return items;
      }
      
    static <T extends Comparable<T>> void gapInsertionSort(T[] items, int start, int gap) {
        for (int i = start + gap; i < items.length; i += gap) {
          T currentValue = items[i];
          int position = i;
          while (position >= gap && currentValue.compareTo(items[position - gap]) < 0) {
            items[position] = items[position - gap];
            position = position - gap;
          }
          items[position] = currentValue;
        }
    }
        public static void main(String[] args) {
            String[] items = {"jim", "bob", "zoe"};
            shellSort(items);
            System.out.println(Arrays.toString(items));
        } 
        
    }
    