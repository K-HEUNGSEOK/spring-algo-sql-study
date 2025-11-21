package dfs;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Dfs_4 {
    static Integer[] arr;
    static int n, target, ans;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        target = sc.nextInt();
        ans = Integer.MAX_VALUE;

        Arrays.sort(arr, Collections.reverseOrder());
        DFS(0, 0, 0);
        System.out.println(ans);
    }

    static void DFS(int v, int sum, int cnt) {
        if(sum > target) return ;
        if(cnt >= ans) return;
        if(sum ==target){
            ans = Math.min(ans, cnt);
        }else{
            for(int i = 0 ; i < n ; i ++){
                DFS(v+1, sum +arr[i], cnt + 1);
            }
        }
    }
}
