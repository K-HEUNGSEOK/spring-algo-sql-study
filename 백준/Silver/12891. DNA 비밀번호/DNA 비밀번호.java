import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
public class Main {
    static int cntA, cntB, cntC , cntD;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //문자열 길이
        int m = sc.nextInt(); //부분 문자열 길이
        String str = sc.next(); //해당 문자열
        int a = sc.nextInt(); //A 의 갯수
        int b = sc.nextInt(); //C 의 갯수
        int c = sc.nextInt(); //G 의 갯수
        int d = sc.nextInt(); //T 의 갯수

         cntA = 0;
         cntB = 0;
         cntC = 0;
         cntD = 0;

        //1. m-1 까지 세팅
        for(int i = 0; i < m-1; i ++){
            char z = str.charAt(i);
            increased(z);
        }

        int ans = 0;
        for(int i = m-1; i < n ; i ++){
            char s = str.charAt(i);
            increased(s);

            if (dnaCheck(a,b,c,d)){
                ans ++;
            }

            decreased(str.charAt(i + 1 - m));
        }
        System.out.println(ans);
    }
    static void increased(char st){
        if (st == 'A') cntA ++;
        else if (st == 'C') cntB ++;
        else if (st == 'G') cntC ++;
        else if (st == 'T') cntD ++;
    }
    static void decreased(char st){
        if (st == 'A') cntA --;
        else if (st == 'C') cntB --;
        else if (st == 'G') cntC --;
        else if (st == 'T') cntD --;
    }
    static boolean dnaCheck(int a, int b, int c, int d){
        if (cntA >= a && cntB >= b && cntC >= c && cntD >= d) return true;
        return false;
    }
}