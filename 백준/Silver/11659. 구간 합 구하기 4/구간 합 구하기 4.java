import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
     
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] arr = new int[n+1];
        for(int i = 1 ; i <= n ; i ++){
            arr[i] = sc.nextInt();
        }
        int[] prefix = new int[n+1];
        for(int i = 1; i <=n ; i ++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < m ; i ++){
            int start = sc.nextInt(); // 이게 만약 3 이라면 1~3까지인데 3은 end에 포함되어야함 그래서 -1을해주자
            int end= sc.nextInt(); // 1 ~ end 까지
            sb.append(prefix[end] - prefix[start-1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}