package list.queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("peek: " + q.peek());
        while(!q.isEmpty())
            System.out.println(q.remove());

    }
}
