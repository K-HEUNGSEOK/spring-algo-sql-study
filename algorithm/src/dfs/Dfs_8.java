package dfs;

import java.io.FileInputStream;
import java.util.Scanner;

public class Dfs_8 {
    static int[] param;
    static int n,m;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();
        param = new int[m];
        DFS(0,1);
    }
    static void DFS(int v, int start){
        if(v == m){
            for(int i = 0 ; i < m ; i ++){
                System.out.print(param[i] + " ");
            }
            System.out.println();
        }else{
            for(int i = start ; i <= n ; i ++){
                param[v] = i;
                DFS(v+1, i+1);
            }
        }
    }
}
