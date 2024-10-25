package Algorithm.src.leetcode.strings;
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "ad:p d,a";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;

        int i = 0, j = s.length() - 1;
        while(i < j){
            char front = s.charAt(i);
            char back = s.charAt(j);
            if(!Character.isLetterOrDigit(front)) i++;
            else if(!Character.isLetterOrDigit(back)) j--;
            else{
                if(Character.toLowerCase(front) != Character.toLowerCase(back)) return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
