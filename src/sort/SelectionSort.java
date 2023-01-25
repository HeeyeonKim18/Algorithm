package sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		SelectionSort ss = new SelectionSort();
		ss.sort();

	}

	private void sort() {
		// 정렬할 배열
		int[] arr = { 33, 23, 64, 15, 29, 18 };
		
		for (int i = 0; i < arr.length -1; i++) {
			// 최소 값을 가진 배열 인덱스를 찾는 변수	
			int min = i;
			
			for (int j = 1 + i; j < arr.length; j++) {
				// 배열[min]값과 비교해 작다면 j을 min으로 대치
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			
			// 불필요한 교환을 위해 min값과 min의 초기값과 같지 않을때만 swap
			if (i != min) {
				int tmp = arr[i];
				arr[i] = arr[min];
				arr[min] = tmp;
			}
		}
		// 선택 정렬한 배열 출력
		System.out.println(Arrays.toString(arr));

	}

}
//Time Complexity: The time complexity of Selection Sort is O(N2) as there are two nested loops:
//
//One loop to select an element of Array one by one = O(N)
//Another loop to compare that element with every other Array element = O(N)
//Therefore overall complexity = O(N) * O(N) = O(N*N) = O(N2)
//
//Auxiliary Space: O(1) as the only extra memory used is for temporary variables while swapping two values in Array. The selection sort never makes more than O(N) swaps and can be useful when memory write is a costly operation. 


