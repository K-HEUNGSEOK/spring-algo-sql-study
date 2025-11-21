package stackqueue;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Stack_3 {
    static int n;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //1.입력받기
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                arr[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] command = new int[m];
        for(int i = 0 ; i < m ; i ++) command[i] = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        //2.구현하기
        //0이면 통과 범위를 넘으면 그만
        //같은 번호면 터트리기
        for(int i = 0 ; i < m ; i ++){
            int c = command[i]-1;

            for(int j = 0 ; j < n ; j++){
                if(arr[j][c] != 0){
                    if(stack.isEmpty()){
                        stack.push(arr[j][c]);
                    }else if(stack.peek() != arr[j][c]){
                        stack.push(arr[j][c]);
                    }else{
                        stack.pop();
                        ans+=2;
                    }
                    arr[j][c] = 0;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
