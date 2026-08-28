class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        buildRecursive(nums,current,0,result);
        return result;
    }

    private void buildRecursive(int[] nums, List<Integer> current, int index, List<List<Integer>> result){
        if(index==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        buildRecursive(nums,current,index+1,result);

        current.remove(current.size()-1);
        buildRecursive(nums,current,index+1,result);

    }
}
