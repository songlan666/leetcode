public class MaxProfit {
    public static void main(String[] args) {
        int[] temp = {0,1,2,3,4,5,6,8,9};
        Solution solution = new Solution();
        int count = solution.maxProfit(temp);
        System.out.println(count);
    }
}

class Solution {
    public int maxProfit(int[] prices) {


        if (prices.length == 0 || prices == null) return 0;

        int minPrices = Integer.MAX_VALUE;
        int maxProfit = 0;

//方法一：蛮力法
        // for (int i = 0; i < prices.length - 1; i++) {
        //     for (int j = i + 1; j < prices.length; j++) {
        //         if (maxProfit < (prices[j] - prices[i])) {
        //             maxProfit = prices[j] - prices[i];
        //         }
        //         // if (prices[i] < minPrices) {
        //         //     minPrices = prices[i];
        //         // } else if (maxProfit < (prices[j] - minPrices)) {
        //         //     maxProfit = prices[j] - minPrices;
        //         // }
        //     }
        // }
        // return maxProfit;

//方法二：
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrices) {
                minPrices = prices[i];
            }
            int currentDiff = prices[i] - minPrices;
            if (currentDiff > maxProfit) {
                maxProfit = currentDiff;
            }
        }
        return maxProfit;
    }
}