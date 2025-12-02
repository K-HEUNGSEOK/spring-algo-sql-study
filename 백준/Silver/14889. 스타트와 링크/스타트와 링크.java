import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  static int n, ans;
  static int[][] arr;
  static boolean[] ch;
  static int totalA, totalB;

  public static void main(String[] args) throws IOException {
 
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    ans = Integer.MAX_VALUE;
    ch = new boolean[n];
    DFS(0, 0);
    System.out.println(ans);
  }

  static void DFS(int v, int start) {
    if (v == n / 2) {
      totalA = 0;
      totalB = 0;

      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          if (ch[i] && ch[j]) {
            totalA += arr[i][j];
            totalA += arr[j][i];
          } else if (!ch[i] && !ch[j]) {
            totalB += arr[i][j];
            totalB += arr[j][i];
          }
        }
      }

      int result = Math.abs(totalA - totalB);
      ans = Math.min(ans, result);

    } else {
      for (int i = start; i < n; i++) {
        if (!ch[i]) {
          ch[i] = true;
          DFS(v + 1, i + 1);
          ch[i] = false;
        }
      }
    }
  }
}
