package sort_intermediate;

import java.util.Arrays;

// 퀵정렬
public class QuickSort {

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] arr = {10, 7, 8, 9, 1, 5};
		qs.quickSort(arr, 0, arr.length -1);
		System.out.println(Arrays.toString(arr));

	}
	
	//재귀 호출
	private void quickSort(int[] arr, int i, int j) {
		if(i < j) {
			int idx = quick(arr, i, j);
			
			quickSort(arr, i, idx -1);
			quickSort(arr,idx+1, j);
			
		}
		
	}
	
	// 정렬
	private int quick(int[] arr, int start, int end) {
		int pivot = arr[start]; // 피벗 포인트
		int swapIdx = start; // 교체할 인덱스 자리
		
		for(int i = start + 1; i < arr.length; i++) {
			if(pivot > arr[i]) {
				swapIdx++;
				swap(arr,swapIdx, i);
				System.out.println(Arrays.toString(arr));
			}
		}
		swap(arr,start, swapIdx);
		return swapIdx;

	}
	
	// 교체
	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}

}
// Time Complexity: O(n log n)
// Time Complexity(worst): O(n^2)
// Space Complexity: O(log n)