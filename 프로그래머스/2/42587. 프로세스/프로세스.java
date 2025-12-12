import java.util.*;
class Solution {
    public int solution(int[] arr, int location) {
        Queue<Point> q = new ArrayDeque<>();
        Integer[] maxNumber = new Integer[arr.length];
        for(int i = 0 ; i < arr.length; i ++){
            maxNumber[i] = arr[i];
        }
        Arrays.sort(maxNumber, Collections.reverseOrder());
        
        int maxIndex = 0;
        int max = maxNumber[maxIndex];
        
        for(int i = 0 ; i < arr.length; i ++){
            q.offer(new Point(arr[i], i));
        }
        
        int cnt = 0;
        
        while(!q.isEmpty()){
            Point temp = q.poll();
            
            if(temp.num != max){
                q.offer(temp);
            }else{
                cnt ++;
                if(temp.index == location){
                    return cnt;
                }
                maxIndex ++;
                if(maxIndex == maxNumber.length){
                    maxIndex = 0;
                }
                max = maxNumber[maxIndex];
            }
        }
        return 1;
    }
    static class Point{
        int num,index;
        public Point(int num, int index){
            this.num = num;
            this.index = index;
        }
    }
}