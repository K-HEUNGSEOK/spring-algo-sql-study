import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
  
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      queue.offer(sc.nextInt());
    }

    int total = 0;
    if (queue.size() == 1) {
      System.out.println(0);
      return;
    }
    while (!queue.isEmpty()) {
      int a = queue.poll(); //10 //30
      int b = queue.poll(); //20 // 40
      int sum = a + b; // 30 // 70
      total += sum;
      if (queue.isEmpty()) {
        break;
      }
      queue.offer(sum);
    }
    System.out.println(total);
  }
}
