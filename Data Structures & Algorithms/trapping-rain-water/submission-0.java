class Solution {
    public int trap(int[] height) {
        if(height == null || height.length==0){
            return 0;
        }
        
        int l=0;
        int r = height.length-1;

        int leftMaxValue=height[l];
        int rightMaxValue=height[r];

        int totalWaterValue=0;

        while (l < r){
            if(leftMaxValue < rightMaxValue){
                l++;
                leftMaxValue = Math.max(leftMaxValue,height[l]);
                totalWaterValue += leftMaxValue-height[l];
            }else{
                r--;
                rightMaxValue = Math.max(rightMaxValue,height[r]);
                totalWaterValue += rightMaxValue - height[r];
            }
        }
        return totalWaterValue;
    }
}
