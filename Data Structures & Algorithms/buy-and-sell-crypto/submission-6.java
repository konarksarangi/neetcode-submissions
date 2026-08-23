class Solution {
    public int maxProfit(int[] prices) {
        int l=0,r=1;
        int profit=0,maxProfit=0;

        while (r<prices.length){
            profit=Math.max((prices[r]-prices[l]),0);
            maxProfit=Math.max(maxProfit,profit);
            if(prices[l]>=prices[r]){
                l=r;
            }
            r++;
        }
        return maxProfit;
    }
}
