import java.util.*;
class Solution {
    static List<Integer> graph[];
    static boolean[] ch;
    public int solution(int n, int[][] wires) {
        //1.먼저 리스트에 다 등록해둔다. (입력값을 다 준비한다)
        graph = new ArrayList[n+1];
        for(int i = 0 ; i <= n ; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] number : wires){
            int a = number[0];
            int b = number[1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        int result = Integer.MAX_VALUE;
        
        //2.그래프에서 한개씩 빼보면서 DFS를 돌리고 결과값을 계산한다.
        for(int[] number : wires){
            int a = number[0];
            int b = number[1];
            
            graph[a].remove((Object) b);
            graph[b].remove((Object) a);
            
            ch = new boolean[n+1];
            int ans = DFS(a);
            result = Math.min(result, Math.abs(ans - (n-ans)));
            
            graph[a].add(b);
            graph[b].add(a);
        }
        return result;
    }
    static int DFS(int v){
        int cnt = 1;
        ch[v] = true;
        for(int num : graph[v]){
            if(!ch[num]){
                cnt += DFS(num);
            }
        }
        return cnt;
    }
}