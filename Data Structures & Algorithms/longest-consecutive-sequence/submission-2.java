class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int lengthCounter=1;
        int longestLengthCounter=1;

        for(int i=0;i<nums.length;i++){
            if(i == nums.length-1){
                break;
            }
            if(nums[i]+1 == nums[i+1]){
                lengthCounter++;
            }else if(nums[i+1]-nums[i] > 1){
                if (lengthCounter > longestLengthCounter){
                    longestLengthCounter=lengthCounter;
                }
                lengthCounter=1;
            }
        }
            if (lengthCounter > longestLengthCounter){
                longestLengthCounter=lengthCounter;
        }
        return longestLengthCounter;
    }
}
