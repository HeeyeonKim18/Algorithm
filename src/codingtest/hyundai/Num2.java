package codingtest.hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Num2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(map.containsKey(w)){
                if(v > map.get(w)){
                    map.replace(w, v);
                }else{
                    map.put(w, v);
                }
            }
        }

        int[] arr = new int[N];
        int index =0;
        for (int i = M; i > M / 2; i--) {
            if(map.containsKey(i)){
                arr[index] = map.get(i);
                if(map.containsKey(M-i)){
                    arr[index] += map.get(M-i);
                }
            }
            index++;
        }

        Arrays.sort(arr);

        int sum = 0;
        int idx = N -1;
        for (int i = 0; i < K; i++) {
            sum+= arr[idx--];
        }

        System.out.println(sum);
    }
}
