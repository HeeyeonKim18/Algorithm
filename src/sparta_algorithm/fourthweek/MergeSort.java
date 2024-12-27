package sparta_algorithm.fourthweek;

public class MergeSort {
    private static int[] result;
    public static void main(String[] args) {
        int[] arr = {4,6,2,9,1};
        result = new int[arr.length];
        mergeSort(arr);
    }

    private static void mergeSort(int[] arr){
        sort(arr, 0, arr.length -1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
   
    private static void sort(int[] arr, int start, int end){
        if(start == end) return;
        int mid = (start + end) / 2;

        sort(arr, start, mid);
        sort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int l, int m, int r){
        int left = l;
        int right = m + 1;
        int idx = l;

        while(left <= m && right <= r){

            if(arr[left] <= arr[right]){
                result[idx++] = arr[left++];
            }else{
                result[idx++] = arr[right++];
            }
        }

        if(left > m){
            while(right <= r){
                result[idx++] = arr[right++];
            }
        }else {
            while(left <= m){
                result[idx++] = arr[left++];
            }
        }

        for(int i = l; i <= r; i++){
            arr[i] = result[i];
        }
    }
    
}
