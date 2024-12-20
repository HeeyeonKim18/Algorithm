package sparta_algorithm.secondweek;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 괄호가 유효한지 판단하는 문제 
// (), {}, []
public class StackTest {
    public static void main(String[] args) {
        String exampleStr = "({})";
        System.out.println(isValid(exampleStr));;
    }

    private static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else{
                if(stack.isEmpty()) return false;
                if(map.get(c) != stack.pop()) return false;
            }
        }
        return stack.isEmpty();
    }
}
