package sparta_algorithm.thirdweek;

import java.util.ArrayList;
import java.util.List;

// 주어진 정수 배열에서 모든 가능한 순열을 생성하는 프로그램을 작성하세요.
// 배열에는 중복된 숫자가 없다고 가정합니다.
public class Permutation {
    public static void main(String[] args) {
        int[] test1 = {1,2,3};
        int[] test2 = {1,2,3,4};

        backTracking(test1);
        backTracking(test2);
    }

    private static void backTracking(int[] n){
        // 출력 정보
        List<Integer> result = new ArrayList<>();
        // 방문 여부
        boolean[] visited = new boolean[n.length];

        recursive(n, result, visited);
    }

    private static void recursive(int[] n, List<Integer> result, boolean[] visited){
        // 순열과 열의 길이가 동일하다면 출력
        if(result.size() == n.length){
            System.out.println(result);
            return;
        }

        // 루프를 돌며 백트래킹
        for(int i = 0; i < n.length; i++){
            if(!visited[i]){
                result.add(n[i]);
                visited[i] = true;
                recursive(n, result, visited);

                // 재귀 호출 이후에는 마지막으로 들어온 값 제거
                result.remove(result.size() - 1);
                visited[i] = false;
            }
        }
    }

}
