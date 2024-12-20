package sparta_algorithm.secondweek;

import java.util.Stack;

public class PostfixNotation {
    public static void main(String[] args) {
        String str = "23+5*";
        System.out.println(getSum(str));
    }
    
    private static int getSum(String s){
        Stack<Integer> stack = new Stack<>();
        
        int op1, op2;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                stack.push((int)c - '0');
            }else{
                op2 = stack.pop();
                op1 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(op1 + op2);
                        break;
                
                    case '-':
                        stack.push(op1 - op2);
                        break;
                    
                    case '*':
                        stack.push(op1 * op2);
                        break;
                    
                    case '/':
                        stack.push(op1 / op2);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
