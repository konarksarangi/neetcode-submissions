class Solution {
    public int rob(int[] nums) {
        //Base cases
        if(nums.length==0){
            return 0;
        }else if(nums.length==1){
            return nums[0];
        }
        //Main logic
        return Math.max(robHouse(nums,0,nums.length-2),robHouse(nums,1,nums.length-1));
    }

    public int robHouse(int[] nums,int start,int end){
        int maxSum1=0;
        int maxSum2=0;

        for (int i=start;i<=end;i++){
            int current=Math.max(maxSum1,maxSum2+nums[i]);
            maxSum2=maxSum1;
            maxSum1=current;
        }
        return maxSum1;
    }
}
