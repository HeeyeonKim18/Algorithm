package codingstudy.day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Test1351 {
    static Map<Long, Long> dp = new HashMap<>();
    static long p, q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        long n = Long.parseLong(input[0]);
        p = Long.parseLong(input[1]);
        q = Long.parseLong(input[2]);

        System.out.println(solve(n));
    }

    static Long solve(long n) {
        if (n == 0)
            return 1L;
        if (dp.containsKey(n))
            return dp.get(n);

        long result = solve(n / p) + solve(n / q);
        dp.put(n, result);
        return result;
    }
}
