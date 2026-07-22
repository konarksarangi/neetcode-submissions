class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int length=0,maxLength=0;

        for (int num:nums){
            numSet.add(num);
        }

        for (int num:numSet){
            if(!numSet.contains(num-1)){
                int currentNum=num;
                length=1;
                while (numSet.contains(currentNum+1)){
                    currentNum++;
                    length++;
                }
                maxLength=Math.max(maxLength,length);
            }
        }
        return maxLength;
    }
}
