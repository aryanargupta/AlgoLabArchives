package CS263_ASSIGNMENT;
import java.util.*;
public class BELLMAN_FORD_ALGORITHM {
    public static void RELAX(int u, int v, int[] distance, int[] precedance, int[][] weight) {
        if(distance[v] > (distance[u] + weight[u][v])) {
            distance[v] = distance[u] + weight[u][v];
            precedance[v] = u;
        }
    }

    public static int NEGATIVE_CYCLE(int u, int v, int[] distance, int[] precedance, int[][] weight) {
        RELAX(u, v, distance, precedance, weight);
        return 1;
    }

    public static void PRINT(int[][] array, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int n = sc.nextInt();
        int[][] Adjcency_matrix = new int[n][n];
        int[][] Weight = new int[n][n];
        System.out.println("Enter 1 if edge exist or else zero: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                Adjcency_matrix[i][j] = sc.nextInt();
            }
        }
        PRINT(Adjcency_matrix, n);
        System.out.println("Enter the weight if edge exist or else zero: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                Weight[i][j] = sc.nextInt();
            }
        }
        PRINT(Weight, n);
        int[] Distance = new int[n];
        for(int i = 0; i < n; i++) {
            Distance[i] = 5000;
        }
        int[] Precedence = new int[n];
        for(int i = 0; i < n; i++) {
            Precedence[i] = -1;
        }
        Distance[0] = 0;
        int b = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(Adjcency_matrix[j][k] == 1) {
                        RELAX(j, k, Distance, Precedence, Weight);
                        b = NEGATIVE_CYCLE(j, k, Distance, Precedence, Weight);

                    }
                }
            }
        }
        if(b == 1) {
            System.out.println("Negative cycle is present");
        }
        for(int i = 0; i < n; i++) {
            System.out.print(Distance[i]+" ");
        }
        System.out.println();
    }
}
