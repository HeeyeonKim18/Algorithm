package search;

import java.util.Scanner;

public class BinarySearch {
	private int find(int[] arr, int input) {
		int start = 0;
		int end = arr.length -1;
		int mid = (start + end) /2;
		while(arr[mid] != input && start <= end) {
			if(input < arr[mid]) {
				end = mid -1;
			}else if(input > arr[mid]) {
				start = mid +1;
			}
			mid =(start + end) /2;
		}
		return arr[mid] == input ? mid: -1;
	}
	
	private void search() {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열 길이 설정: ");
		int num = sc.nextInt();
		int[] arr = new int[num];
		
		for(int i = 0; i < num; i++	) {
			System.out.println("X[" + i + "] : ");
			arr[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값: ");
		int input = sc.nextInt();
		
		int result = find(arr, input);

		if(result == -1) {
			System.out.println("해당 값이 존재하지 않습니다.");
		}else {
			System.out.println(input + "값은 X[" + result + "]에 위치하고 있습니다.");
		}
	}
	
	public static void main(String[] args) {
		BinarySearch s = new BinarySearch();
		s.search();

	}
}
//public class BinarySearch {
//	static int[] arr = {1, 3, 5, 7, 8, 10, 20, 35, 99, 100};
//
//	public static void main(String[] args) {
//		System.out.println("1. 순환 호출을 이용한 이진 탐색");
//		System.out.println(binarySearch1(5, 0, arr.length-1)); // 2
//		
//		System.out.println("\n2. 반복을 이용한 이진 탐색");
//		System.out.println(binarySearch2(20, 0, arr.length-1)); // 6
//		
//	}
//	
//	// 재귀적 탐색
//	static int binarySearch1(int key, int low, int high) {
//		int mid;
//		
//		if(low <= high) {
//			mid = (low + high) / 2;
//			
//			if(key == arr[mid]) { // 탐색 성공 
//				return mid;
//			} else if(key < arr[mid]) {
//				return binarySearch1(key ,low, mid-1); // 왼쪽 부분 탐색 
//			} else {
//				return binarySearch1(key, mid+1, high); // 오른쪽 부분 탐색 
//			}
//		}
//		
//		return -1; // 탐색 실패 
//	}
//	
//	// 반복적 탐색
//	static int binarySearch2(int key, int low, int high) {
//		int mid;
//		
//		while(low <= high) {
//			mid = (low + high) / 2;
//			
//			if(key == arr[mid]) {
//				return mid;
//			} else if(key < arr[mid]) {
//				high = mid - 1;
//			} else {
//				low = mid + 1;
//			}
//		}
//		
//		return -1; // 탐색 실패 
//	}
//
//}
