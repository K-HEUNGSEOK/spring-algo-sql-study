package dfs;

import java.io.FileInputStream;
import java.util.Scanner;

public class Dfs_5 {
    static int[] arr, param;
    static boolean[] ch;
    static int n, m;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        m = sc.nextInt();
        param = new int[m];
        ch = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(0);
    }

    static void DFS(int v) {
        if (v == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(param[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (!ch[i]) {
                    ch[i] = true;
                    param[v] = arr[i];
                    DFS(v + 1);
                    ch[i] = false;
                }
            }
        }
    }
}
