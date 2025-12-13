import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] time) {
        Map<String, Integer> total = new HashMap<>();
        for(int i = 0 ; i < name.length; i ++){
            total.put(name[i], total.getOrDefault(name[i], 0) + time[i]);
        }
        //최대값들 구했음
        
        Map<String, List<Point>> map = new HashMap<>();
        for(int i = 0 ; i < name.length; i ++){
            if(!map.containsKey(name[i])){
                map.put(name[i], new ArrayList<Point>());
            }
            map.get(name[i]).add(new Point(time[i], i));
        }
      
        List<Integer> ans = new ArrayList<>(); //정답값 담는 그릇
        while(!total.isEmpty()){
            String key = getMax(total);
            List<Point> list = map.get(key);
            Collections.sort(list);
            int len = Math.min(list.size(), 2);
            for(int i = 0 ; i < len; i ++){
                ans.add(list.get(i).index);
            }
        }
        int[] result = new int[ans.size()];
        for(int i = 0 ; i < ans.size(); i ++){
            result[i] = ans.get(i);
        }
        return result;
        
    }
    static String getMax(Map<String,Integer> map){
        int max = 0;
        String key = "";
        for(String str : map.keySet()){
            if(map.get(str) > max){
                max = map.get(str);
                key = str;
            }
        }
        map.remove(key);
        return key;
    }
    static class Point implements Comparable<Point>{
        int num;
        int index;
        public Point(int num, int index){
            this.num = num;
            this.index = index;
        }
        @Override
        public int compareTo(Point o){
            if(this.num == o.num){
                return this.index - o.index;
            }
            return o.num - this.num;
        }
    }
}