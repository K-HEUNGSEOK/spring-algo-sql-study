import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        
        int[] result = new int[3];
        result[0] = checkMax(a,answers);
        result[1] = checkMax(b,answers);
        result[2] = checkMax(c,answers);
        
        int max = Math.max(result[0],result[1]);
        max = Math.max(max,result[2]);
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < 3; i ++){
            if(max == result[i]){
                list.add(i + 1);
            }
        }
        int [] ans = new int[list.size()];
        for(int i = 0 ; i < list.size(); i ++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    static int checkMax(int[] a, int[] target){
        int result = 0; //총 갯수 세기
        boolean [] ch = new boolean[target.length];
        int cnt = 0; //a 배열 계속 돌아야지
        for(int i = 0 ; i < target.length; i ++){
            if(a[cnt] == target[i]){
                ch[i] = true;
            }
            cnt ++;
            if(cnt == a.length){
                cnt = 0;
            }
        }
        
        for(int i = 0 ; i < ch.length; i ++){
            if(ch[i]){
                result ++;
            }
        }
        return result;
    }
}