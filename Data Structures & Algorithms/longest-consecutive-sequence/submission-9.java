class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int length=0,maxLength=0;

        for(int num:nums){
            numSet.add(num);
        }

        for(int num:nums){
            length=1;
            int currentNum=num;
            if(!numSet.contains(num-1)){
                while(numSet.contains(currentNum+1)){
                    length++;
                    currentNum++;
                }
                maxLength=Math.max(maxLength,length);
            }
        }
        return maxLength;
    }
}
