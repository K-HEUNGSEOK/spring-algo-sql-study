package stackqueue;

import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Queue_1 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1 ; i <= n ; i ++) queue.offer(i);

        int cnt =0;
        while(queue.size() != 1){
            cnt ++;
            Integer poll = queue.poll();
            if(cnt == m){
                cnt =0;
            }else{
                queue.offer(poll);
            }
        }
        for (Integer i : queue) {
            System.out.println(i);
        }

    }
}
