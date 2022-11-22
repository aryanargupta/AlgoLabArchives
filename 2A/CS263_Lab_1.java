// Question: In this problem, a set of N points are given on the 2D plane. You have to find
// the minimum distance pair of points.
// For example:- P[] = {2, 3}, {12, 30}, {40, 50}, {5, 1}, {12, 10}, {3, 4}.
// Minimum distance is 1.41 between pairs of points {2, 3} and {3, 4}.
// Write a program divide and conquer algorithm with probable complexity order. Write your logic
// as comments in the program for its better understanding and evaluation.

import java.util.*;
import java.util.Scanner;

class point {

  // point class to store coordinates
  int x, y;

  // constructor to initialize the coordinate
  public point(int a, int b) {
    this.x = a;
    this.y = b;
  }
}

public class CS263_Lab_1 {

  public double md(point[] p, int n) {
    //function to find minimum distance
    double dist = 999999999999999999999999.0d; //upper bound of distance
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        /*Applying distance formulae*/
        double dl = Math.sqrt(
          Math.pow((p[i].x - p[j].x), 2) + Math.pow((p[i].y - p[j].y), 2)
        );
        if (dl < dist) dist = dl;
        /*update the distance if we find something smaller than existing value*/
      }
    }
    return dist;
  }

  public static void main(String[] args) {
    CS263_Lab_1 obj = new CS263_Lab_1();

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the total points");
    int n = sc.nextInt();
    /* array of n points */
    point[] p = new point[n];
    for (int i = 0; i < n; i++) {
      // taking input of points
      System.out.println("Coordinate " + (i + 1));
      System.out.print("x: ");
      int a = sc.nextInt();
      System.out.print("y: ");
      int b = sc.nextInt();
      p[i] = new point(a, b);
    }

    System.out.println("Minimum distance: " + obj.md(p, n)); // calling md function
  }
}
// NOTE: The above-mentioned code is the brute force approach of the
// problem which is done in O(n^2) time complexity.
// This can also be done using the divide and conquer approach where
// we can divide the points into two planes i.e. vertical and horizontal
// plane. Time complexity: O(nlogn).We will use divide in such a way
// that we are left with one point in vertical plane and one point in
// horizontal the distance between these two points is minimum.
