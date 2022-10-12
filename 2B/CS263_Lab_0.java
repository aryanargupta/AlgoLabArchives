import java.util.*;

class CS263_Lab_0 {

  static void wiggleSort(int arr[]) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (i % 2 == 0 && arr[i] >= arr[i + 1]) {
        swap(arr, i, i + 1);
      } else if (i % 2 != 0 && arr[i] <= arr[i + 1]) {
        swap(arr, i, i + 1);
      }
    }
  }

  static void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  static void printArr(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scan.nextInt();
    }
    System.out.println("Array Before Sorting: ");
    printArr(arr);
    System.out.println("Array After Sorting: ");
    wiggleSort(arr);
    printArr(arr);
    scan.close();
  }
}
