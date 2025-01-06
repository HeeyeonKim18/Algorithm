package sparta_algorithm.secondweek.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Test10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int totalcount = 0;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }
            else{
                stack.pop();
                if(str.charAt(i - 1) == '('){
                    totalcount += stack.size();
                }else{
                    totalcount++;
                }
            }
        }
        System.out.println(totalcount);
    }
}
