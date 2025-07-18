package fourweeks;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aab";
        String magazine = "baa";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        int[] charCnt = new int[26];

        if (ransomNote.length() > magazine.length())
            return false;

        for (char c : magazine.toCharArray()) {
            charCnt[c - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int idx = ransomNote.charAt(i) - 'a';
            charCnt[idx]--;
            if (charCnt[idx] < 0)
                return false;
        }
        return true;
    }
}
