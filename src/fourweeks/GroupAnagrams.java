package fourweeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        groupAnagrams(strs);
        groupAnagrams1(strs);
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        int[] alphabet;
        StringBuilder sb;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            alphabet = new int[26];
            sb = new StringBuilder();
            for (char c : strs[i].toCharArray()) {
                alphabet[c - 'a']++;
            }
            for (int cnt : alphabet) {
                sb.append(cnt).append('#');
            }
            map.putIfAbsent(sb.toString(), new ArrayList<String>());
            map.get(sb.toString()).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }

    private static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            groups.putIfAbsent(sorted, new ArrayList<String>());
            groups.get(sorted).add(str);
        }

        return new ArrayList<>(groups.values());
    }

}
