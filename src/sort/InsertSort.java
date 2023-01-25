package sort;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		InsertSort is = new InsertSort();
		is.sort();
	}

	private void sort() {
		int[] arr = {3,19,8,83,46,32};
		
		for(int i = 1; i < arr.length; i++) {
			int val = arr[i];
			int j = i -1;
			
			// j가 0보다 작거나 arr[j] 값이 arr[i]보다 클 때 반복문을 빠져나간다.
			while(j >=0 && arr[j] > val) {
				// 한칸씩 밀어내기
				arr[j+1] = arr[j];
				j = j-1;
			}
			// 작은 값 삽입해주기
			arr[j+1] = val;
		}
		System.out.println(Arrays.toString(arr));
		
	}
}
//Time Complexity: O(N^2) 
//Auxiliary Space: O(1)
