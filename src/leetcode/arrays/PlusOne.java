public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9,8,7,6,5,4,3,2,1,0};

        long value = 0;
        long pos = 1;
        for (int i = digits.length -1 ; i >= 0; i--) {
            value += (digits[i] * pos);
            pos *= 10;
        }
        value++;
        
        char[] charArr = String.valueOf(value).toCharArray();

        int[] result = new int[charArr.length];

        for (int i = 0; i < charArr.length; i++) {
            result[i] = (int) charArr[i] - 48;
        }

        System.out.println(value);
    }
}