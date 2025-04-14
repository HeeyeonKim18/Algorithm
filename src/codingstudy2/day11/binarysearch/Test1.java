package codingstudy2.day11.binarysearch;

/**
 * 정렬된 N개의 숫자 중, 주어진 값 X가 존재하는지 이분 탐색으로 구현해보자.
 */
public class Test1 {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = { 1, 3, 5, 7, 9, 11 };
        int x = 5;

        // arr가 정렬되어 있음으로 sort()는 지금 사용하지 않아도 됨
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] == x) {
                System.out.println("YES");
                return;
            } else if (arr[mid] > x) {
                high = mid + 1;
            } else {
                low = mid - 1;
            }
        }
        System.out.println("NO");
    }
}
