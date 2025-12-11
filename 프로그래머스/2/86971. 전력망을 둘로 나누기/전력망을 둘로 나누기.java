import java.util.*;
class Solution {
    static List<Integer>[] graph;
    static boolean[] ch;
    static int ans, result;
    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n+1];
        for(int i = 0 ; i <= n ; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] temp : wires){
            int a = temp[0];
            int b = temp[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        result = Integer.MAX_VALUE;
        for(int[] temp : wires){
            int a = temp[0];
            int b = temp[1];
            
            graph[a].remove((Object) b);
            graph[b].remove((Object) a);
            
            ch = new boolean[n+1];
            ans = DFS(a);
            result = Math.min(result, Math.abs(ans - (n-ans)));
   
            graph[a].add(b);
            graph[b].add(a);
        }
        return result;
        
    }
    
    static int DFS(int v){
        int count = 1;
        ch[v]=true;
        for(int num : graph[v]){
            if(!ch[num]){
                count += DFS(num);
            }
        }
        return count;
    }
}