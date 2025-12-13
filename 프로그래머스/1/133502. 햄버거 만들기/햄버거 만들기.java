import java.util.*;
class Solution {
    public int solution(int[] arr) {
        //1 2 3 1 순서로 가야함 
        int[] target = {1,2,3,1};
        int n = 4;
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for(int i = 0 ; i < arr.length; i ++){
            list.add(arr[i]);
            if(list.size() >= 4){
                if(check(list,target)){
                    cnt ++;
                    for(int j = 0 ; j < n ; j ++){
                        list.remove(list.size()-1);
                    }
                }
            }
        }
        return cnt;
    }
    static boolean check(List<Integer> list, int[] arr){
        for(int i = 0 ; i < arr.length; i++){
            if(list.get(list.size()-4+i) != arr[i]){
                return false;
            }
        }
        return true;
    }
}