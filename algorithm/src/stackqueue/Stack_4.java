package stackqueue;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Stack_4 {
    static char[] arr = {'-','+','*','/'};
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < str.length(); i ++){
            if(Character.isDigit(str.charAt(i))){
                stack.push(str.charAt(i)-'0');
            }else{
                Integer rt = stack.pop();
                Integer lt = stack.pop();
                int num = parse(lt,rt,str.charAt(i));
                stack.push(num);
            }
        }
        System.out.println(stack.pop());
    }
    static int parse(int lt , int rt, char calculate){
        switch(calculate){
            case '-':
                return lt - rt;
            case '+':
                return lt + rt;
            case '*':
                return lt * rt;
            case '/':
                return lt / rt;
        }
        return -1;
    }
}
