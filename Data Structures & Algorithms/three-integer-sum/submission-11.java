class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length <3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        int l=0,r=nums.length-1;
        List<List<Integer>> results = new ArrayList<>();

        for (int i=0;i<nums.length;i++){
            l=i+1;
            r=nums.length-1;
            while (l<r){
                if(nums[i]+nums[l]+nums[r] ==0){
                    if(!results.contains(Arrays.asList(nums[i],nums[l],nums[r]))){
                        results.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    }
                    l++;
                    r--;
                }else if(nums[i]+nums[l]+nums[r] >0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return results;
    }
}
