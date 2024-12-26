package sparta_algorithm.fourthweek;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4,6,2,9,1};
        int[] arr2 = {3,2,1,5,3,2,3};
        insertion(arr);
        insertion(arr2);
    }
        
    private static void insertion(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < len - 1; i++){
            for(int j = i + 1; j > 0; j--){
                if(arr[j] < arr[j - 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
            
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
