// Question: Find no. of inversion pairs in an array.

import java.util.*;

public class CS263_Lab_2 {
    int findInvPairs(int arr[], int l, int h) {
        if (l < h) {
            // l<h means it will keep dividing only till two elements are left
            int mid = l + (h - l) / 2;
            int a = findInvPairs(arr, l, mid);
            int b = findInvPairs(arr, mid + 1, h);
            // after getting answer for divided parts of array,we also have to find the
            // answer after combining it
            int c = findCombinedPairs(arr, l, mid, h);
            return a + b + c;
        }
        // zero will be returned as soon as l>=h occurs as in question
        // i<j is a constraint
        return 0;
    }

    private int findCombinedPairs(int[] arr, int l, int mid, int h) {
        int count = 0;
        // while combining , we only have to compare the mid+1 to h subarray with l
        // to mid array and increment the count variable if arr[i]>arr[j]
        for (int j = mid + 1; j <= h; j++) {
            for (int i = l; i <= mid; i++) {
                if (arr[i] > arr[j])
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int j = 0; j < n; j++)
            arr[j] = sc.nextInt();
        CS263_Lab_2 obj = new CS263_Lab_2();
        System.out.println("Inversion pairs: " + obj.findInvPairs(arr, 0, arr.length - 1));

    }
}