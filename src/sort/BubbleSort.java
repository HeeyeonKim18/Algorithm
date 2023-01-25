package sort;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) throws Exception {
		BubbleSort B = new BubbleSort();
		long start = System.nanoTime();
		B.bubble();
		long end = System.nanoTime();
		System.out.println("끝까지 정렬: " + (end - start));
		long s = System.nanoTime();
		B.bubble2();
		long e = System.nanoTime();
		System.out.println("브레이크 사용: " + (e -s));
		
	}
	// i와 j 모두 오름으로 설정하고 정렬하는 법
	// 버블 정렬은 숫자 간의 정렬이 다되더라도 마지막 턴까지 계속 돌아간다.
	// 불필요한 행동을 제거하고 정렬을 최적화하기 위해 noSwap이라는 boolean 변수를 이용해서 
	// swap이 일어나지 않으면 반복문을 빠져나올 수 있게 해야 한다.
	private void bubble2() {
		boolean noSwap;
		int[] arr = {8,1,2,3,4,5,6};
		
		for(int i = 1; i < arr.length - 1; i++) {
			noSwap = true;
			for(int j = 0; j < arr.length - i; j++) {
				if(arr[j]> arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					noSwap = false;
				}
			}
			if(noSwap) break;
		}
		System.out.println(Arrays.toString(arr));
		
	}
	// i는 감소 j는 증가시켜서 정렬하는 법
	private void bubble() {
		int[] arr = {8,1,2,3,4,5,6};
		
		for(int i = arr.length ; i > 0; i--) {
			for(int j = 0; j < i -1; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
	}
}
// Time Complexity: O(N2)
// Auxiliary Space: O(1) 

