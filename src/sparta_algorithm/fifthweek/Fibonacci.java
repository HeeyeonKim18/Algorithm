package sparta_algorithm.fifthweek;

public class Fibonacci {
    
    static int[] dp;
    public static void main(String[] args) {
        int n = 10;
        dp = new int[n+1];
        System.out.println(fibo(n));
        System.out.println(memoization(n));
        System.out.println(fiboRecursive(10));
    }

    private static int fibo(int n){
        if(n == 1 || n == 2) return 1;
        else return dp[n] = fibo(n-1) + fibo(n-2);
    }

    private static int fiboRecursive(int n){
        if(n == 1 || n == 2) return 1;
        if(dp[n] != 0) return dp[n];
        else {
            return dp[n] = fibo(n-1) + fibo(n-2);
        }
    }

    private static int memoization(int n){
        dp[1] = 1;

        for(int i = 2; i < n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
