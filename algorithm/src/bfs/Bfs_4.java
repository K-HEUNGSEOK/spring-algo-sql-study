package bfs;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Bfs_4 {
    static List<Integer>[] graph;
    static boolean[] ch;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //1번 ~ n 번까지
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new List[n+1];
        for(int i = 0 ; i <= n ; i++) {
            graph[i] = new ArrayList<>();
        }
        ch = new boolean[n+1];
        arr = new int[n+1];
        for(int i = 0 ; i < m ; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
        }
        BFS(1);
        for(int i = 2; i <= n ; i++){
            System.out.println(i + " : " + arr[i]);
        }
    }
    static void BFS(int v){
        ch[v] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        int level = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0 ; i < len ; i ++){
                Integer poll = q.poll();

                for(int nx : graph[poll]){
                    if(!ch[nx]){
                        ch[nx] = true;
                        arr[nx] = level+1;
                        q.offer(nx);
                    }
                }
            }
            level ++;
        }
    }
}
