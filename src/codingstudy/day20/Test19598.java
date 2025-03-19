package codingstudy.day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test19598 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            meetings[i][0] = Integer.parseInt(str[0]);
            meetings[i][1] = Integer.parseInt(str[1]);
        }

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            while (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            pq.offer(end);

            cnt = Math.max(cnt, pq.size());
        }
        System.out.println(cnt);
    }
}
