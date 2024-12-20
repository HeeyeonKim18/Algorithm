package amazon;

import java.util.*;

public class SystemThroughput {
    public static void main(String[] args) {
        // Host throughput 리스트 선언
        List<Long> hostThroughput = Arrays.asList(8L, 6L, 3L, 4L, 4L, 5L, 6L);

        // 내림차순 정렬
        Collections.sort(hostThroughput, Collections.reverseOrder());

        long systemThroughput = 0;
        int clusters = hostThroughput.size() / 3;

        // 세 개씩 묶어서 중앙값을 계산하고 시스템 처리량에 더함
        for (int i = 0; i < clusters * 3; i += 3) {
            // 각 클러스터 세 개의 값을 가져옴
            List<Long> cluster = hostThroughput.subList(i, i + 3);
            
            // 클러스터 값을 정렬하여 중앙값을 구함
            Collections.sort(cluster);
            
            // 중앙값 (정렬된 후 두 번째 값)
            long median = cluster.get(1);
            systemThroughput += median;
        }

        System.out.println("Maximum System Throughput: " + systemThroughput);
    }
}
