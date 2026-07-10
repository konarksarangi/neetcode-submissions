class Solution {
    public int climbStairs(int n) {
        if(n<3){
            return n;
        }
        int [] result = new int[3];
        result[0]=1;
        result[1]=2;

        for (int i=2;i<n;i++){
            result[i%3]=result[(i-1)%3]+result[(i-2)%3];
        }

        return result[(n-1)%3];

        
    }
}
