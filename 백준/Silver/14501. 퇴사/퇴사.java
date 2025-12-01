import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  static int ans, n;
  static Plan[] arr;

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    arr = new Plan[n];
    for (int i = 0; i < n; i++) {
      int day = sc.nextInt();
      int money = sc.nextInt();
      arr[i] = new Plan(day, money);
    }
    ans = 0;
    DFS(0, 0);
    System.out.println(ans);
  }

  static void DFS(int dayTotal, int sum) {
    if (dayTotal > n) {
      return;
    }
    if (dayTotal == n) {
      ans = Math.max(ans, sum);
      return;
    } else {
      DFS(dayTotal + 1, sum);
      if (dayTotal + arr[dayTotal].day <= n) {
        DFS(dayTotal + arr[dayTotal].day, sum + arr[dayTotal].money);
      }
    }

  }

  static class Plan {

    int day, money;

    public Plan(int day, int money) {
      this.day = day;
      this.money = money;
    }
  }
}