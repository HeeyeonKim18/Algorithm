package fourweeks;

public class ClimbStairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
    }

    private static int climbStairs(int n){
        int[] ways = new int[n + 1];
        ways[0] = 0;
        ways[1] = 1;

        if(n >= 2){
            ways[2] = 2;
            for(int i = 3; i < ways.length; i++){
                ways[i] = ways[i -1] + ways[i - 2];
            }
        }
        return ways[n];
    }
}
