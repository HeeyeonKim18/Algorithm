package main.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n]; // 입력 값 저장할 배열

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());   // 입력 값
        }

        int num = 1;    // 스택에 삽입될 값
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            if(arr[i] >= num){
                while(arr[i] >= num){   // 배열의 값이 스택에 삽입되는 값보다 같거나 클 때
                    s.push(num++);      // 스택에 값 추가하기
                    sb.append("+").append("\n");
                }
                s.pop();    // top == arr[i]과 같기 때문에 pop()
                sb.append("-").append("\n");
            }else{      // 입력 값보다 크다면?
                int top = s.pop();  // 현재 top에 위치한 값을 제거

                if(top != arr[i]){  // 해당 값이 배열 값과 동일하지 않다면 ?
                    System.out.println("NO");   // "NO" 출력 후 시스템 종료
                    System.exit(0);
                }
                else{
                    sb.append("-").append("\n");
                }
            }
        }
        System.out.println(sb); // 출력

    }
}
