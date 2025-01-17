package codingstudy.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Middler
public class Test2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int sum = 0;
        int max = 0;
        int[] lessons = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            lessons[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, lessons[i]);
            sum += lessons[i];
        }

        System.out.println(minBluelay(lessons, max, sum, m));
    }

    private static int minBluelay(int[] lessons, int max, int sum, int m){
        int low = max;
        int high = sum;
        
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isValid(lessons, mid, m)) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }

    private static boolean isValid(int[] lessons, int mid, int m){
        int count = 1;
        int total = 0;
        
        for(int i = 0; i < lessons.length; i++){
            if(total + lessons[i] > mid){
                count++;
                total = lessons[i];
                if(count > m) return false;
            }else{
                total += lessons[i];
            }
        }

        return true;
    }
}
