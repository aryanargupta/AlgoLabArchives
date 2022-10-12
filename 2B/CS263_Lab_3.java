import java.util.*;

class bitonicArr {

  static boolean checkBitonic(int arr[]) {
    int n = arr.length;
    ArrayList<Integer> i = new ArrayList<>();
    ArrayList<Integer> j = new ArrayList<>();
    for (int k = 0; k < n; k++) {
      int t = (k - 1) % n;
      int l = (k + 1) % n;
      if (t < 0) {
        t = t + n;
      }
      if (arr[t] < arr[k] && arr[k] > arr[l]) {
        i.add(k);
      }
    }
    for (int k = 0; k < n; k++) {
      int t = (k - 1) % n;
      int l = (k + 1) % n;
      if (t < 0) {
        t = t + n;
      }
      if (arr[t] > arr[k] && arr[k] < arr[l]) {
        j.add(k);
      }
    }
    if (i.size() == 1 && j.size() == 1) return true; else return false;
  }

  static int binSearch(int arr[], int low, int high) {
    if (low <= high) {
      int mid = (low + high) / 2;
      int l = (mid - 1) % arr.length;
      int t = (mid + 1) % arr.length;

      if (l < 0) l += arr.length;
      if (arr[mid] > arr[t] && arr[l] > arr[mid]) {
        low = mid + 1;
        return binSearch(arr, mid + 1, high);
      }
      if (arr[l] > arr[mid] && arr[t] > arr[mid]) {
        return mid;
      }
      if (arr[t] > arr[mid] && arr[l] < arr[mid]) {
        return binSearch(arr, low, mid - 1);
      }
      if (arr[t] < arr[mid] && arr[l] < arr[mid]) {
        if (arr[l] < arr[t]) {
          return binSearch(arr, low, mid - 1);
        } else {
          return binSearch(arr, mid + 1, high);
        }
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4, 5, 6 };
    //Other Cases
    // int arr[]={10,9,8,11,12,13};
    // int arr[]={1,2,3,4,9,8,7,6,5};
    // int arr[] = {4,6,9,8,7,5,1,2,3};
    // int arr[]={3,6,9,8,7,5,1,2,4};
    if (checkBitonic(arr)) {
      System.out.println("True");
    } else {
      System.out.println("False");
    }
    if (checkBitonic(arr)) {
      System.out.println(binSearch(arr, 0, arr.length));
    } else {
      System.out.println("Wrong");
    }
  }
}
