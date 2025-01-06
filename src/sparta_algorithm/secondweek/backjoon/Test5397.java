package sparta_algorithm.secondweek.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class Test5397 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            char[] c = br.readLine().toCharArray();

            usingList(c, sb);
            
        }

        System.out.println(sb); 
    }

    private static void usingStack(char[] c, StringBuilder sb){
        Stack<Character> l = new Stack<>();
        Stack<Character> r = new Stack<>();
        
        for(int i = 0; i < c.length; i++){
            if(c[i] == '<'){
                if(!l.isEmpty()) r.push(l.pop());
            }else if(c[i] == '>'){
                if(!r.isEmpty()) l.push(r.pop());
            }else if(c[i] == '-'){
                if(!l.isEmpty()) l.pop();
            }else {
                l.push(c[i]);
            }
        }

        for(char ch : l){
            sb.append(ch);
        }
        while(!r.isEmpty()){
            sb.append(r.pop());
        }
        sb.append("\n");
    }

    private static void usingList(char[] c, StringBuilder sb){
        LinkedList<Character> list = new LinkedList<>();
        ListIterator<Character> cursor = list.listIterator();

        for(char ch : c){
            if(ch == '<'){
                if(cursor.hasPrevious()) cursor.previous();
            }else if(ch == '>'){
                if(cursor.hasNext()) cursor.next();
            }else if(ch == '-'){
                if(cursor.hasPrevious()){
                    cursor.previous();
                    cursor.remove();
                }
            }else{
                cursor.add(ch);
            }
        }

        for (char ch : list) {
            sb.append(ch);
        }
        sb.append("\n");
    }
}
