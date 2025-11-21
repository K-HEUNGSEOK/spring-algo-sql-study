package dfs;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dfs_9 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] arr;
    static boolean[][] ch;
    static int n, ans;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = 7;
        ans = 0;
        ch = new boolean[n][n];
        arr = new char[n][n];

        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                arr[i][j] = sc.next().charAt(0);
            }
        }
        //1은 벽 , 0 은통로
        ch[0][0] = true;
        DFS(0, 0);
        System.out.println(ans);
    }

    static void DFS(int x, int y) {
        if (x == n - 1 && y == n - 1) {
            ans++;
        }else{
            for(int i = 0 ; i < 4; i ++){
                int nx = x+ dx[i];
                int ny = y+ dy[i];
                if(isRange(nx,ny) && !ch[nx][ny] && arr[nx][ny]=='0'){
                    ch[nx][ny]= true;
                    DFS(nx,ny);
                    ch[nx][ny] = false;
                }
            }
        }
    }
    static boolean isRange(int x, int y ){
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
