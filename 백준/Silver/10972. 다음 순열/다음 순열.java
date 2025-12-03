import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  static int[] arr;
  static int n;

  public static void main(String[] args) throws IOException {
   
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    StringBuilder sb = new StringBuilder();
    if (check()) {
      for (int i = 0; i < n; i++) {
        sb.append(arr[i]).append(" ");
      }
      System.out.println(sb.toString());
    } else {
      System.out.println(-1);
    }
  }

  static boolean check() {
    int i = n - 1;
    while (i > 0 && arr[i - 1] >= arr[i]) {
      i--;
    }
    if (i <= 0) {
      return false;
    }
    int j = n - 1;
    while (arr[i - 1] >= arr[j]) {
      j--;
    }
    swap(i - 1, j);

    j = n - 1;
    while (i < j) {
      swap(i, j);
      i++;
      j--;
    }
    return true;
  }

  static void swap(int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
