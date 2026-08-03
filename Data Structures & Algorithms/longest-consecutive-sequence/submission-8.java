class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }
        int length=0;
        int maxLength=0;

        for (int num:nums){
            if(!numSet.contains(num-1)){
                int currentNum=num;
                length=1;
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
