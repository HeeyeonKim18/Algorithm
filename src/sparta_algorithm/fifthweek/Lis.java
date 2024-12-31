package sparta_algorithm.fifthweek;

import java.util.Arrays;

public class Lis {
    public static void main(String[] args) {
        int[] arr1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] arr2 = {0, 1, 0, 3, 2, 3};
        System.out.println(lis(arr1));
        System.out.println(lis(arr2));

    }

    private static int lis(int[] arr){
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);

        int max = 0;
        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
