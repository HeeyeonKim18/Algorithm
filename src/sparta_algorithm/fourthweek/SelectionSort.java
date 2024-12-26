package sparta_algorithm.fourthweek;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4,6,2,9,1};
        int[] arr2 = {3,2,1,5,3,2,3};
        select(arr);
        select(arr2);
    }
        
    private static void select(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < len - 1; i++){
            int min = i;
            for(int j = i + 1; j < len; j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            int tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
