package sparta_algorithm.fifthweek;

public class Theater {

    static int[] dp;
    public static void main(String[] args) {
        int n = 9;
        int[] vips = {3,6};
        System.out.println(totalCases(n, vips));
    }

    private static int totalCases(int n, int[] vips){
        dp = new int[n+1];
        fibo(n);

        int ans = 1;
        int beforeVips = 0;

        for (int i : vips) {
            int range = dp[i - 1 - beforeVips]; 
            ans *= dp[range];
            beforeVips = i;
        }

        ans *= dp[n - beforeVips];

        return ans;
    }

    private static void fibo(int n){
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

    }
}
