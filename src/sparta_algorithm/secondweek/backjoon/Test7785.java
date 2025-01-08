package sparta_algorithm.secondweek.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Test7785 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        TreeSet<String> set = new TreeSet<>();
        StringBuilder sb = new StringBuilder();

        while(n-- > 0){
            String[] input = br.readLine().split(" ");
            if(input[1].equals("enter")){
                set.add(input[0]);
            }else{
                set.remove(input[0]);
            }
        }

        for (String str : set.descendingSet()) {
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}
