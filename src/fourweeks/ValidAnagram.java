package fourweeks;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "car";
        String t = "rat";
        System.out.println(isAnagram1(s, t));
        System.out.println(isAnagram2(s, t));
    }

    private static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            cnt[c - 'a']--;
        }

        return Arrays.equals(cnt, new int[26]);
    }

    private static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar, tChar);

    }
}
