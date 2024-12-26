package sparta_algorithm.fourthweek;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,6,2,9,1};
        int[] arr2 = {3,2,1,5,3,2,3};
        quick(arr);
        quick(arr2);
    }

    // arr 받아서 퀵정렬 알고리즘 실행
    private static void quick(int[] arr) {
       sort(arr, 0, arr.length -1);

       // print array
       for (int i : arr) {
            System.out.print(i + " ");
       }
       System.out.println();
    }

    private static void sort(int[] arr, int i, int j) {
        // i가 j보다 크거나 같다면 바로 리턴하기
        if(i >= j) return;

        // pivot 설정하기, 파티션 나누기
        int pivot = partition(arr, i, j);
        
        // 나누어진 array로 정렬하기 recursive
        sort(arr, i, pivot - 1);
        sort(arr, pivot + 1, j);
    }

    private static int partition(int[] arr, int low, int high) {
        // pivot보다 작은 수가 존재 여부를 모르니, i는 -1로 설정
        int i = low - 1;
        // pivot 값은 오른쪽 가장 마지막 값으로 설정
        int pivot = arr[high];

        // i는 pivot보다 작은 수를 알기 위한 것
        // j는 pivot과 값을 비교하기 위한 것으로 0부터 시작해서 끝까지 
        for(int j = low; j < high; j++){

            // 만약 비교하는 값이 pivot보다 작거나 같다면?
            if(arr[j] <= pivot){
                // pivot보다 작으니까 i를 하나 증가시키기
                i++;
                // i와 j가 동일하면 swap이 일어나도 변화가 없음
                // 동일하지 않다면 i, j 값을 바꿔주기
                swap(arr, i, j);
            }
        }
        // for문이 다 돌았다면, pivot값과 i + 1 값 변경
        // i는 이전에 이야기 했던 대로 pivot보다 작은 값의 인덱스로 +1 pivot이 작은 값과 큰 값 사이에 위치하게 됨 
        swap(arr, i + 1, high);

        // pivot의 값을 리턴하기
        return i + 1;
    }
            
    private static void swap(int[] arr, int lo, int hi) {
        int temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }

}
