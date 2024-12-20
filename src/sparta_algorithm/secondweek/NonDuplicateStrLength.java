package sparta_algorithm.secondweek;

import java.util.HashMap;
import java.util.Map;

public class NonDuplicateStrLength {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(getLength(s));
    }
    
    private static int getLength(String s){
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(map.containsKey(c)) return result;

            map.put(c, map.getOrDefault(map, 0) + 1);
            result += map.get(c);
        }
        return s.length();
    }
}
