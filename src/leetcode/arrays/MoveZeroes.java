// Given an integer array nums, 
// move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};

        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                arr[idx++] = arr[i]; 
            }
        }

        for(int i = idx; i < arr.length; i++){
            arr[i] = 0;
        }
    }
}
