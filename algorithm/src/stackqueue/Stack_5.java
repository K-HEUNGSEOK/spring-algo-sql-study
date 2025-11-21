package stackqueue;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Stack_5 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for(int i = 0 ; i < str.length(); i ++){
            char temp = str.charAt(i);
            if(temp == ')'){
                stack.pop();
                if(str.charAt(i-1) == '('){
                    ans += stack.size();
                }else{
                    ans += 1;
                }
            }else{
                stack.push(temp);
            }
        }
        System.out.println(ans);
    }
}
