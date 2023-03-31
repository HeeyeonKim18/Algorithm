package main.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12891 {
    static int[] contain;   // 비밀번호 체크 배열
    static int[] mine;  // 입력 값 비밀번호 값 포함 확인 배열
    static int check;   // 모든 조건이 충족되었는지 확인하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] checkArr = br.readLine().toCharArray();  // 문자열 입력
        contain = new int[4];
        check = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            contain[i] = Integer.parseInt(st.nextToken()); // 부분 문자열에 포함되어야 할 문자 개수 입력
            if (contain[i] == 0) check++;
        }
        mine = new int[4];
        int cnt = 0;

        for (int i = 0; i < P; i++) {
            getCheck(checkArr[i]);  // 유효한 비밀번호인지 확인
        }
        if (check == 4) cnt++;  // 조건에 충족한다면 카운트 변수 증가

        for (int i = P; i < S; i++) {
            int j = i - P;
            getCheck(checkArr[i]);  // 뒤에 들어온 하나의 값이 유효한 값인지 확인
            remove(checkArr[j]);    // 제거되는 문자열, 배열 값 되돌리기
            if(check == 4) cnt++;
        }

        System.out.println(cnt);
    }

    private static void remove(char c) {    // 배열을 한 칸씩 뒤로 이동했을 때 빠지는 문자열
        switch (c) {
            case 'A':
                if (mine[0] == contain[0]) check--;
                mine[0]--;
                break;
            case 'C':
                if (mine[1] == contain[1]) check--;
                mine[1]--;
                break;
            case 'G':
                if (mine[2] == contain[2]) check--;
                mine[2]--;
                break;
            case 'T':
                if (mine[3] == contain[3]) check--;
                mine[3]--;
                break;
        }
    }

    private static void getCheck(char i) {  // 배열을 한 칸씩 뒤로 이동했을 때 더해지는 문자열
        switch (i) {
            case 'A':
                mine[0]++;
                if (mine[0] == contain[0]) check++;
                break;
            case 'C':
                mine[1]++;
                if (mine[1] == contain[1]) check++;
                break;
            case 'G':
                mine[2]++;
                if (mine[2] == contain[2]) check++;
                break;
            case 'T':
                mine[3]++;
                if (mine[3] == contain[3]) check++;
                break;
        }
    }
}
