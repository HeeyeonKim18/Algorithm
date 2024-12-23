package sparta_algorithm.thirdweek;

import java.util.Scanner;

public class NQueen {

    static int[] arr;
    static int N;
    static int count = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    private static void nQueen(int depth){
        // 모든 원소를 다 채운 상태라면 count 증가 및 return
        if(depth == N){
            count++;
            return;
        }

        for(int i = 0; i < N; i++){
            // 해당 열, i행에 위치하기
            arr[depth] = i;

            // 놓을 수 있는 위치일 경우에는 재귀 호출
            if(possibility(depth)){
                nQueen(depth + 1);
            }
        }
    }

    private static boolean possibility(int col){

        for(int i = 0; i < col; i++){
            // 해당 열의 행과 i열의 행이 같은 행에 존재할 경우
            if(arr[col] == arr[i]) return false;

            // 대각선상에 놓여있는 경우 -> 행과 열의 길이가 동일함
            // Math.abs(col - i): 행
            // Math.abs(arr[col] - arr[i]): 열
            else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) return false;
        }

        return true;
    }
}
