package fourweeks;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }

    private static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (!set.contains(n)) {
            set.add(n);
            n = getNextNumber(n);
            if (n == 1)
                return true;
        }
        return false;
    }

    private static int getNextNumber(int n) {
        int output = 0;
        while (n > 0) {
            int digit = n % 10;
            output += digit * digit;
            n = n / 10;
        }
        return output;
    }
}
