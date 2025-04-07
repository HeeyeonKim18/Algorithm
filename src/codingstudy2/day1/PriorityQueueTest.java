package codingstudy2.day1;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        // 최소힙힙
        PriorityQueue<Integer> minQ = new PriorityQueue<>();

        minQ.add(1);
        minQ.add(2);
        minQ.add(3);
        minQ.add(4);
        minQ.add(5);
        minQ.add(6);
        minQ.add(7);
        minQ.add(8);

        while (!minQ.isEmpty()) {
            System.out.println(minQ.poll());
        }

        PriorityQueue<Integer> maxQ = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

        maxQ.offer(1);
        maxQ.offer(2);
        maxQ.offer(3);
        maxQ.offer(4);
        maxQ.offer(5);
        maxQ.offer(6);
        maxQ.offer(7);
        maxQ.offer(8);

        while (!maxQ.isEmpty()) {
            System.out.println(maxQ.poll());
        }
    }
}
