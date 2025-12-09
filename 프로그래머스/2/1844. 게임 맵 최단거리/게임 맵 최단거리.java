import java.util.*;
class Solution {
    static int n, m, ans;
    static boolean flag = false;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] ch;
    static Queue<int[]> q = new LinkedList<>();
    public int solution(int[][] maps) {
        int x = 0;
        int y = 0;
        ans = Integer.MAX_VALUE;
        n = maps.length;
        m = maps[0].length;
        ch = new boolean[n][m];
        BFS(x, y, maps);
        if(flag){
            return ans;
        }else{
            return -1;
        }
    }
    static void BFS(int x , int y, int [][] arr){
        ch[x][y] = true;
        q.offer(new int[]{x,y});
        int cnt = 1;
        while(!q.isEmpty()){
            int len = q.size();
            for(int z = 0 ; z < len; z ++){
                int[] temp = q.poll();
                for(int i = 0 ; i < 4; i ++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if(nx == n-1 && ny == m-1){
                    flag = true;
                    ans = cnt + 1;
                    return;
                }
                if(isRange(nx,ny) && !ch[nx][ny] && arr[nx][ny] == 1){
                    q.offer(new int[]{nx,ny});
                    ch[nx][ny] =true;
                }
            }
            }
            cnt ++;
        }
    }
    static boolean isRange(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}