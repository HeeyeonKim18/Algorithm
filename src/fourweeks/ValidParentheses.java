package fourweeks;

import list.stack.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{}";

        System.out.println(isValid(s));
    }
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;

                char top = stack.pop();
                if((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')){
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }
}
