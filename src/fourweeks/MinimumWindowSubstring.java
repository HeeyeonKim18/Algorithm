package fourweeks;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC", t1 = "ABC";
        System.out.println(minWindow(s1, t1)); // 기대값: "BANC"

        String s2 = "a", t2 = "a";
        System.out.println(minWindow(s2, t2)); // 기대값: "a"

        String s3 = "a", t3 = "aa";
        System.out.println(minWindow(s3, t3));
    }

    private static String minWindow(String s, String t) {
        if (t == null || s == null)
            return "";
        if (t.length() == 0)
            return "";
        if (t.length() > s.length())
            return "";

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int missing = t.length(); // 아직 충족하지 못한 전체 문자 수
        int left = 0;
        int bestLen = Integer.MAX_VALUE;
        int bestL = 0;

        for (int right = 0; right < s.length(); right++) {
            char rc = s.charAt(right);
            if (need.containsKey(rc)) {
                need.put(rc, need.get(rc) - 1);
                if (need.get(rc) >= 0) {
                    // 필요한 것을 채웠을 때에는 감소
                    missing--;
                }
            }

            while (missing == 0) {
                if (right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    bestL = left;
                }

                char lc = s.charAt(left);
                if (need.containsKey(lc)) {
                    need.put(lc, need.get(lc) + 1);
                    if (need.get(lc) > 0) {
                        missing++;
                    }
                }
                left++;
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestL, bestL + bestLen);
    }
}
/**
 * Minimum Window Substring
 * 
 * 이 문제는 주어진 s, t 문자열에서 t에 있는 모든 문자열을 포함한 최소 길이의 s 문자열을 찾아야 한다.
 * 만약 최소 길이의 문자열이 존재하지 않는다면 빈 문자열을 return 한다.
 * 
 * 필요한 변수는 아래와 같다.
 * Map<Character, Integer> need: t 문자열에 존재하는 char 값을 저장하고, s 문자열에 존재하는지 확인
 * int missing: t 문자열을 모두 포함했는지 여부를 검사하기 위한 변수
 * int left = 왼쪽 포인터
 * int bestLen = 최적의 길이 저장하는 변수
 * int bestL = 최적의 길이 때의 왼쪽 포인터 위치
 * 
 * 1. Map에 t 문자열을 모두 저장한다. 중복되는 char 값의 개수도 저장하기 위해 getOrDefault() 메서드를 이용한다.
 * need.put(c, need.getOrDefault(c, 0) + 1);
 * 
 * 2. 반복문
 * for (int right = 0; right < s.length(); right++) {
 * char rc = s.charAt(right);
 * if (need.containsKey(rc)) {
 * need.put(rc, need.get(rc) - 1);
 * if (need.get(rc) >= 0) {
 * // 필요한 것을 채웠을 때에는 감소
 * missing--;
 * }
 * }
 * 
 * while (missing == 0) {
 * if (right - left + 1 < bestLen) {
 * bestLen = right - left + 1;
 * bestL = left;
 * }
 * 
 * char lc = s.charAt(left);
 * if (need.containsKey(lc)) {
 * need.put(lc, need.get(lc) + 1);
 * if (need.get(lc) > 0) {
 * missing++;
 * }
 * }
 * left++;
 * }
 * }
 * return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestL, bestL +
 * bestLen);
 * 
 * 2-1 문자열 포함 여부 검사
 * char rc = s.charAt(right);
 * if (need.containsKey(rc)) {
 * need.put(rc, need.get(rc) - 1);
 * if (need.get(rc) >= 0) {
 * // 필요한 것을 채웠을 때에는 감소
 * missing--;
 * }
 * }
 * 
 * 반복문의 통해 char 값을 꺼내고 해당 char 값이 Map에 저장되어 있는지 확인한다.
 * 만약 Map에 저장되어 있다면, Map의 value 값을 감소해준다.
 * 감소한 후에 해당 map의 value가 0보다 크거나 같다면, 즉 t에 존재하는 char 값이 해당 문자열에 존재한다면, missing
 * 변수를 감소시킨다.
 * 
 * 2-2 왼쪽 포인터 이동하여 최적의 길이 찾기
 * while (missing == 0) {
 * if (right - left + 1 < bestLen) {
 * bestLen = right - left + 1;
 * bestL = left;
 * }
 * 
 * char lc = s.charAt(left);
 * if (need.containsKey(lc)) {
 * need.put(lc, need.get(lc) + 1);
 * if (need.get(lc) > 0) {
 * missing++;
 * }
 * }
 * left++;
 * }
 * 
 * 현재 오른쪽과 왼쪽 포인터의 길이가 지금까지 찾은 최적의 문자열 길이 보다 작다면 bestLen 값을 해당 값으로 변경한다.
 * 그리고 bestL 값 또한 현재 왼쪽 포인터의 값으로 갱신한다.
 * 왼쪽 포인터의 char 값을 가져와 해당 char가 Map에 존재한다면, 하나를 되돌려 놔야 한다. 왜냐하면 left를 하나 증가하기
 * 때문에 기존 왼쪽 포인터가 가지고 있던 값을 다시 보관해야 하기 때문이다. 만약 Map에 해당 값이 0보다 크다면 missing을 증가하고
 * while문은 종료된다.
 * 
 * 
 * 3. return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestL, bestL +
 * bestLen);
 * 조건에 충족하지 않을경우에는 빈 문자열을 리턴하고, 아니라면 최적의 길이의 substring 을 리턴한다.
 */