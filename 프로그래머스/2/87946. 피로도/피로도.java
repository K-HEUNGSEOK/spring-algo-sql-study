import java.util.*;
class Solution {
    static int[] param;
    static boolean[] ch;
    static int n, ans;
    public int solution(int k, int[][] arr) {
        n = arr.length;
        ans = 0;
        param = new int[n];
        ch = new boolean[n];
        DFS(0, k, arr);
        return ans;
    }
    static void DFS(int v, int k, int[][] arr){
        if(v == n){
            int temp = k;
            int cnt = 0;
            for(int i = 0 ; i < n ; i ++){
                int index = param[i] -1 ;
                if(temp >= arr[index][0]){
                    temp -= arr[index][1];
                    cnt ++;
                }else{
                    break;
                }
            }
            ans = Math.max(ans,cnt);
        }else{
            for(int i = 0 ; i < n ; i ++){
                if(!ch[i]){
                    ch[i] = true;
                    param[v] = i +1;
                    DFS(v+1, k ,arr);
                    ch[i] = false;
                }
            }
        }
    }
}