package dfs;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Dfs_1 {
    static List<Integer>[] graph;
    static boolean[] ch;
    static int ans, n;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //1번 ~ n 번까지
        ans = 0;
        n = sc.nextInt();
        int m = sc.nextInt();
        graph = new List[n + 1];
        ch = new boolean[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
        }
        DFS(1);
        System.out.println(ans);
    }

    static void DFS(int v) {
        ch[v] = true;
        if (v == n) {
            ans++;
            return;
        } else {
            for (int nx : graph[v]) {
                if(!ch[nx]){
                    ch[nx] = true;
                    DFS(nx);
                    ch[nx] = false;
                }
            }
        }
    }
}
