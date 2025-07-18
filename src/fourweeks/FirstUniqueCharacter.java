package fourweeks;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(firstUniqChar(s));
    }

    private static int firstUniqChar(String s) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
