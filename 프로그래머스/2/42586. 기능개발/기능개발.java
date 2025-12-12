import java.util.*;
class Solution {
    public int[] solution(int[] a, int[] b) {
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < a.length; i ++){
            int num = (int) Math.ceil((100.0 - a[i]) / b[i]);
            q.offer(num);
        }
        int date = 0;
        int cnt = 0;
        boolean flag = false;
        while(!q.isEmpty()){
            date ++;
            flag = false;
            cnt = 0;
            while(!q.isEmpty() && q.peek() <= date){
                flag = true;
                q.poll();
                cnt ++;
            }
            if(flag){
                list.add(cnt);
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0 ; i < list.size(); i ++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}