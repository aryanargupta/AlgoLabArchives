import java.util.Scanner;

public class solution {

  static long function(long n) {
    return n * (n + 1) * (2 * n + 1) / 6; //returns the sum of squares of fist N natural numbers
  }

  static long binSearch(long s, long low, long high) {
    if (low <= high) {
      long mid = (high + low) / 2;
      if (function(mid) <= s) {
        if (function(mid + 1) > s) { //if the sum of squares is equal to strength of killer then the answer is mid
          return mid;
        } else { //it might be the case that there are few more people that the killer can kill which is to the right of mid
          return binSearch(s, mid, high);
        }
      } else if (function(mid) > s) { //if the sum of squares upto mid is greater than mid then people killed will be left of mid
        if (function(mid - 1) <= s) {
          return mid - 1; //if the person just left of mid satisfies that sum of squares upto that mid-1 is less or equal then mid-1 will be the answer
        } else return binSearch(s, low, mid);
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the strength of the killer: ");
    long s = sc.nextLong();
    System.out.print("Max people he can kill is: ");
    System.out.println(binSearch(s, 1, 100000));
    sc.close();
  }
}
// the time complexity will be O(log(n)) as the above code is implented just like binary Search which has time complexity of O(log(n))
//
