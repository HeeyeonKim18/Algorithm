public class ReverseInteger {
    public static void main(String[] args) {
        int x = -120;
        System.out.println(reverse(x));
        System.out.println(reverse1(x));
    }

    public static int reverse(int x){
        int res = 0;
        boolean isNegative = x < 0;
        String strX = String.valueOf(Math.abs(x));
        StringBuilder sb = new StringBuilder(strX).reverse();

        try{
            res = Integer.parseInt(sb.toString());
        }catch(NumberFormatException e){
            return 0;
        }

        return isNegative ? -res:res;
    }

    public static int reverse1(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }

        int res = 0;
        while (x > 0) {
            int digit = x % 10;
            x /= 10;
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return 0;
            }
            res = (res * 10) + digit;
        }

        return isNegative ? -res : res;        
    }
}
