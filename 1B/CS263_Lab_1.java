import java.util.*;

public class CS263_Lab_1 {

    public static int FREQUENCY(int[] array, int low, int high, int key) {
        int size = array.length;
        if (size == 0) return 0;
        if (low >= high) 
        {
            if (key == array[low]) return 1; else return 0;
        }
        int mid = low + (high - low) / 2;
        int left = FREQUENCY(array, low, mid, key);
        int right = FREQUENCY(array, mid + 1, high, key);
        return left + right;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] A = new int[100];
        for (int i = 0; i < 100; i++) {
            A[i] = rand.nextInt(1, 20);
        }
        int a = rand.nextInt(1, 20);
        for (int i = 0; i < 100; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
        int count = FREQUENCY(A, 0, 99, a);
        System.out.println("The number " + a + " has frequency " + count + " in the array");
    }
}
