class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        //9,1,4,7,3,-1,0,5,8,-1,6
        //-1,-1,0,1,3,4,5,6,7,8,9
        int longestSequence=1;
        int lastLongestSequence=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i==nums.length-1){
                break;
            }
            if(nums[i]+1 == nums[i+1]){
                longestSequence++;
            }else if((nums[i+1] - nums[i]) > 1){
                lastLongestSequence=Math.max(lastLongestSequence,longestSequence);
                longestSequence=1;
            }
        }
        return Math.max(lastLongestSequence,longestSequence);
    }
}
