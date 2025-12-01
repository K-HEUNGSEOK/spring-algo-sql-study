import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

  static boolean[] ch = new boolean[10];
  static List<String> list = new ArrayList<>();
  static int n;
  static char[] arr;

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    arr = new char[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.next().charAt(0);
    }
    //부등호에 맞게 넣어보고 빼보고 넣어보고 빼보고 해야하는데
    DFS(0, "");
    Collections.sort(list);
    System.out.println(list.get(list.size() - 1));
    System.out.println(list.get(0));
  }

  // 0 < 1 >
  static void DFS(int depth, String str) {
    if (depth == n + 1) {
      list.add(str);
      return;
    } else {
      for (int i = 0; i <= 9; i++) {
        if (!ch[i]) {
          if (depth == 0 || check(str.charAt(depth - 1) - '0', i, arr[depth - 1])) {
            ch[i] = true;
            DFS(depth + 1, str + i);
            ch[i] = false;
          }
        }
      }
    }
  }

  static boolean check(int prev, int now, char c) {
    if (c == '<') {
      return prev < now;
    }
    if (c == '>') {
      return prev > now;
    }
    return false;
  }
}