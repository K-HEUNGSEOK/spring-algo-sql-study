package bfs;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs_6 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m , ans;
    static int[][] arr;
    static boolean[][] ch;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
         m = sc.nextInt();
         n = sc.nextInt();
        arr = new int[n][m];
        ch = new boolean[n][m];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 1){
                    q.offer(new int[]{i,j});
                    ch[i][j] = true;
                }
            }
        }
        BFS();
        System.out.println(ans);
    }
    static void BFS(){
        int cnt = 0;
        while(!q.isEmpty()){
           int len = q.size();
           for(int i = 0 ; i < len; i++){
               int[] p = q.poll();
               for(int j = 0 ; j < 4; j ++){
                   int nx = p[0] + dx[j];
                   int ny = p[1] + dy[j];
                   if(isRange(nx,ny) && !ch[nx][ny] && arr[nx][ny] == 0){
                       arr[nx][ny] = 1;
                       ch[nx][ny] = true;
                       q.offer(new int[]{nx,ny});
                   }
               }
           }
            cnt ++;
        }
        if(check()){
            ans = cnt-1;
        }else{
            ans = -1;
        }
    }
    static boolean check(){
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                if(arr[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean isRange(int x, int y ){
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
