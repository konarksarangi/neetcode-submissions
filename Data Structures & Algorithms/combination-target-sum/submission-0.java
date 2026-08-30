class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> current = new ArrayList<>();

        backtrack(current,nums,target,0);
        return result;

    }

    private void backtrack(List<Integer> current,int[] nums,int target,int index){
        if(target == 0){
            result.add(new ArrayList(current));
            return;
        }
        if(target < 0 || index>=nums.length){
            return;
        }
        current.add(nums[index]);
        backtrack(current,nums,target-nums[index],index);
        current.remove(current.size()-1);
        backtrack(current,nums,target,index+1);

    }

}
