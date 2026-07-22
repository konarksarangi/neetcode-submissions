class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Base case

        Arrays.sort(nums);
        //-1,0,1,2,-1,-4 -> -4,-1,-1,0,1,2
        int l=0,r=nums.length-1;
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<nums.length-1;i++){
            l=i+1;
            r=nums.length-1;
            while (l<r){
                if(nums[i]+nums[l]+nums[r] == 0){
                    if(!result.contains(Arrays.asList(nums[i],nums[l],nums[r]))){
                        result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    }
                    l++;
                    r--;
                }else if(nums[i]+nums[l]+nums[r] > 0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return result;
    }
}
