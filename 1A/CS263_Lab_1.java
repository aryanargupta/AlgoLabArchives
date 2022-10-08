// Code for the variation of an unbalanced mergesort, wwhere at each step, the array is partitioned into 2 unequal sub-arrays,
// of lengths n/3 and 2n/3. Thus the recurrence relation for this is: T(n) = T(n/3) + T(2n/3) + n,
// and the final time complexity comes out to be T(n) = O(n log n) where base of log is (3/2).

import java.util.*; // Importing the utilities package for random array generation and input/output.

public class CS263_Lab_2 {
	
	// Main Function
	public static void main(String args[]) 
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter 1 for manual input else any other key for random array generation: ");
		String s = in.next();
		System.out.println("\n-----------------------------------------------------------------------------");
		
		if(s.equals("1")) // Manual input
		{
			System.out.print("\nEnter the number of elements in the array: ");
			int n = in.nextInt();
			System.out.println("\nEnter the elements one by one: ");
			int a[] = new int[n];
			
			for(int i=0;i<n;i++) 
			{
				a[i]=in.nextInt();
			}
			
			System.out.println("\nOriginal array:");
			printarray(a,n);
			
			
			long start,end;
			start = System.nanoTime();
			modifiedmsort(a,0,n-1); // Calling Modified Merge Sort Function
			end = System.nanoTime();
			
			
			System.out.println("\n\nFinal array:");
			printarray(a,n);
			System.out.println("\n\nTime: "+(end-start)); // Printing time elapsed
		}
		else // Random Array Generator 
		{
			System.out.print("Enter number of elements for the array: ");
			int n = in.nextInt();
			int a[] = new int[n];
			int b[] = new int[n]; // For preserving original array for comparing to Arrays.sort later
			
			Random ran = new Random();
			for(int i=0;i<n;i++)
			{
				a[i] = 1+ran.nextInt(100); // Generating array elements in range 1 to 100
				b[i] = a[i];
			}
			
			System.out.println("\nOriginal array:");
			printarray(a,n);
			
			
			long start,end;
			start = System.nanoTime();
			modifiedmsort(a,0,n-1); // Calling Modified Merge Sort Function
			end = System.nanoTime();
			
			System.out.println("\n\nFinal array by Modified Merge Sort:");
			printarray(a,n);
			
			
			long start1,end1;
			start1=System.nanoTime();
			Arrays.sort(b);
			end1 = System.nanoTime();
			
			System.out.println("\n\nFinal array by Arrays.sort() function:");
			printarray(b,n);
			
			
			if(areEqual(a,b)) // Checking if the arrays are equal or not
			System.out.println("\n\nThe arrays are equal!");
			else
			System.out.println("\n\nThe arrays are not equal!");
			
			System.out.println("\nTime for modified merge sort: "+(end-start)); // Time elapsed for modifiedmsort
			System.out.println("Time for Arrays.sort() function: "+(end1-start1)); // Time elapsed for Arrays.sort(a)
			
			
			System.out.println("\nNote: for smaller size, time for calling Arrays.sort() is significant enough, but for sizes greater than 5000, Arrays.sort() is overall faster");
		}
	}
	
	
	// Modified Merge Sort Function
	public static void modifiedmsort(int a[], int left, int right) 
	{
		if(left<right) // Condition to check array at least of size 2
		{
			int div = left + (right-left)/3; // The modified partition statement
			
			modifiedmsort(a,left,div);
			modifiedmsort(a,div+1,right);
			
			merge(a,left,div,right);
		}
	}
	
	
	// Merge function (No differences compared to Merge function of standard MergeSort program)
	public static void merge(int a[], int left, int div, int right) 
	{
		int i=left;
		int j=div+1;
		int k=left;
		int temp[] = new int[a.length]; // Temporary array to merge the elements and later copy to original array
		while(i<=div && j<=right) // While loop to compare elements of left and right subarrays and merge them in order
		{
			if(a[i]<a[j]) 
			{
				temp[k]=a[i];
				i++; k++;
			} 
			else 
			{
				temp[k]=a[j];
				j++; k++;
			}
		}
		if(i>div) // If elements in the left subarray are left 
		{
			while(j<=right) 
			{
				temp[k]=a[j];
				k++; j++;
			}
		}
		else // If elements in the right subarray are left
		{
			while(i<=div) 
			{
				temp[k]=a[i];
				i++; k++;
			}
		}
		
		for(k=left;k<=right;k++) {
			a[k]=temp[k]; // Finally copying back to the original array a
		}
	}
	
	
	// Print Array Function to print the array at any point of time
	public static void printarray(int a[], int n) 
	{
		for(int i=0;i<n;i++) 
		{
			System.out.print(a[i]+" ");
		}
	}
	
	// Method to check if both of the arrays are equal or not
	public static boolean areEqual(int a[], int b[]) {
		if(a.length!=b.length)
			return false;
		for(int i=0;i<a.length;i++) {
			if(a[i]!=b[i])
				return false;
		}
		return true;
	}
	
}