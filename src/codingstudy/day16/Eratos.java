package codingstudy.day16;

import java.util.HashSet;

public class Eratos {

    static HashSet<Integer> numberSet = new HashSet<>();

    public static void main(String[] args) {
        String str = "17";
        solution(str);
    }

    static int solution(String numbers) {
        // 1. 가능한 모든 숫자 조합 만들기 (순열)
        boolean[] visited = new boolean[numbers.length()];
        generateNumbers("", numbers, visited);

        // 2. 소수 판별 및 개수 세기
        int count = 0;
        for (int num : numberSet) {
            if (isPrime(num))
                count++;
        }

        return count;
    }

    // 모든 숫자 조합을 만드는 순열 함수
    static void generateNumbers(String current, String numbers, boolean[] visited) {
        System.out.println("cur = " + current + " numbers = " + numbers);
        System.out.println("visited[0] = " + visited[0] + " visited[1] = " + visited[1]);
        if (!current.equals("")) {
            numberSet.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                generateNumbers(current + numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }

    // 소수 판별 함수
    static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

}
