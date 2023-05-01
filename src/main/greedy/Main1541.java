package main.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 수는 무조건 양수이기에 초기 상태 여부를 확인을 위한 값
        int sum = Integer.MAX_VALUE;

        // 뺄셈으로 문자 값 나누기
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        
        while(st.hasMoreTokens()){
            int temp = 0;   // 덧셈 값 저장

            // 덧셈으로 문자 값 나누기
            StringTokenizer token = new StringTokenizer(st.nextToken(), "+");

            while(token.hasMoreTokens()){
                temp += Integer.parseInt(token.nextToken());
            }

            // 첫 번째 수라면 양수로 저장되도록 설정
            if(sum == Integer.MAX_VALUE){
                sum = temp;
            }else{  // 그 외의 수는 다 뺄셈이 되도록 설정
                sum -= temp;
            }
        }
        System.out.println(sum);    // 출력
    }
}
