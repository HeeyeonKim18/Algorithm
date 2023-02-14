package main.set_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()) ;
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            A.add(Integer.parseInt(st1.nextToken()));
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            B.add(Integer.parseInt(st2.nextToken()));
        }

        int count = 0;
        Iterator<Integer> it = A.iterator();
        while(it.hasNext()){
            if(!B.contains(it.next())) count++;
        }
        it = B.iterator();
        while(it.hasNext()){
            if(!A.contains(it.next())) count++;
        }

        System.out.println(count);
    }
}
