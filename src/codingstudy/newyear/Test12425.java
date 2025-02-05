package codingstudy.newyear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test12425 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // 한 팀당 사용가능한 말의 수
            int u = Integer.parseInt(st.nextToken());
            // 던져진 윷의 목록 개수
            int n = Integer.parseInt(st.nextToken());
            // 놓여진 A팀의 말 개수
            int a = Integer.parseInt(st.nextToken());
            // 놓여진 B팀의 말 개수
            int b = Integer.parseInt(st.nextToken());

            // 말의 위치를 저장한 배열
            int[] pointsA = new int[a];
            int[] pointsB = new int[b];

            // A차례일 경우 true, B차례일 경우 false
            boolean isATurn = true;

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                String point = st.nextToken();
                if (isATurn) {
                    isATurn = movePoint(point, pointsA);
                } else {
                    isATurn = movePoint(point, pointsB);
                }

            }
        }
    }

    private static boolean movePoint(String point, int[] state) {
        if (state.length == 0)
            return false;

        // 가장 앞에 있는 말을 이동하는 방식(기본 구현)
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
        state[moveIdx] += moveDistance;

        // 특수 이동 적용
        for (int i = 0; i < specialMoves.length; i++) {
            if (state[moveIdx] == specialMoves[i]) {
                state[moveIdx] = specialTargets[i];
                break;
            }
        }

        return extraTurn;
    }
}
