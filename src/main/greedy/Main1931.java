package main.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Meeting> list = new ArrayList<>(); // 회의실 시간을 저장할 리스트
        StringTokenizer st;
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            list.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list); // 정렬하기

        System.out.println(greedy(list));   // 메소드 실행 및 출력
    }

    private static int greedy(List<Meeting> list) {
        int time = 0;   // 시작 시간
        int count = 0;  // 회의실 수 카운트
        
        for (Meeting meeting : list) {
            if(time <= meeting.start){  // 시작 시간보다 클 경우
                time = meeting.end; // 시간에 종료시간 대치
                count++;
            }
        }
        return count;
    }

    public static class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {   // 정렬
            // 종료시간 동일하다면, 시작시간으로 정렬
            if(this.end == o.end){
               return this.start - o.start;
            }
            return this.end - o.end;    // 종료시간 비교
        }
    }
}
