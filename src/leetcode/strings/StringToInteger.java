package leetcode.strings;
public class StringToInteger {
    public static void main(String[] args) {
        String str = " -2147483649";
        System.out.println(myAtoi(str));
    }
    public static int myAtoi(String s) {
        final int len = s.length();
        
        // If len is less than 0, return 0
        if(len == 0){
            return 0;
        }
        
        // Remove white spaces
        int index = 0;
        while(index < len && s.charAt(index) == ' '){
            index++;
        }
        
        // If s is equal to ' ', return 0;
        if(index == len){
            return 0;
        }
        
        char ch;
        boolean isNegative = (ch = s.charAt(index)) ==  '-';
        
        // Check the sign (-ve or +ve)
        if(isNegative || ch == '+'){
            ++index;
        }
            
        // Add each character & avoid overflow
        int result = 0;
        while(index < len && isDigit(ch = s.charAt(index))){
            
            int digit = ch - '0';
            
            if(result > (Integer.MAX_VALUE - digit) / 10)
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            
            result = (result * 10) + digit;
            
            ++index;
        }
        
        return isNegative ? -result : result;
    }
    
    // Check whether it is digit or not
    private static boolean isDigit(char ch){
        return ch >= '0' && ch <= '9';
    }
}
