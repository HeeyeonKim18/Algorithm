package main.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14889 {
    static int N;
    static int[][] table;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 수 입력 받기

        table = new int[N][N];  // 사람 간의 능력치
        visited = new boolean[N];   // 방문 여부

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken()); // 능력치 입력
            }
        }

        combi(0, 0);    // 메서드 실행

        System.out.println(min);    // 최소값 출력
    }

    private static void combi(int idx, int cnt) {   // idx: 인덱스, cnt: 조합한 수의 개수
        if (cnt == N / 2) { // N를 2로 나눈 수가 cnt와 같은 경우. 즉, 두 그룹으로 나눌 때 양팀 인원이 같을 경우
            diff(); // 메서드 실행
            return; // 재귀함수 종료
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {  // 방문하지 않았을 때
                visited[i] = true;  // 방문 완료
                combi(i + 1, cnt + 1);  // 재귀 함수 호출
                visited[i] = false; // 재귀 함수 종료 시 방문하지 않음으로 변경
            }
        }
    }


    private static void diff() {
        int team_start = 0; // 스타트의 능력치 합
        int team_link = 0;  // 링크 능력치 합

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i]==true && visited[j]==true) { // 방문 여부 true인 사람은 스타트 팀
                    team_start += table[i][j];
                    team_start += table[j][i];
                } else if (visited[i]==false && visited[j]==false) {    // 방문 여부 false인 사람은 링크 팀
                    team_link += table[i][j];
                    team_link += table[j][i];
                }
            }
        }
        int val = Math.abs(team_start - team_link); // 두 팀의 능력치 차

        if (val == 0) { // 0일 경우, 최소값이기에 바로 출력 후 시스템 종료
            System.out.println(0);
            System.exit(0);
        }

        min = Math.min(min, val);   // 아니라면, 최소값 구하기
    }
}
