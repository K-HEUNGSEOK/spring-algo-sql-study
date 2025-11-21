package dfs;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Dfs_2 {
    static int n, max;
    static boolean flag = false;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for(int i = 0 ; i < n ; i ++) arr[i] = sc.nextInt();
        max = Arrays.stream(arr).sum();
        if(max % 2 != 0){
            System.out.println("NO");
            return;
        }
        max/=2;
        DFS(0,0);
        if(flag){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    static void DFS(int v, int total){
        if(flag) return;
        if(total > max){
            return;
        }
        if(v == n){
            if(total == max){
                flag = true;
                return;
            }
        }else{
            DFS(v + 1 , total + arr[v]);
            DFS(v + 1 , total);
        }
    }

}
