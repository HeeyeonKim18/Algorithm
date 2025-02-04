package codingstudy.newyear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구현 다 못함함
public class Test12425 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken()); // 한 팀당 말의 수
            int n = Integer.parseInt(st.nextToken()); // 던져진 윷의 개수
            int a = Integer.parseInt(st.nextToken()); // A팀 말 개수
            int b = Integer.parseInt(st.nextToken()); // B팀 말 개수

            // 말의 위치 저장 배열
            int[] pointsA = new int[a];
            int[] pointsB = new int[b];

            // A팀 차례일 경우 true, B팀 차례일 경우 false
            boolean isATurn = true;

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                String point = st.nextToken();

                // 이동할 말을 선택하는 로직 필요 (현재 가장 앞에 있는 말을 움직이는 방식으로 가정)
                if (isATurn) {
                    isATurn = movePoint(point, pointsA);
                } else {
                    isATurn = movePoint(point, pointsB);
                }
            }
        }
    }

    private static boolean movePoint(String point, int[] states) {
        if (states.length == 0)
            return false; // 이동할 말이 없으면 종료

        // 가장 앞에 있는 말을 이동하는 방식 (기본 구현)
        int moveIdx = 0;
        int[] specialMoves = { 5, 10, 22 };
        int[] specialTargets = { 19, 24, 26 };

        // 이동 거리 설정
        int moveDistance = 0;
        boolean extraTurn = false;

        switch (point) {
            case "Do":
                moveDistance = 1;
                break;
            case "Gae":
                moveDistance = 2;
                break;
            case "Gul":
                moveDistance = 3;
                break;
            case "Yut":
                moveDistance = 4;
                extraTurn = true;
                break;
            case "Mo":
                moveDistance = 5;
                extraTurn = true;
                break;
        }

        // 이동 적용
        states[moveIdx] += moveDistance;

        // 특수 이동 적용
        for (int i = 0; i < specialMoves.length; i++) {
            if (states[moveIdx] == specialMoves[i]) {
                states[moveIdx] = specialTargets[i];
                break;
            }
        }

        return extraTurn; // 윷이나 모가 나왔으면 현재 팀이 한 번 더 진행
    }
}
