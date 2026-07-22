class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] results = new int[length];
        results[0]=1;
        //1,2,4,6
        for (int i=1;i<nums.length;i++){
            results[i] = results[i-1]*nums[i-1];
        }
        //result 0=1,1=2,2=8,3=48
        int suffix=1;
        for(int i=length-1;i>=0;i--){
            results[i]=suffix*results[i];
            suffix*=nums[i];
        }
        return results;
    }
}
