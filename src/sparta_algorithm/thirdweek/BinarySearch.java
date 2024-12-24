package sparta_algorithm.thirdweek;

// 이진 탐색을 통해 해당 인덱스를 찾는 문제
// 정렬이 되어 있다는 것을 가정
public class BinarySearch {
    private static int[] nums = {-1, 0, 3, 5, 9, 12};
    public static void main(String[] args) {
        System.out.println(binarySearch(9));
        System.out.println( binarySearch(2));
    }

    private static int binarySearch(int num){
        return search(num, 0, nums.length -1);
    }

    private static int search(int num, int begin, int end){
        // 종료 조건: begin > end면 값을 찾지 못한 것이므로 -1 반환 
        if(begin > end) return -1;

        // 중앙값 구하기 (오버플로 방지)
        int mid = begin + (end - begin) / 2;

        if(num == nums[mid]) return mid;    // 값을 찾은 경우 
        else if(num > nums[mid]) return search(num, mid + 1, end);  // 오른쪽 절반 탐색
        else return search(num, begin, mid - 1);    // 왼쪽 절반 탐색
    }
}
