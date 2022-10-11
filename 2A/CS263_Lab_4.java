// Question: Given a matrix find the maximum path sum in matrix, 
// where you are allowed to move only down or right. 
// You can start from any element in the matrix 
// but the ending point should be the bottom-right element of the matrix.

import java.util.*;
public class CS263_Lab_4
{
 
    //state => dp[i][j]=max sum possible for given rules for ending point i,j
    //transition => dp[i][j]=arr[i][j]+Math.max(sum(arr, i-1, j, dp),sum(arr, i, j-1, dp))
    static int sum(int arr[][],int i,int j,int dp[][])
    {
        if(i<0 || j<0)
        return 0;
        if(dp[i][j]!=0)     //if we have already computed for this iteration
        return dp[i][j];
        else{
           
            return dp[i][j]=arr[i][j]+Math.max(sum(arr, i-1, j, dp),sum(arr, i, j-1, dp));
        }
    }
    public static void main(String[] args) {
       
       
        int[][] arr={{-1,7,-2,10,-5},{8,-4,3,-6,0},{5,1,5,6,-5},{-7,-4,1,-4,8},{7,1,-9,4,0}};  
        int n=arr.length;
        int dp[][]=new int[n][n];       //dp array
             
        System.out.println(sum(arr, n-1, n-1, dp));
       
    }
}
