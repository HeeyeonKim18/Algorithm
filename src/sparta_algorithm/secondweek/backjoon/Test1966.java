package sparta_algorithm.secondweek.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test1966 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<Document> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine()," ");
            int[] priorityCnt = new int[10];    // 중요도를 저장하는 배열

            for(int i = 0; i < n; i++){
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Document(i, priority));
                priorityCnt[priority]++;    // 각 중요도의 문서 개수 증가
            }

            int count = 0;
            for(int i = 9; i > 0; i--){ // 중요도 9 ~ 1까지 확인
                while(priorityCnt[i] > 0){  // 해당 중요도의 문서가 있을 경우
                    Document cur = queue.poll();

                    if(cur.importance == i){    // 현재 문서가 가장 높은 중요도라면
                        count++;
                        priorityCnt[i]--;   // 해당 중요도 문서 개수 감소

                        if(cur.idx == m){   // 찾는 문서라면
                            sb.append(count).append("\n");
                            break;
                        }
                    }else{
                        // 중요도가 낮다면 뒤로 보냄
                        queue.offer(cur);
                    }
                }
            }
        }

        System.out.println(sb);
    }

    static class Document{

        int idx;
        int importance;

        public Document(int idx, int importance) {
            this.idx = idx;
            this.importance = importance;
        }
    }
}
