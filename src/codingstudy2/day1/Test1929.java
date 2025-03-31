package day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 소수 구하기
 * 에라토스테네스의 체 활용
 */
public class Test1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int m = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);

        primeNums(m, n);
    }

    private static void primeNums(int m, int n) {
        // 소수인지 분별하는 배열열
        boolean[] isPrimes = new boolean[n + 1];

        // 0, 1 은 소수가 아니기 때문에 제외
        isPrimes[0] = isPrimes[1] = true;

        // 제곱근까지만 계산해주면 됨
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrimes[i]) // 소수가 아닌 것으로 판정된 것은 제외(불필요한 반복 줄이기)
                continue;
            for (int j = i * i; j < isPrimes.length; j += i) { // 소수 아닌 것 제거하기
                isPrimes[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (!isPrimes[i])
                sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
