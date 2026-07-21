class Solution {
    public int rob(int[] nums) {
        int maxSum1=0;
        int maxSum2=0;
        
        for (int num:nums){
            int current=Math.max(maxSum1,num+maxSum2);
            maxSum2=maxSum1;
            maxSum1=current;
        }
        return maxSum1;
    }
}
