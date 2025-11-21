package dfs;

import java.io.FileInputStream;
import java.util.Scanner;

public class Dfs_10 {
    static int n,ans;
    static int[][] arr;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};

     public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        ans = 0;
        arr = new int[n][n];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j++){
                if(arr[i][j] == 1){
                    DFS(i,j);
                    ans ++;
                }
            }
        }
         System.out.println(ans);
    }
    static void DFS(int x, int y){
         for(int i = 0 ; i < 8; i ++){
             int nx = x + dx[i];
             int ny = y + dy[i];
             if(isRange(nx,ny) && arr[nx][ny] == 1){
                 arr[nx][ny] = 0;
                 DFS(nx,ny);
             }
         }
    }
    static boolean isRange(int x, int y){
         return 0 <= x && x < n && 0 <= y && y < n;
    }
}
