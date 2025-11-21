package dfs;

import java.io.FileInputStream;
import java.util.Scanner;

public class Dfs_6 {
    static int[][] memo;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        memo = new int[34][34];
        System.out.println(DFS(n, r));
    }
    static int DFS(int n, int r){
        if(memo[n][r] != 0) return memo[n][r];
        if(n == r || r == 0){
            return memo[n][r]= 1;
        }else{
            return memo[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
        }
    }
}
