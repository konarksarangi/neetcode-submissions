class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        // [-1,0,1,2,-1,-4] -> [-4,-1,-1,0,1,2]
        for (int i=0; i<nums.length-2;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int l=i+1,r=nums.length-1;
            while (l<r){
                if (nums[i]+nums[l]+nums[r] == 0 ){
                    boolean exists = results.contains(Arrays.asList(nums[i],nums[l],nums[r]));
                    if(!exists){
                         results.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    }
                    l++;
                    r--;
                }else if (nums[i]+nums[l]+nums[r] > 0){
                    r--;
                }else{
                    l++;
                }
            }

        }
        return results;
        
    }
}
