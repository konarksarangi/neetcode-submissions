class Solution {
    public int findMin(int[] nums) {

        int l=0,r=nums.length-1,m=0;
        int result =nums[0];
        //[1,2,3,4,5] -> [3,4,5,1,2]
        while (l<=r){
            if(nums[l]<nums[r]){
                result = Math.min(nums[l],result);
                break;
            }
            m=(l+r)/2;
            result=Math.min(result,nums[m]);
            if (nums[m]>=nums[l]){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return result;
    }
}
