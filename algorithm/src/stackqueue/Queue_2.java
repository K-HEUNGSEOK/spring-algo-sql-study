package stackqueue;

import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Queue_2 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        Queue<Character> q = new ArrayDeque<>();
        String s = sc.next();
        for(int i = 0 ; i < s.length(); i ++) q.offer(s.charAt(i));

        Queue<Character> plan = new ArrayDeque<>();
        String str = sc.next();
        for(int i = 0 ; i < str.length(); i++){
            char temp = str.charAt(i);
            if(!q.isEmpty() && q.peek() == temp){
                q.poll();
            }
        }
        if(!q.isEmpty()){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }
    }
}
