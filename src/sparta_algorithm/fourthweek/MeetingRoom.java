package sparta_algorithm.fourthweek;

import java.util.Arrays;

public class MeetingRoom {
    public static void main(String[] args) {
        int[][] arr = {{0,6},{1,4},{3,5},{3,8},{5,7},{8,9}};
        int[][] arr2 = {{1,3},{2,4},{5,8},{6,10},{8,11},{10,12}};
        System.out.println(findMax(arr));
        System.out.println(findMax(arr2));
    }

    private static int findMax(int[][] arr){

        if(arr == null || arr.length == 0) return 0;

        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        int cnt = 1;
        int lastEndTime = arr[0][1];

        for(int i = 1; i < arr.length; i++){
            if(arr[i][0] >= lastEndTime){
                cnt++;
                lastEndTime = arr[i][1];
            }
        }

        return cnt;
    }
}
