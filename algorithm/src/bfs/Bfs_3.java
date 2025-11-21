package bfs;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs_3 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        Node root = new Node(1);
        root.lt = new Node(2);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt = new Node(3);
        BFS(root);
    }

    static void BFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node poll = q.poll();
                if(poll.lt == null && poll.rt == null){
                    System.out.println(level);
                    return;
                }
                if(poll.lt != null){
                    q.offer(poll.lt);
                }
                if(poll.rt != null){
                    q.offer(poll.rt);
                }
            }
            level ++;

        }
    }

    static class Node {
        int data;
        Node lt;
        Node rt;

        public Node(int data) {
            this.data = data;
            this.lt = null;
            this.rt = null;
        }
    }
}
