package codingstudy.day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test11399 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println(nums[0]);
            return;
        } else {
            Arrays.sort(nums);
            long result = nums[0];

            for (int i = 1; i < n; i++) {
                nums[i] += nums[i - 1];
                result += nums[i];
            }
            System.out.println(result);
        }
    }
}
