package bfs;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs_2 {
    static int[] move = {1, -1, 5};
    static int ans, e;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        e = sc.nextInt();
        ans = 0;
        BFS(s);
    }

    static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Integer poll = q.poll();
                for(int j = 0 ; j < 3; j ++){
                    int nx = poll + move[j];
                    if(nx == e){
                        System.out.println(level+1);
                        return;
                    }
                    q.offer(nx);
                }
            }
            level++;

        }
    }
}
