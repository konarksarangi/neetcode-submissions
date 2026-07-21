class Solution {
    public int maxSubArray(int[] nums) {
        int maxResult=nums[0];
        int result=0;
        for (int num:nums){
            if(result<0){
                result=0;
            }
            result+=num;
            maxResult=Math.max(maxResult,result);
        }
        return maxResult;
        
    }
}
