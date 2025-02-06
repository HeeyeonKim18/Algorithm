package codingstudy.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2529 {
    static int k;
    static boolean[] visited = new boolean[10];
    static char[] signs;
    static List<String> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        signs = br.readLine().replace(" ", "").toCharArray();

        dfs("", 0);

        Collections.sort(results);
        System.out.println(results.get(results.size() - 1));
        System.out.println(results.get(0));
    }

    static void dfs(String str, int depth) {

        if (depth == k + 1) {
            results.add(str);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                if (depth == 0 || isValid(str.charAt(depth - 1) - '0', i, signs[depth - 1])) {
                    visited[i] = true;
                    dfs(str + i, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    static boolean isValid(int a, int b, char sign) {
        if (sign == '<')
            return a < b;
        else
            return a > b;
    }
}
