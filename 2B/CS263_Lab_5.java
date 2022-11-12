// Question: Smallest Job FIrst
// Approach: Segment Trees
// Source of Code: GFG

import java.util.*;

class CS263_Lab_5 {

  static int z = 1000000007;
  static int sh = 100000;

  static class util {

    // Process ID
    int id;
    // Arrival time
    int at;
    // Burst time
    int bt;
    // Completion time
    int ct;
    // Turnaround time
    int tat;
    // Waiting time
    int wt;
  }

  // Array to store all the process information
  // by implementing the above struct util
  static util[] ar = new util[sh + 1];

  static {
    for (int i = 0; i < sh + 1; i++) {
      ar[i] = new util();
    }
  }

  static class util1 {

    // Process id
    int p_id;
    // burst time
    int bt1;
  }

  static util1 range = new util1();

  // Segment tree array to
  // process the queries in nlogn
  static util1[] tr = new util1[4 * sh + 5];

  static {
    for (int i = 0; i < 4 * sh + 5; i++) {
      tr[i] = new util1();
    }
  }

  // To keep an account of where
  // a particular process_id is
  // in the segment tree base array
  static int[] mp = new int[sh + 1];

  // Comparator function to sort the
  // struct array according to arrival time

  // Function to update the burst time and process id
  // in the segment tree
  static void update(int node, int st, int end, int ind, int id1, int b_t) {
    if (st == end) {
      tr[node].p_id = id1;
      tr[node].bt1 = b_t;
      return;
    }
    int mid = (st + end) / 2;
    if (ind <= mid) update(2 * node, st, mid, ind, id1, b_t); else update(
      2 * node + 1,
      mid + 1,
      end,
      ind,
      id1,
      b_t
    );
    if (tr[2 * node].bt1 < tr[2 * node + 1].bt1) {
      tr[node].bt1 = tr[2 * node].bt1;
      tr[node].p_id = tr[2 * node].p_id;
    } else {
      tr[node].bt1 = tr[2 * node + 1].bt1;
      tr[node].p_id = tr[2 * node + 1].p_id;
    }
  }

  // Function to return the range minimum of the burst time
  // of all the arrived processes using segment tree
  static util1 query(int node, int st, int end, int lt, int rt) {
    if (end < lt || st > rt) return range;
    if (st >= lt && end <= rt) return tr[node];
    int mid = (st + end) / 2;
    util1 lm = query(2 * node, st, mid, lt, rt);
    util1 rm = query(2 * node + 1, mid + 1, end, lt, rt);
    if (lm.bt1 < rm.bt1) return lm;
    return rm;
  }

  // Function to perform non_preemptive
  // shortest job first and return the
  // completion time, turn around time and
  // waiting time for the given processes
  static void non_preemptive_sjf(int n) {
    // To store the number of processes
    // that have been completed
    int counter = n;

    // To keep an account of the number
    // of processes that have been arrived
    int upper_range = 0;

    // Current running time
    int tm = Math.min(Integer.MAX_VALUE, ar[upper_range + 1].at);

    // To find the list of processes whose arrival time
    // is less than or equal to the current time
    while (counter != 0) {
      for (; upper_range <= n;) {
        upper_range++;
        if (ar[upper_range].at > tm || upper_range > n) {
          upper_range--;
          break;
        }

        update(1, 1, n, upper_range, ar[upper_range].id, ar[upper_range].bt);
      }

      // To find the minimum of all the running times
      // from the set of processes whose arrival time is
      // less than or equal to the current time
      util1 res = query(1, 1, n, 1, upper_range);

      // Checking if the process has already been executed
      if (res.bt1 != Integer.MAX_VALUE) {
        counter--;
        int index = mp[res.p_id];
        tm += (res.bt1);

        // Calculating and updating the array with
        // the current time, turn around time and waiting time
        ar[index].ct = tm;
        ar[index].tat = ar[index].ct - ar[index].at;
        ar[index].wt = ar[index].tat - ar[index].bt;

        // Update the process burst time with
        // infinity when the process is executed
        update(1, 1, n, index, Integer.MAX_VALUE, Integer.MAX_VALUE);
      } else {
        tm = ar[upper_range + 1].at;
      }
    }
  }

  // Function to call the functions and perform
  // shortest job first operation
  static void execute(int n) {
    // Sort the array based on the arrival times
    Arrays.sort(
      ar,
      1,
      n,
      new Comparator<util>() {
        public int compare(util a, util b) {
          if (a.at == b.at) return a.id - b.id;
          return a.at - b.at;
        }
      }
    );
    for (int i = 1; i <= n; i++) mp[ar[i].id] = i;

    // Calling the function to perform
    // non-preemptive-sjf
    non_preemptive_sjf(n);
  }

  // Function to print the required values after
  // performing shortest job first
  static void print(int n) {
    System.out.println(
      "ProcessId Arrival Time Burst Time" +
      " Completion Time Turn Around Time Waiting Time"
    );
    for (int i = 1; i <= n; i++) {
      System.out.printf(
        "%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n",
        ar[i].id,
        ar[i].at,
        ar[i].bt,
        ar[i].ct,
        ar[i].tat,
        ar[i].wt
      );
    }
  }

  // Driver Code
  public static void main(String[] args) {
    // Number of processes
    int n = 5;

    // Initializing the process id
    // and burst time
    range.p_id = Integer.MAX_VALUE;
    range.bt1 = Integer.MAX_VALUE;

    for (int i = 1; i <= 4 * sh + 1; i++) {
      tr[i].p_id = Integer.MAX_VALUE;
      tr[i].bt1 = Integer.MAX_VALUE;
    }

    // Arrival time, Burst time and ID
    // of the processes on which SJF needs
    // to be performed
    ar[1].at = 1;
    ar[1].bt = 7;
    ar[1].id = 1;

    ar[2].at = 2;
    ar[2].bt = 5;
    ar[2].id = 2;

    ar[3].at = 3;
    ar[3].bt = 1;
    ar[3].id = 3;

    ar[4].at = 4;
    ar[4].bt = 2;
    ar[4].id = 4;

    ar[5].at = 5;
    ar[5].bt = 8;
    ar[5].id = 5;

    execute(n);

    // Print the calculated time
    print(n);
  }
}
// This code is contributed by
// sanjeev2552
