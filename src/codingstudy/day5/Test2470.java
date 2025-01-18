package codingstudy.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test2470 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int i = 0, j = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int[] result = new int[2];

        while(i < j){
            int sum = nums[i] + nums[j];
            if(Math.abs(sum) < min){
                min = Math.abs(sum);
                result[0] = nums[i];
                result[1] = nums[j];
            }
            if(sum == 0) break;
            if(sum > 0) j--;
            else i++;
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
