import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int temp = nums.length / 2;
        
        for(int i = 0 ; i < nums.length; i ++){
            int num = nums[i];
            
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        
        int cnt = map.size();
        
        
        if(cnt > temp){
            return temp;
        }else{
            return cnt;
        }
     
    }
}