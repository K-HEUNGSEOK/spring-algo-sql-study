import java.util.*;
class Solution {
    public int solution(String[][] arr) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] temp : arr){
            String key = temp[1];
            map.put(key, map.getOrDefault(key,0) + 1);
        }
        int total = 1;
        for(String k : map.keySet()){
            total *= (map.get(k) + 1);
        }
        return total-1;
}
}