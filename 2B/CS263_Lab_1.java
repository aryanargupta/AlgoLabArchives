import java.util.Scanner;
public class Lab2 {
    static int freq(int arr[],int l, int r, int x){//returns the frequency of the number
        if(l>r || l == r && arr[l] != x)return 0;
        if(l==r && arr[l]==x)
            return 1;
        else
        return freq(arr,l,(l+r)/2,x) + freq(arr,1+(l+r)/2,r,x);
    }
    static int findMajority(int arr[]){
        int mid = arr.length/2;
        for(int i=0;i<arr.length/2;i++){
            if(freq(arr,0,arr.length-1,arr[i])>=mid){
                return arr[i];//herewe find the frequency of the element
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();//taking input array
        }
        
        System.out.println(findMajority(arr)); ;
        scan.close();
    }
}


