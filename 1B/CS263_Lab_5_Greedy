// Greedy Approach
// Time Complexity: O(n^2)

package CS263_ASSIGNMENT;
import java.util.*;
import java.util.ArrayList;

public class CS263_Lab_5_greedy {
    public static int POSITIVE_INTERVAL(int[] array) {
        int l = array.length; //length of given array
        ArrayList<Integer> index = new ArrayList<>(); 
        // arraylist to store the index of positive elements in array
        for(int i = 0; i < l; i++) {
            if(array[i] >= 0) {
                index.add(i);
            }
        }
        // Here I have made use of two pointers starting from initial positive element.
        // The two pointers will check the sum of all the elements between them until it is positive.
        // When sum becomes negative count increases and pointer shifts.
        // At last I print total count. 
        int m = index.size();
        int x = 0, y = 0, count = 0;
        while(x < m && y < m) {
            int sum = 0;
            for(int i = index.get(x); i <= index.get(y); i++) {
                sum = sum + array[i];
            }

            if(sum >= 0) {
                y++;
                if(y == m && sum >= 0)
                count++;
            }
            else {
                count++;
                x = y;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] A = new int[n];
        System.out.println("Enter the elements: ");
        for(int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println("The minimum number of positive intervals are: "+POSITIVE_INTERVAL(A));
        sc.close();
    }
}
