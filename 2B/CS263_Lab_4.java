import java.util.Scanner;

class solution {

  static int maximizeProfit(int arr[], int k, int s, int ind) {
    if (ind == arr.length) {
      return s; //After checking with all animals the profit will be the answer
    }
    if (arr[ind] == k) return maximizeProfit(arr, k, s + 1, ind + 1); //if same candy encountered then sum is incremented
    int exchange = maximizeProfit(arr, arr[ind], s - 1, ind + 1); //if candy exchanged then sum is decremented
    int notExchange = maximizeProfit(arr, k, s, ind + 1); //if candy is not sexhanged then no chaangesto sum
    return Math.max(exchange, notExchange); //maximum of the exchange and notExchanged will be returned
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the size of the array: ");
    int n = scan.nextInt();
    int arr[] = new int[n];
    System.out.println("Enter the array of candy numbers: ");
    for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
    System.out.print("Enter the initial candy number: ");
    int k = scan.nextInt();
    int s = 0;
    System.out.print("Maximum score obtained is: ");
    System.out.println(maximizeProfit(arr, k, s, 0));
    scan.close();
  }
}
// Since we are exploring all branches of the recurssion tree the time complexity of the code is O(2^n)
