package codingstudy2.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 소문자와 * 하나로 이루어진 패턴과 맞는지 확인하는 문제
 * 입력 1번: 1 <= n <= 100
 * 2번: 패턴
 * 3번: n개의 파일 이름
 * 
 * 출력: 해당 파일의 이름이 패턴과 일치하는지(DA || NE)
 * 별표는 무조건 가운데 위치
 * 그 외엔 소문자 들어간다는 것은 무조건 두 그룹으로 나뉜다는 사실
 */
public class Test9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();

        String first = "";
        String last = "";
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (c == '*') {
                first = pattern.substring(0, i);
                last = pattern.substring(i + 1, pattern.length());
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String fileName = br.readLine();

            if (fileName.length() < first.length() + last.length()) {
                sb.append("NE\n");
                continue;
            }

            if (fileName.substring(0, first.length()).equals(first)
                    && fileName.substring(fileName.length() - last.length()).equals(last)) {
                sb.append("DA");
            } else {
                sb.append("NE");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
