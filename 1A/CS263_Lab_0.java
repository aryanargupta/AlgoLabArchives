// Question: Find the kth largest number in best possible time complexity.

import java.util.*;

public class kth_largest_heapmethod {

  public static void swap(int a[], int j, int k) {
    int temp = a[j];
    a[j] = a[k];
    a[k] = temp;
  }

  public static void printArray(int a[], int n) {
    for (int i = 0; i < n; i++) System.out.print(a[i] + " ");
    System.out.println();
  }

  public static void heapify(int a[], int n, int i) {
    int largest = i;
    int l = 2 * i;
    int r = 2 * i + 1;
    if (l <= n && a[l] > a[largest]) largest = l;
    if (r <= n && a[r] > a[largest]) largest = r;
    if (largest != i) {
      swap(a, i, largest);
      heapify(a, n, largest);
    }
  }

  public static void minheapify(int a[], int n, int i) {
    int smallest = i;
    int l = 2 * i;
    int r = 2 * i + 1;
    if (l <= n && a[l] < a[smallest]) smallest = l;
    if (r <= n && a[r] < a[smallest]) smallest = r;
    if (smallest != i) {
      swap(a, i, smallest);
      minheapify(a, n, smallest);
    }
  }

  public static void buildheap(int a[], int n) {
    for (int i = n / 2; i > 0; i--) {
      heapify(a, n, i);
    }
  }

  public static void buildminheap(int a[], int n) {
    for (int i = n / 2; i > 0; i--) {
      minheapify(a, n, i);
    }
  }

  public static int deleterootnode(int a[], int n) {
    int last = a[n - 1];
    a[0] = last;
    n--;
    heapify(a, n, 0);
    return n;
  }

  public static int deleteminrootnode(int a[], int n) {
    int last = a[n - 1];
    a[0] = last;
    n--;
    minheapify(a, n, 0);
    return n;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int a[] = { 0, 3, 6, 4, 1, 2, 7, 8, 9 };
    int n = a.length - 1;
    System.out.print("The present array: ");
    printArray(a, n);
    int num = n;
    int k = 7;
    if (k <= n / 2) {
      buildheap(a, n);
      while (k-- > 0) {
        n = deleterootnode(a, n);
      }
    } else {
      buildminheap(a, n);
      int s = n - k + 1;
      while (s-- > 0) {
        n = deleteminrootnode(a, n);
      }
      System.out.println(
        "The kth largest element where k = " + k + " is: " + a[0]
      );
    }
  }
}
