class Solution {
    public int longestConsecutive(int[] nums) {
        //9,1,4,7,3,-1,0,5,8,-1,6
        //-1,-1,0,1,3,4,5,6,7,8,9
        Set<Integer> consecutiveSet = new HashSet<>();
        int length=0;
        int maxLength=0;

        for (int num:nums){
            consecutiveSet.add(num);
        }
        for(int num:consecutiveSet){
            if(!consecutiveSet.contains(num-1)){
                int currentNum = num;
                length=1;
                while (consecutiveSet.contains(currentNum+1)){
                    currentNum++;
                    length++;
                }
                maxLength=Math.max(maxLength,length);
            }
        }

        return maxLength;

    }
}
