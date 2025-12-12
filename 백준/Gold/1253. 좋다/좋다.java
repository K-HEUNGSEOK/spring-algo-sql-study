import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int cnt = 0;
    Arrays.sort(arr);
    for (int i = 0; i < n; i++) {
      int findNumber = arr[i];

      int lt = 0;
      int rt = n - 1;
      while (lt < rt) {
        long sum = arr[lt] + arr[rt];
        if (sum == findNumber) {
          if (lt == i) {
            lt++;
          } else if (rt == i) {
            rt--;
          } else {
            cnt++;
            break;
          }
        } else if (sum > findNumber) {
          rt--;
        } else {
          lt++;
        }
      }
    }
    System.out.println(cnt);
  }
}
