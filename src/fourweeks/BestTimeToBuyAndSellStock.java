package fourweeks;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 3, 9, 1, 2};
        System.out.println(maxProfit(prices));;
    }

    private static int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            // 배열을 순회하면서 지금까지의 최소 값을 저장
            minPrice = Math.min(minPrice, prices[i]);
            
            // 최소 값보다 현재 값이 클 경우에는 maxProfix 값을 업데이트 
            if(minPrice < prices[i]){
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }

}
