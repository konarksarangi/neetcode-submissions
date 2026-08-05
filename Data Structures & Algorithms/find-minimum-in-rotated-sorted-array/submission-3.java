class Solution {
    public int findMin(int[] nums) {
        int mid = 0;
        int l=0,r=nums.length-1;
        int min=nums[0];

        while(l<=r){
            mid = l+(r-l)/2;
            if(nums[mid]<min){
                min=nums[mid];
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return min;
    }
    
}
