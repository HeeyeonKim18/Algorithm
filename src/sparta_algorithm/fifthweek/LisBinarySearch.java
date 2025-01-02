package sparta_algorithm.fifthweek;

import java.util.Scanner;

public class LisBinarySearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[] seq = new int[N];
        int[] lis = new int[N];

        for(int i = 0; i < N; i++){
            seq[i] = in.nextInt();
        }

        lis[0] = seq[0];
        int lengthOflis = 1;

        for(int i = 1; i < N; i++){
            int key = seq[i];

            if(lis[lengthOflis - 1] < key){
                lengthOflis++;
                lis[lengthOflis - 1] = key;
            }else{
                int lo = 0;
                int hi = lengthOflis;

                while (lo < hi) {
                    int mid = (lo + hi) / 2;

                    if(lis[mid] < key){
                        lo = mid + 1;
                    }else{
                        hi = mid;
                    }
                }

                lis[lo] = key;
            }
        }
        System.out.println(lengthOflis);
        in.close();
    }
}
