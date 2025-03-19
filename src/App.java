/*
 * Authors: Christopher Waschke, Jackson Jenks, Brody Weinkauf
 * Assignment: Week 11 - Sorting Algorithms
 * Description: The UI/Test for our sorting algorithms.
 */

package src;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    /*
     * Static String Method
     * Prints out our main menu, and gets the users choice from it.
     */
    public static String menu(){
        Scanner input = new Scanner(System.in);
        System.out.println("m.) Merge Sort");
        System.out.println("q.) Quick Sort");
        System.out.println("s.) Selection Sort");
        System.out.println("x.) Exit");
        System.out.print("Selection> ");
        return input.nextLine().toLowerCase();
    }

    /*
     * Static Integer[] method
     * Gets a users input of numbers, and creates an Array from it, for sorting.
     */
    public static Integer[] getInputArr(){
        boolean validInput = true;
        ArrayList<Integer> numbList;
        do {
            numbList = new ArrayList<>();
            System.out.println("Please enter the numbers you wish to sort.");
            Scanner input = new Scanner(System.in);
            Scanner numbScan = new Scanner(input.nextLine());
            while(numbScan.hasNext()){
                try {
                    numbList.add(numbScan.nextInt());
                } catch(InputMismatchException e){
                    System.out.println("Please only insert numbers.");
                    validInput = false;
                }
            }
        } while(!validInput);
        Integer[] outArr = new Integer[numbList.size()];
        numbList.toArray(outArr);
        return outArr;
    }

    /*
     * static void method
     * Gets the User's input for an array to be sorted.
     * The uses the Merge Sort Algorithm to sort the array.
     * Then prints out the value.
     */
    public static void doMerge(){
        Integer[] numbArr = getInputArr();
        MergeSort.mergeSort(numbArr);
        System.out.println(Arrays.toString(numbArr));
    }

     /*
     * static void method
     * Gets the User's input for an array to be sorted.
     * The uses the Selection Sort Algorithm to sort the array.
     * Then prints out the value.
     */
    public static void doSelection(){
        Integer[] numbArr = getInputArr();
        SelectionSort.selectionSort(numbArr);
        System.out.println(Arrays.toString(numbArr));
    }

    /*
     * static void method
     * Gets the User's input for an array to be sorted.
     * The uses the Quick Sort Algorithm to sort the array.
     * Then prints out the value.
     */
    public static void doQuick(){
        Integer[] numbArr = getInputArr();
        QuickSort.quickSort(numbArr, 0, numbArr.length-1);
        System.out.println(Arrays.toString(numbArr));
    }

    /*
     * Main Method (Entry Point)
     * A simple loop that shows our menu, and handles to code branch based upon the selection made.
     */
    public static void main(String[] args) {
        boolean running = true;
        while(running){
            switch (menu()) {
                case "m":
                    doMerge();
                    break;
                case "q":
                    doQuick();
                    break;
                case "s":
                    doSelection();
                    break;
                case "x":
                    running = false;
                    break;
                default:
                    System.out.println("Please make a valid choice.");
                    break;
            }
        }
    }
}
