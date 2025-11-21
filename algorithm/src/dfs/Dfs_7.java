package dfs;

import java.io.FileInputStream;
import java.util.Scanner;

public class Dfs_7 {
    static int[][] memo;
    static int[] param;
    static int[] arr;
    static int n, ans, target;
    static boolean[] ch;
    static boolean flag =false;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ch = new boolean[n+1];
        target = sc.nextInt();
        ans =0;
        memo = new int[11][11];
        arr = new int[n];
        param = new int[n];

        //1.경우의 수 구하기
        for(int i = 0 ; i < n ; i ++){
            arr[i] = combi(n-1, i);
        }
        DFS(0);
    }
    static void DFS(int v){
        if(flag) return;
        if(v == n){
            int total = 0;
            for(int i = 0 ; i < n ; i ++){
                total += arr[i] * param[i];
            }
            if(total == target){
                for(int i = 0 ; i < n ; i ++){
                    System.out.print(param[i] + " ");
                }
                flag = true;
            }
        }else{
            for(int i = 1; i <= n ; i ++){
                if(!ch[i]) {
                    ch[i] = true;
                    param[v] = i;
                    DFS(v + 1);
                    ch[i] = false;
                }
            }
        }
    }
    static int combi(int n, int r){
        if(memo[n][r] != 0) return memo[n][r];
        if(n == r || r == 0){
            return memo[n][r]= 1;
        }else{
            return memo[n][r] = combi(n-1, r-1) + combi(n-1, r);
        }
    }
}
