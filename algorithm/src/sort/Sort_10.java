package sort;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Sort_10 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max,arr[i]);
        }
        Arrays.sort(arr);
        //1 2 4 8 9 -> 3
        int lt = 0;
        int rt = max + 1;
        while (lt + 1 < rt) {
            int mid = (rt + lt) / 2;
            int cnt = 1;
            int ep = arr[0];
            for(int i  = 1 ; i < n ; i ++){
                if(arr[i] - ep >= mid){
                    cnt ++;
                    ep = arr[i];
                }
            }
            if(cnt >= m){
                lt = mid;
            }else{
                rt = mid;
            }
            System.out.println(lt + " " + rt + " " + mid + " " + cnt);
        }
        System.out.println(lt);
    }
}
