package sparta_algorithm.fourthweek;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1,4,2,10,5};
        heapSort(arr);
    }

    private static void heapSort(int[] arr){
        Heap<Integer> heap = new Heap<>(arr.length);

        for (int i : arr) {
            heap.add(i);
        }

        for(int i = 0; i < arr.length; i++){
            System.out.print(heap.remove() + " ");
        }
    }
}
