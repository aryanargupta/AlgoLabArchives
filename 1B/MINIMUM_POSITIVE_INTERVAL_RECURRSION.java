// Recursive Approach
// Time Complexity: O(n)

package PRACTICE_QUESTIONS;
public class MINIMUM_POSITIVE_INTERVAL_RECURRSION {

    public static int NEGATIVE_COUNTER(int[] array, int low, int high) {
        int cnt = 0;
        for(int i = low; i <= high; i++) {
            if(array[i] < 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public static int ARRAY_SUM(int[] array, int low, int high) {
        int sum = 0;
        for(int i = low; i <= high; i++) {
            sum = sum + array[i];
        }

        return sum;
    }
    public static int POSITIVE_INTERVAL(int[] array, int low, int high) {

        if(ARRAY_SUM(array, low, high) >= 0)
        return 1;

        if(NEGATIVE_COUNTER(array, low, high) == (high - low + 1))
        return 0;

        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = low; i <= high; i++) {
            if(min > array[i]) {
                min = array[i];
                index = i;
            }
        }

        return POSITIVE_INTERVAL(array, low, index - 1) + POSITIVE_INTERVAL(array, index + 1, high);


    }
    public static void main(String[] args) {
        int[] A = {1, -2, 3, -4, 10}; 
        System.out.println(POSITIVE_INTERVAL(A, 0, A.length - 1));
    }
}
