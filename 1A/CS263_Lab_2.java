// Code for the stoogesort, where at each step, where an array is recursively sorted for first 2/3rd part, 
// the last 2/3rd part, and again the first 2/3rd part, per recursive call.
// The time complexity of this sorting algorithm is approximately n^2.71

import java.util.*;  // Importing the utilities package for random array generation and input/output.

public class CS263_Lab_3 {
	
	public static int count=0; // Global Count variable to find the number of recursive calls
	
	
	// stoogesort function
	
	public static void stoogesort(int a[], int low, int high) {
		
		if(low+1>high)
		{
			return;  // return if low exceeds or equals high
		}
		
		
		if(a[high]<a[low])
			swap(a,high,low);  // swap a[low] and a[high] if they aren't in order
		
		
		if(high-low>1) {
			int partition1 = (high-low+1)/3;  // finding 1/3rd length of the present subarray
			int partition2 = high-partition1;  // this is the 2/3rd ceil index of the present subarray
			
			stoogesort(a,low,partition2);  // Calling for the first 2/3rd part
			stoogesort(a,low+partition1,high); // Calling for the last 2/3rd part
			stoogesort(a,low,partition2); // Calling for the first 2/3rd part again
			count+=3;
		}
	}
	
	
	
	
	// Swap function to swap values in an array
	
	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	
	
	// Function to check if the sorting is correct
	
	public static boolean areEqual(int a[], int b[]) {
		if(a.length!=b.length)
			return false;
		for(int i=0;i<a.length;i++) {
			if(a[i]!=b[i])
				return false;
		}
		return true;
	}
	
	
	
	// Function to print the array
	
	public static void printarray(int a[], int n) {
		for(int i=0;i<n;i++)
			System.out.print(a[i]+ " ");
		System.out.println();
	}
	
	
	
	
	
	// Main/Driver Function (For formatting and array building/input and printing outputs
	
	public static void main(String args[]) {
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
			stoogesort(a,0,n-1); // Calling Modified Merge Sort Function
			end = System.nanoTime();
			
			
			System.out.println("\n\nFinal array:");
			printarray(a,n);
			System.out.println("\n\nTime: "+(end-start)); // Printing time elapsed
			
			System.out.println("\nThe total number of recursive calls excluding the base call is: "+count);
			System.out.print("Now, since n="+a.length);
			System.out.println(", log of "+count+" to the base "+a.length+" is = "+(Math.log(count)/Math.log(a.length)));
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
			stoogesort(a,0,n-1); // Calling Modified Merge Sort Function
			end = System.nanoTime();
			
			System.out.println("\n\nFinal array by Stooge Sort:");
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
			
			System.out.println("\nTime for Stooge Sort: "+(end-start)); // Time elapsed for modifiedmsort
			System.out.println("Time for Arrays.sort() function: "+(end1-start1)); // Time elapsed for Arrays.sort(a)
			
			System.out.println("\n\nThe total number of recursive calls excluding the base call is: "+count);
			System.out.print("Now, since n="+a.length);
			System.out.println(", log of "+count+" to the base "+a.length+" is = "+(Math.log(count)/Math.log(a.length)));
		}
	}
}
