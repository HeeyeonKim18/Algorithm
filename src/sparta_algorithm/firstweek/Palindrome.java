package sparta_algorithm.firstweek;

public class Palindrome {
    public static void main(String[] args) {
        String str = "python";
        boolean result = isPalindrome(str);
        System.out.println(result);
    }

    private static boolean isPalindrome(String str){
        int i = 0;
        int j = str.length() - 1;
        while(i < j){
            if(str.charAt(i)!= str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}