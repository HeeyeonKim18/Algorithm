package list.stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<Integer>();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println("peek: " + st.peek());
        while (!st.isEmpty())
            System.out.println(st.pop());
    }
}
