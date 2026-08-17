class Solution {
    public int maxArea(int[] heights) {
        int l=0,r=heights.length-1;
        int length=0,maxLength=0;

        while (l<r){
            length = Math.min(heights[l],heights[r]) * (r-l);
            maxLength = Math.max(length,maxLength);
            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxLength;
    }
}
