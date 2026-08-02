class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> sumMap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int reminder = target-nums[i];
            if(sumMap.containsKey(reminder)){
                return new int[]{sumMap.get(reminder),i};
            }
            else{
                sumMap.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}
