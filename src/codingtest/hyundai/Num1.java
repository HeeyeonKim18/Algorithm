package codingtest.hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Num1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j <= end; j++) {
                if(map.containsKey(j)){
                    map.replace(j, map.get(j) + 1);
                }
            }
        }

        int[][] arr = new int[N][2];
        int idx = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            arr[idx][0] = entry.getKey();
            arr[idx][1] = entry.getValue();
            idx++;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[0] - o2[0];
            return o2[1] - o1[1];
        });

        System.out.println(arr[K][0]);
    }
}
