package fourweeks;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumber2(nums));
        System.out.println(missingNumber3(nums));
    }

    private static int missingNumber(int[] nums){
        boolean[] countNums = new boolean[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            countNums[nums[i]] = true;
        }

        for(int i = 1; i < countNums.length; i++){
            if(!countNums[i]) return i;
        }

        return 0;
    }

    private static int missingNumber2(int[] nums){
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    private static int missingNumber3(int[] nums){
        int n = nums.length;
        int xor = 0;

        for(int i = 0; i <= n; i++){
            xor ^= i;
        }

        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}
