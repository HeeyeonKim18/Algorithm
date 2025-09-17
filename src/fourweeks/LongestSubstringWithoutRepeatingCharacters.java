package fourweeks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Given a string s, 
// find the length of the longest substring without duplicate characters.
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));

        System.out.println("Way: The last position where each character was seen");
        System.out.println(mapVer(s));
        System.out.println(mapVer("bbbbbb"));
        System.out.println(mapVer("pwwkew"));
    }

    private static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int max = 0;

        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);

            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            right++;
            max = Math.max(max, right - left);
        }

        return max;
    }

    private static int mapVer(String s) {
        int maxLen = 0;
        int left = 0;

        Map<Character, Integer> last = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            Integer prev = last.get(c);
            if (prev != null && prev >= left) {
                left = prev + 1;
            }
            last.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

}