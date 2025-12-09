import java.util.*;
class Solution {
    static Set<Integer> set;
    static String[] arr;
    static boolean[] ch, prime;
    public int solution(String numbers) {
        //1. 미리 모든 소수를 구해둠
        prime = new boolean[10000000];
        primeCheck(prime);
        
        //2. 초기 세팅
        arr = numbers.split("");
        ch = new boolean[numbers.length()];
        set = new HashSet<>();
        //3. 호출
        DFS("");
        //4. 출력
        return set.size();
    }
    
    static void DFS(String current){
        if(!current.equals("")){
            int num = Integer.parseInt(current);
            if(!prime[num]){
                set.add(num);
            }
        }
        for(int i = 0 ; i < arr.length; i ++){
            if(!ch[i]){
                ch[i] = true;
                DFS(current + arr[i]);
                ch[i] = false;
            }
        }
    }
    
    static void primeCheck(boolean[] prime){
        prime[0] = true;
        prime[1] = true;
        for(int i = 2; i*i < prime.length; i ++){
            if(!prime[i]){
                for(int j = i * i ; j < prime.length; j +=i){
                    prime[j] = true;
                }
            }
        }
    }
}