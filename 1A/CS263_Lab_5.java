/*
 * Question:
 * 
 *  For a given n, find the total number of operations required to reach n in minimum steps such that,
 *  starting form 1, at any point,
 * 
 *       increment(x = x+1)
 *      /
 *     x
 *      \
 *       double(x = x*2)
 *       
 *       Here, x goes from 1 to n
 *   
 * Approach:
 * 
 *  The approach is to use the constraint of 'n', and go in reverse. So, for reverse, the operations
 *  become,
 *  
 *       decrement(x = x-1)
 *      /
 *     x
 *      \
 *       double(x = x/2)
 *       
 *       Here n goes from n to 1
 *       
 *  Now, we will decrement when x is odd (or when x%2!=0), and divide by 2 when x is even (or when x%2=0)
 *  
 *  Using, this Greedy Approach, we will be able to solve this problem with Time Complexity = O(log(n) [base 2])
 *  
 */

import java.util.*;

public class CS263_Lab_5 {
	
	// Logic Implementation Function
	
	public static void func(int n) {
		ArrayList<Integer> al = new ArrayList<>();
		int num = n;
		int count=0;
		
		while(n!=1) {
			
			if(n%2==0) // Check parity (even/odd) of the number
				n/=2;
			else
				n--;
			
			count++;  // Counting number of steps
			
			al.add(n);  // Storing for printing in future
		}
		
		for(int i=al.size()-1;i>=0;i--) {
			System.out.print(al.get(i)+"->");
		}
		System.out.println(num);
		System.out.println("----------");
		System.out.println("Count: "+count);
		System.out.println("----------");
	}
	
	
	// Driver Function/Method:
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		func(n);
	}
}
