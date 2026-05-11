class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap <Integer,Integer> numAndIndex= new HashMap<>();

        for (int i=0; i<nums.length; i++){
            int difference = target-nums[i];
            if(numAndIndex.containsKey(difference)){
                return new int[]{numAndIndex.get(difference),i};
            }
            numAndIndex.put(nums[i],i);
        }
        return new int[]{};
        
    }
}
