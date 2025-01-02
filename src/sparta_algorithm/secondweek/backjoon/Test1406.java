package sparta_algorithm.secondweek.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Test1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (char c : str.toCharArray()) {
            leftStack.push(c);
        }

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            String command = br.readLine();

            if(command.startsWith("L")){
                if(!leftStack.isEmpty()) rightStack.push(leftStack.pop());
            }else if(command.startsWith("D")){
                if(!rightStack.isEmpty()) leftStack.push(rightStack.pop());
            }else if(command.startsWith("B")){
                if(!leftStack.isEmpty()) leftStack.pop();
            }else{
                char c = command.split(" ")[1].charAt(0);
                leftStack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : leftStack) {
            result.append(c);
        }
        while(!rightStack.isEmpty()){
            result.append(rightStack.pop());
        }
        System.out.println(result);
    }
}
