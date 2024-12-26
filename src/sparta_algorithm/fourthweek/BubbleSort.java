package sparta_algorithm.fourthweek;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4,6,2,9,1};
        int[] arr2 = {3,2,1,5,3,2,3};
        bubble(arr);
        bubble(arr2);
    }
        
    private static void bubble(int[] arr) {
        int len = arr.length - 1;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len - i; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
