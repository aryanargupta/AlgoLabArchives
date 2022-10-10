// Question: Find the longest palindromic subsequence in a given string

import java.util.*;

public class CS263_Lab_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S_1 = sc.next();
        // here I have added 0 infront of string so that I can make 2 - d matrix
        String S1 = '0' + S_1;
        int n = S_1.length();
        int N = S1.length();
        String S_2 = "";
        for (int i = n - 1; i >= 0; i--) {
            S_2 = S_2 + S_1.charAt(i);
        }
        String S2 = "0";
        S2 = S2 + S_2;
        // here I have added 0 infront of string so that I can make 2 - d matrix
        // System.out.println(S1);
        // System.out.println(S2);
        int[][] A = new int[N][N];
        // This is for values
        char[][] B = new char[N][N];
        // This is for direction
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || j == 0) {
                    A[i][j] = 0;
                    B[i][j] = 'e';
                } else if (S2.charAt(i) == S1.charAt(j)) {
                    A[i][j] = 1 + A[i - 1][j - 1];
                    B[i][j] = 'd';
                } else {
                    A[i][j] = Math.max(A[i][j - 1], A[i - 1][j]);
                    if (A[i][j - 1] > A[i - 1][j]) {
                        B[i][j] = 'l';
                    } else {
                        B[i][j] = 'u';
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }
        int a = N - 1, b = N - 1;
        while (a > 0 && b > 0) {
            if (B[a][b] == 'd') {
                System.out.print(S1.charAt(b));
                a = a - 1;
                b = b - 1;
            } else if (B[a][b] == 'l') {
                b = b - 1;
            } else if (B[a][b] == 'u') {
                a = a - 1;
            }
        }
    }
}