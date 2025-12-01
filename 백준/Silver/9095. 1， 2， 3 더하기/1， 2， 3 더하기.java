import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
      
        Scanner sc = new Scanner(System.in);
        //1 + 2 + 3 으로 만들 수 있는 수의 갯수
        int n = sc.nextInt();
        int[]dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4 ; i <= 11; i ++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i -3];
        }

        for(int i = 0 ; i < n ; i ++){
            System.out.println(dp[sc.nextInt()]);
        }
    }
}