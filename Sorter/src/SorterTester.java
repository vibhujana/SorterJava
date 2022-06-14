import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SorterTester {
    public int arrSize = 1000000;
//    public int[] arr = createArr();
    public int[] arr = createArr();


    @Test
    public void TestSelectionSort(){
        long startTime = System.nanoTime();
        Sorters sort = new Sorters(arr);
        sort.selectionSort();
        long endTime = System.nanoTime();
        // get difference of two nanoTime values
        long timeElapsed = endTime - startTime;

        System.out.println("selection");

        System.out.println("Execution time in nanoseconds  : " + timeElapsed);

        System.out.println("Execution time in milliseconds : " +
                timeElapsed / 1000000);
    }

    @Test
    public void TestMergeSort(){
        long startTime = System.nanoTime();
        Sorters sort = new Sorters(arr);
        sort.mergeSort();
        long endTime = System.nanoTime();
        // get difference of two nanoTime values
        long timeElapsed = endTime - startTime;

        System.out.println("merge");

        System.out.println("Execution time in nanoseconds  : " + timeElapsed);

        System.out.println("Execution time in milliseconds : " +
                timeElapsed / 1000000);
    }

    @Test
    public void TestQuickSort(){
            long startTime = System.nanoTime();
            Sorters sort = new Sorters(arr);
            sort.quickSort();
            long endTime = System.nanoTime();
            // get difference of two nanoTime values
            long timeElapsed = endTime - startTime;

            System.out.println("quick");

            System.out.println("Execution time in nanoseconds  : " + timeElapsed);

            System.out.println("Execution time in milliseconds : " +
                    timeElapsed / 1000000);
    }

    @Test
    public void testSimpleQSort(){
        int[] arr = {19,12,5,16,8};
        Sorters sort = new Sorters(arr);
        sort.quickSort();
    }



    private boolean isSorted(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] > arr[i + 1]){
                return false;
            }
        }
        return true;
    }


    private int[] createArr(){
        int[] arr = new int[arrSize];
        for(int i = 0; i < arr.length; i++){
            Random rand = new Random();
            arr[i] = rand.nextInt();
        }
        return arr;

    }
    public int[] createWorstCase(){
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize ; i++) {
            arr[i] = arrSize - i;
        }
        return arr;
    }
    public int[] createSelectionBestCase(){
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize/2 ; i++) {
            arr[i] =  i + 1;
        }
        for (int i = arrSize/2; i < arrSize; i++) {
            arr[i] = arrSize - i;
        }
        return arr;
    }







}
