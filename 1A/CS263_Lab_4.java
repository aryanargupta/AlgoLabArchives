// Question: Print all subsets from a given array of size n, whose sum is exactly equal to a given target sum k.

import java.util.*;

public class CS263_Lab_4 {
	// Main Function

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int n = in.nextInt(); // given size of array
		System.out.println("Enter the array elements one by one");
		int a[] = new int[n]; // given array
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		System.out.println("Now, enter the target sum");
		int k = in.nextInt(); // target sum
		subsetsum(a, n, k);
		System.out.println("\nTherefore, total number of possible subsets with sum " + k + " is " + (subsetcount - 1));
		System.out.println("\nThe DP looks like this:");
		System.out.print("     ");
		for (int i = 0; i <= k; i++) {
			System.out.print(i + " ");
		}
		System.out.println("\n----------------------------");
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " -> ");
			for (int j = 0; j < k + 1; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int dp[][]; // Declaring a global 2D dp for computation

	public static int subsetcount = 1; // Declaring and initializing subsetcount to 1

	static void subsetsum(int a[], int n, int k) // The function where the 2D dp will be filled
	{
		if (n == 0 || k < 0) // Base condition for n=0 or sum<0
			return;

		dp = new int[n][k + 1]; // Initializing the globally declared 2D dp
		for (int i = 0; i < n; ++i) {
			dp[i][0] = 1; // Filling the 0th column with 1's
		}

		if (a[0] <= k)
			dp[0][a[0]] = 1; // Checking first element is less than the required sum

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < k + 1; j++) {
				if (a[i] <= j) // If current sum (j) is greater than element at ith position
				{
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - a[i]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		if (dp[n - 1][k] == 0) // If the final bottmost right cell contains 0 value that means no possible
								// subset is there
		{
			System.out.println("There are no subsets with" + " sum " + k + "hence, ");
			return;
		}

		String path = " "; // Declaring a string 'path' and initializing it for appending the path
		printpaths(a, n - 1, k, path);
	}

	static void printpaths(int a[], int i, int k, String path) // Function to print each path separately by appending
																// "Path" strings
	{
		if (i == 0 && k != 0 && dp[0][k] == 1) {
			path += a[i];
			path += " ";
			System.out.println("Path " + (subsetcount++) + ": {" + path + "}");
			return;
		}

		if (i == 0 && k == 0) {
			System.out.println("Path " + (subsetcount++) + ": {" + path + "}");
			path = "";
			return;
		}

		if (dp[i - 1][k] == 1) {
			String b = path;
			printpaths(a, i - 1, k, b);
		}

		if (k >= a[i] && dp[i - 1][k - a[i]] == 1) {
			path += a[i];
			path += " ";
			printpaths(a, i - 1, k - a[i], path);
		}
	}
}
