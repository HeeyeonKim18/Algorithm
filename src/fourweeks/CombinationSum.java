package fourweeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 합을 저장할 변수 sum
// 합에 해당하는 int list를 저장할 변수
public class CombinationSum {
    public static void main(String[] args) {
        combinationSum(new int[] { 2, 3, 6, 7 }, 7);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 중복되는 숫자 없지만 중복되어 수가 들어갈 수 있기 때문에 조건에 맞게 하기 위해선 정렬 필요
        Arrays.sort(candidates);
        // 결과 값 리스트 생성
        List<List<Integer>> res = new ArrayList<>();
        findCombination(candidates, target, 0, res, new ArrayList<>(), 0);
        return res;
    }

    private static void findCombination(int[] c, int t, int start, List<List<Integer>> res, List<Integer> path,
            int sum) {
        if (sum == t) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < c.length; i++) {
            int next = sum + c[i];

            // target 값보다 지금까지의 합이 더 크다면 종료 !
            if (next > t)
                break;

            path.add(c[i]);

            findCombination(c, t, i, res, path, next);

            path.remove(path.size() - 1);
        }
    }
}
