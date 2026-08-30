class Solution {
    public int rob(int[] nums) {
        int maxSum1=0,maxSum2=0;

        for(int num:nums){
            int current=Math.max(maxSum1,maxSum2+num);
            maxSum2=maxSum1;
            maxSum1=current;
        }
        return maxSum1;
    }
}
