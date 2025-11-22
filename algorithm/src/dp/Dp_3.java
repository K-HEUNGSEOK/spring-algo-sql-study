package dp;

import java.io.FileInputStream;
import java.util.Scanner;

public class Dp_3 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coin = new int[n];
        for(int i = 0 ; i < n ; i ++) {
            coin[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] dp = new int[target+1];
        for(int i = 1 ; i < dp.length ; i ++) {
            dp[i] = Integer.MAX_VALUE;
        }
        //dp[i] 라는 금액을 만드는데 드는 최소 동전 갯수 [0]은 04
        for(int i = 0 ; i < n ; i ++) {
            for(int j = coin[i] ; j < dp.length; j ++) {

                if(dp[j - coin[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
                }
            }
        }
        System.out.println(dp[target]);
    }
}
