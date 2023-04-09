package main.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2751_1 {
    static int[] arr;
    static int[] tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        tmp = new int[N];

        sort(0, arr.length - 1);

        for(int i = 0; i < N; i++){
            System.out.println(arr[i]);
        }

    }

    private static void sort(int i, int j) {
        if(i !=j){
            int mid = (i+j)/2;
            sort(i, mid);
            sort(mid + 1, j);
            merge(i, mid, j);
        }
    }

    private static void merge(int i, int mid, int j) {
        int left = i;
        int right = mid +1;
        int idx = i;

        while(left <= mid && right <= j){
            if (arr[left] <= arr[right]) {
                tmp[idx] = arr[left];
                idx++;
                left++;
            }else{
                tmp[idx] = arr[right];
                idx++;
                right++;
            }
        }

        if(left > mid){
            while(right <= j){
                tmp[idx] = arr[right];
                idx++;
                right++;
            }
        }else{
            while(left <= mid){
                tmp[idx] = arr[left];
                idx++;
                left++;
            }
        }
        for(int k = i; k <= j; k++){
            arr[k] = tmp[k];
        }
    }

}
