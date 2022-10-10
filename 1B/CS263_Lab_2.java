// Question: Implement quick Sort using 2 pivot elements

import java.util.*;

public class CS263_Lab_2 {
    // This is a function of quicksort
    public static void QUICKSORT(int[] array, int low, int high) {
        // This is our base case
        if (low < high) {
            int[] partition = new int[2];
            partition = PARTITION(array, low, high);
            int p = partition[0];
            int q = partition[1];
            // These are two index according to which partition is going to takes place.
            QUICKSORT(array, low, p - 1);
            QUICKSORT(array, p + 1, q - 1);
            QUICKSORT(array, q + 1, high);
        }
        // Since we are sorting using two pivots we will have three partitions.
        // So we have called quicksort three times recursively.
    }

    public static int[] PARTITION(int[] array, int low, int high) {
        int[] partition = new int[2];
        int pivot_1 = array[low];
        int pivot_2 = array[high];
        if (pivot_1 > pivot_2) {
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            pivot_1 = array[low];
            pivot_2 = array[high];
        }
        // Here we have made use of two pointers from both the sides of array.
        // We have made comparisions and according to which we have swap the elements.
        int index1 = low - 1, index2 = high + 1;
        int j = low, k = high;
        while (j < high && k > low) {
            if (array[j] < pivot_2) {
                index1++;
                int temp = array[j];
                array[j] = array[index1];
                array[index1] = temp;
            }
            if (array[k] > pivot_1) {
                index2--;
                int temp = array[k];
                array[k] = array[index2];
                array[index2] = temp;
            }
            j++;
            k--;
        }
        int temp1 = array[low];
        array[low] = array[index2 - 1];
        array[index2 - 1] = temp1;
        partition[0] = index2 - 1;
        int temp2 = array[high];
        array[high] = array[index1 + 1];
        array[index1 + 1] = temp2;
        partition[1] = index1 + 1;
        // Here we return the elements about which we are partitioning.
        return partition;
    }

    // This is a function to print array.
    public static void PRINT(int[] array) {
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Random rand = new Random(); // This is to generate random numbers.
        int[] A = new int[30];
        //The following loop randomly allocates the value to 30 elements of array from -20 to 
        20
        for(int j = 0; j < A.length; j++) {
            A[j] = rand.nextInt(-20, 20);
        }
        PRINT(A);
        QUICKSORT(A, 0, A.length - 1);
        PRINT(A);
    }
}