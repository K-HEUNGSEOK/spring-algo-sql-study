
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class Main {
    static ArrayList<Character> list = new ArrayList<>();
    static char[] alphabet = {'a','e','i','o','u'};
    static int L,C;
    static char[] arr;
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        arr = new char[C];
        for(int i = 0 ; i < C;  i ++){
            arr[i] = sc.next().charAt(0);
        }
        Arrays.sort(arr);
        //a, e, i, o, u 최소 이게 1개 있어야 하고 이게 아닌 것들이 2개는 있어야함
        //acis
        //acit
        //aciw
        //정렬까지 완료
        combination(0,0);
    }
    static boolean check(){
        //최소 1개 이상 있으면서
        //다른 알파벳도 2개 이상 있어야함
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0 ; i < list.size(); i ++){
            char cur = list.get(i);
            boolean flag = true;
            for(char nx : alphabet){
                if(cur == nx){
                    cnt1 ++;
                    flag = false;
                }
            }
            if(flag) cnt2 ++;
        }

        if(cnt1 > 0 && cnt2 > 1) return true;

        return false;
    }
    static void combination(int v, int start){
        if(v == L){
            if(check()) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i));
                }
                System.out.println();
            }
        }else{
            for(int i = start; i < C; i ++){
                // 오름차순으로 정렬 백트래킹 중복 없이
                list.add(arr[i]);
                combination(v + 1, i + 1);
                list.remove(list.size()-1);
            }
        }
    }
}