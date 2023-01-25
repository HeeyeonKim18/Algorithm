import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(18);
        st.push(20);
        st.push(22);
        System.out.println("==stack==");
        while(!st.empty())
            System.out.println(st.pop());

        Queue<Integer> q = new LinkedList();
        q.offer(18);
        q.offer(20);
        q.offer(22);
        System.out.println("==Queue==");
        while(!q.isEmpty())
            System.out.println(q.poll());


    }
}