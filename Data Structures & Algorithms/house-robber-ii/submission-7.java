class Solution {
    public int rob(int[] nums) {
        if(nums.length<=1){
            return nums[0];
        }
        return Math.max(countMax(nums,0,nums.length-2),countMax(nums,1,nums.length-1));
        
    }

    private int countMax(int[] nums, int start, int end){
        int maxSum1=0,maxSum2=0;

        for (int i=start;i<=end;i++){
            int current = Math.max(maxSum1,maxSum2+nums[i]);
            maxSum2=maxSum1;
            maxSum1=current;
        }
        return maxSum1;
    }
}
