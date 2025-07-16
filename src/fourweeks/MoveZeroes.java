package fourweeks;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        moveZeroes(nums);
    }

    private static void moveZeroes(int[] nums){
        int left = 0; 
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0 ){
                nums[left++] = nums[i];
            }
        }

        while (left < nums.length) {
            nums[left++] = 0;
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
