package dfs;

import java.io.FileInputStream;
import java.util.Scanner;

public class Dfs_3 {
    static int n, target, ans;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        target = sc.nextInt();
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ans = 0;

        DFS(0, 0);
        System.out.println(ans);
    }

    static void DFS(int v, int total) {
        if (total > target) {
            return;
        }
        if (v == n) {
            if (ans > total) {
                return;
            }
            ans = total;
            return;
        } else {
            DFS(v + 1, total + arr[v]);
            DFS(v + 1, total);
        }
    }
}
