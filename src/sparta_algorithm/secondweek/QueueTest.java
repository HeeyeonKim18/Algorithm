package sparta_algorithm.secondweek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        List<Integer> result = isQueue(list);
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

    private static List<Integer> isQueue(List<Integer> list){
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (Integer i : list) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            result.add(queue.remove());
            if(!queue.isEmpty()) queue.add(queue.remove());
        }

        return result;
    }
}
