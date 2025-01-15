package codingstudy.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test11663 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        while(m-- > 0){
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);

            int count = endDots(nums, end) - startDots(nums, start);
            sb.append(count).append("\n");
            
        }

        System.out.println(sb);
    }

    private static int startDots(int[] nums, int target){
        int s = 0;
        int e = nums.length;

        while(s < e){
            int mid = s + (e - s) / 2;
            if(nums[mid] >= target) e = mid;
            else s = mid + 1;
        }
        return s;
    }

    private static int endDots(int[] nums, int target){
        int s = 0;
        int e = nums.length;

        while(s < e){
            int mid = s + (e - s) / 2;
            if(nums[mid] > target) e = mid;
            else s = mid + 1;
        }
        return s;
    }
}
