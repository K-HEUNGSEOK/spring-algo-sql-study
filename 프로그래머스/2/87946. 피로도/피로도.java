import java.util.*;
class Solution {
    static boolean[] ch;
    static int n, ans;
    public int solution(int k, int[][] arr) {
        n = arr.length;
        ans = 0;
        ch = new boolean[n];
        DFS(0, k, arr,0);
        return ans;
    }
    static void DFS(int v, int k, int[][] arr, int cnt){
        ans = Math.max(ans, cnt);
        
        for(int i = 0 ; i < n ; i ++){
            if(!ch[i] && k >= arr[i][0]){
                ch[i] = true;
                DFS(v +1, k - arr[i][1], arr, cnt + 1);
                ch[i] = false;
            }
        }
    }
}