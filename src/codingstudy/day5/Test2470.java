package codingstudy.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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

        // int low = nums[0];
        // int high = nums[n -1];
        // int min = Integer.MAX_VALUE;

        // while(low <= 0 || high >= 0){
        //     int mid = low + (high - low) / 2;

        //     if(mid < 0){
        //         high--;
        //     } 
        //     else if(mid > 0){
        //         low++;
        //     } 
        //     else{
        //         System.out.println(low + " " + high);
        //         return;
        //     }
        //     min = Math.min(min, mid);
            
        // }
    }
}
