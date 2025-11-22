package dp;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Dp_2 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = 1;

        //자기보다 작은애들중에 가장 큰 수 + 1을 하면 된다.
        for(int i = 1; i < n ; i ++) {
            int max = 0;
            for(int j = i -1; j >= 0; j --) {
                if(arr[i] > arr[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }


        int ans = Arrays.stream(dp).max().getAsInt();
        System.out.println(ans);
    }
}
