package codingstudy.day6;

import java.util.Arrays;

// 프로그래머스 입국심사

/*
 * 모든 사람이 심사 받는데 걸리는 최소 시간 즉, 어떤 시간동안 최대 인원을 계속 비교해보면 됨
 * 
 * 제한사항: 1,000,000,000 <- 완전 탐색 불가한 수
 * 
 * 어떤 알고리즘을 선택할까?
 * 이분탐색? 정렬된 범위 안에서 값을 찾을 때
 * DP? 중복계산이 많을 때
 * 그리디? 각 단계에서 최적의 선택이 가능할 때
 * DFS/BFS? 그래프 탐색 혹은 경로
 * HASHING, SLIDING WINDOW, TWO POINTER? 배열 혹은 문자열 관련 구현
 * 
 * 이분탐색, 그리디가 적합한 것으로 보임
 * 그렇다면 왜 그리디가 안되는 것인가?
 * 그리디: 미래 상황을 고려하지 않고 현재 단계에서 가장 최적화된 선택을 따르기 때문에
 * 전체 시간의 최소화를 보장하지 못할 수도 있다라는 결론에 닿음
 * 
 * 알고리즘 -> 이분탐색
 * 
 * 최소 시간: 1분, 최대 시간: 느린 심사관 X n
 * 
 * for(int t:times){} 반복문: mid / t 를 하면 해당 심사관이 mid 시간내에 볼 수 있는 사람을 계산할 수 있음
 * total 변수를 이용하여 모든 심사관이 볼 수 있는 사람을 구함
 * 만약 모든 심사관을 계산하기 전에 total 값이 n 보다 크다면, 반복문을 더이상 실행하지 않고 종료하는 게 효율적임
 * 
 * 최소 시간을 구해야 하니까 while 내에 조건문(total >= n)을 이렇게 적어야 함
 * 그리고 해당 값에서 가장 작은 수를 출력할 수 있도록 Math.min() 메서드를 활용
 */
public class Bonus {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        System.out.println(solution(n, times));
    }

    private static long solution(int n, int[] times){
        Arrays.sort(times);
        long start = 1;
        long end = (long)times[times.length - 1] * n;
        long result = end;

        while(start <= end){
            long mid = (start + end) / 2;
            long total = 0;
            for(int t : times){
                total += (mid / t);
                if(total >= n) break;
            }

            if(total >= n){
                result = Math.min(result, mid);
                end = mid - 1;
            }else start = mid + 1;
        }

        return result;
    }
}
