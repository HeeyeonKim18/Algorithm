package codingstudy.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        int[] kArr = new int[k];
        long max = 0;
        for(int i = 0; i < k; i++){
            kArr[i] = Integer.parseInt(br.readLine());
            if(kArr[i] > max) max = kArr[i];
        }

        long left = 1;
        long right = max;
        long result = 0;

        while(left <= right){
            long mid = left + (right - left) / 2;
            if(isPossible(kArr, mid, n)){
                result = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(result);
    }

    private static boolean isPossible(int[] arr, long mid, int n){
        long count = 0;
        for(int length : arr){
            count += length / mid;
        }
        return count >= n;
    }
    
}
