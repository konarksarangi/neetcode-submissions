class Solution {
    public int search(int[] nums, int target) {
        if (nums.length<1){
            return -1;
        }else if(nums.length ==1){
            if (nums[0]==target){
                return 0;
            }else{
                return -1;
            }
        }
        int l=0,r=nums.length;

        while (l<r){
            int midPoint = (l+r)/2;
            if(nums[midPoint]==target){
                return midPoint;
            }else if(nums[midPoint] < target){
                l=midPoint+1;
            }else{
                r=midPoint;
            }
        }
        return -1;
        
    }
}
