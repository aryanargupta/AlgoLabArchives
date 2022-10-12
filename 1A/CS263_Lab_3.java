// Question: Calculate the number of local maxima in an array and print them by using divide and conquer.

import java.util.*;

public class CS263_3_1 {

  public static int count = 0;
  public static int c = 0;

  public static void recursion_min(int a[], int low, int high) {
    c++;
    if (low >= 0 && low <= high) {
      int mid = (low + high) / 2;
      if (mid >= 1 && a[mid] <= a[mid - 1] && a[mid] <= a[mid + 1]) {
        count++;
        return;
      }
      recursion_min(a, low, mid - 1);
      recursion_min(a, mid + 1, high);
    } else {
      return;
    }
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int a[] = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    recursion_min(a, 0, n - 1);
    System.out.println("count: " + count);
    System.out.println("recursion calls: " + c);
  }
}
