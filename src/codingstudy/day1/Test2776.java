package codingstudy.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test2776 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(); 
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());

            int[] nArr = new int[n];
            
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < n; i++){
                nArr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nArr);

            int m = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < m; i++){
                int num = Integer.parseInt(st.nextToken());
                int result = binarySearch(num, nArr);
                sb.append(result).append("\n");
            }
            
        }

        System.out.println(sb);
    }

    private static int binarySearch(int target, int[] nArr){
        int start = 0; 
        int end = nArr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nArr[mid] == target) return 1;
            else if(nArr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return 0;
    }
}
