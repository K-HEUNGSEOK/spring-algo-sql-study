import java.util.*;

public class Solution {
    public int solution(int n) {
        int total = 0;
        char[] arr = (n+"").toCharArray();
        for(int i = 0 ; i < arr.length; i ++){
            int num = arr[i] - '0';
            total += num;
        }
        return total;
    }
}