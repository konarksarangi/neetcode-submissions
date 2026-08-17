class Solution {
    public int maxProfit(int[] prices) {
        int profit=0,maxProfit=0;
        int l=0,r=1;

        while (r<prices.length){
            profit=Math.max(prices[r]-prices[l],0);
            maxProfit=Math.max(maxProfit,profit);
            if(prices[l]>=prices[r]){
                l=r;
            }
            r++;
        }
        return maxProfit;
    }
}
