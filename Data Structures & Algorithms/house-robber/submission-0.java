class Solution {
    public int rob(int[] nums) {
        int prev1=0;
        int prev2=0;

        for(int money:nums){
            int current=Math.max(prev2+money,prev1);
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }
}
