import java.util.*;
class Solution {
    public int solution(int[][] arr) {
        int resultX = 0;
        int resultY = 0;
        for(int[] temp : arr){
            int x = Math.max(temp[0], temp[1]);
            int y = Math.min(temp[0], temp[1]);
            
            resultX = Math.max(resultX, x);
            resultY = Math.max(resultY, y);
        }
        return resultX * resultY;
    }
}