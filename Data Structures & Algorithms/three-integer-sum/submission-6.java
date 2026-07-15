class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3){
            return new ArrayList<>();
        }
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        //[-1,0,1,2,-1,-4]
        //[-4,-1,-1,0,1,2]
        int l=0,r=nums.length-1;
        for(int i=0;i<nums.length-2;i++){
            l=i+1;
            r=nums.length-1;
            while (l<r){
                if(nums[i]+nums[l]+nums[r] == 0){
                    if(!results.contains(Arrays.asList(nums[i],nums[l],nums[r]))){
                        results.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    }
                    l++;
                    r--;
                }else if(nums[i]+nums[l]+nums[r] <0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return results;

    }
}
