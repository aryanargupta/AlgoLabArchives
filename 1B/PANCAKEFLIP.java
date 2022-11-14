package CS263_ASSIGNMENT;
import java.util.*;

public class PANCAKEFLIP {

    public static void PIRNT_ARRAY(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void ARRAY_REVERSE(int[] array, int k) {
        for(int i = 0; i <= k/2; i++) {
            int temp = array[i];
            array[i] = array[k - i];
            array[k - i] = temp;
        }
    }

    public static int ARRAY_MAXELEMENT(int[] array, int l) {
        int a = array[0];
        for(int i = 0; i < l; i++) {
            if(array[i] > a)
            a = array[i];
        }

        return a;
    }

    public static int ARRAY_MAXELEMENT_INDEX(int[] array, int l) {
        int a = ARRAY_MAXELEMENT(array, l);
        int index = 0;
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] == a) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void SOLVE(int[] array) {
        int cnt = array.length - 1;
        while(cnt >= 0) {
            int k = ARRAY_MAXELEMENT_INDEX(array, cnt + 1);
            ARRAY_REVERSE(array, k);
            ARRAY_REVERSE(array, cnt);
            cnt--;
            System.out.println(k);
            PIRNT_ARRAY(array);
            int x = SORTED(array);
            if(x == 1)
            break;
        }
    }

    public static int SORTED(int[] array) {
        int cnt = 0;
        for(int i = 0; i < array.length - 1; i++) {
            if(array[i + 1] >= array[i]) {
            cnt++;
            }
        }

        if(cnt == array.length - 1)
        return 1;

        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        SOLVE(A);
        sc.close();
    }
}
