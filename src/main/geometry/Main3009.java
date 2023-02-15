package main.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");
        String[] c = br.readLine().split(" ");

        int x = 0;
        int y = 0;

        if(a[0].equals(b[0]))
            x = Integer.parseInt(c[0]);
        else if(a[0].equals(c[0]))
            x = Integer.parseInt(b[0]);
        else
            x = Integer.parseInt(a[0]);

        if(a[1].equals(b[1]))
            y = Integer.parseInt(c[1]);
        else if(a[1].equals(c[1]))
            y = Integer.parseInt(b[1]);
        else
            y = Integer.parseInt(a[1]);

        System.out.println(x + " " + y);
    }
}
