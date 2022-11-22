// Question:
// There is a car starting from initial station marked as zero with full fuel tank, the distance a full capacity of fuel tank can cover is given,
// Distance mark of every fuel station is also given. You can fill the tank full in the fuel stations.
// You have to calculate if it will reach the end point before running out of fuel in minimum stoppages in the route.

import java.io.*;
import java.lang.*;
import java.util.*;

class CS263_Lab_5 {

  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int k = 10; //Capacity of fuel tank
    int n = 10; //No. of fuel stations
    int arr[] = { 0, 7, 12, 15, 23, 32, 35, 42, 48, 50 };
    int diff[] = new int[n - 1];
    for (int i = 0; i < n - 1; i++) {
      diff[i] = arr[i + 1] - arr[i]; //difference array
      if (diff[i] > k) { //difference is greater than capacity
        System.out.println("Not possible to reach destination");
        System.exit(0);
      }
    }
    int c = 0;
    int temp = 0;
    System.out.print("Petrol will be filled in following station : ");
    for (int i = 0; i < n - 2; i++) {
      temp = temp + diff[i];
      if (temp + diff[i + 1] > k) {
        c++;
        System.out.print(arr[i + 1] + " ");
        temp = 0;
      }
    }
    System.out.println();
    System.out.println("Minimum no. of stations where petrol filled : " + c);
  }
}
