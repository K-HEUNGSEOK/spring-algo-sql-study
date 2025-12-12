import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
 
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); //3
    int m = sc.nextInt(); //16
    boolean[] prime = new boolean[m + 1];

    prime[0] = true;
    prime[1] = true;

    for (int i = 2; i * i <= m; i++) {
      if (!prime[i]) {
        for (int j = i * i; j <= m; j += i) {
          prime[j] = true;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = n; i <= m; i++) {
      if (!prime[i]) {
        sb.append(i).append("\n");
      }
    }
    System.out.println(sb);
  }
}
