package bfs;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs_5 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] ch;
    static int n, ans;
    static int[][] dist;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = 7;
        ans = -1;
        ch = new boolean[n][n];
        arr = new int[n][n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        //1은 벽 , 0 은통로
        ch[0][0] = true;
        BFS(0, 0);
        if(dist[n-1][n-1] != 0) {
            System.out.println(dist[n - 1][n - 1]);
        }else{
            System.out.println(-1);
        }
    }

    static void BFS(int x, int y) {
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                if (nx == n - 1 && ny == n - 1) {
                    dist[nx][ny] = dist[poll[0]][poll[1]] + 1;
                    return;
                }
                if (isRange(nx, ny) && arr[nx][ny] == 0 && !ch[nx][ny]) {
                    ch[nx][ny] = true;
                    dist[nx][ny] = dist[poll[0]][poll[1]] + 1;
                    q.offer(new int[]{nx, ny});

                }
            }
            cnt ++;
        }
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
