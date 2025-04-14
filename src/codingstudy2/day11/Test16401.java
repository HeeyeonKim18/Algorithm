package codingstudy2.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// M명의 조카가 있고 N개의 과자가 있다. 동일한 크기의 과자를 준다고 할 때 과자의 최대 길이를 구하라
// 과자를 하나로 합칠 수는 없으며 양수여야 한다
// 똑같이 나눠줄 수 없다면 0을 출력한다
public class Test16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] snacks = new int[n];
        for (int i = 0; i < n; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snacks);

        int start = 1;
        int end = snacks[n - 1];

        while (start <= end) {
            int mid = (start + end) / 2;
            System.out.println(mid + " start = " + start + " end = " + end);

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (snacks[i] >= mid) {
                    cnt += snacks[i] / mid;
                }
            }

            if (cnt >= m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        System.out.println(end);

    }

}
