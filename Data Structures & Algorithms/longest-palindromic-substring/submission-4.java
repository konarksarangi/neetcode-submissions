class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }
        int resultLength=0;
        String result = "";

        for (int i=0;i<s.length();i++){
            //Odd length
            int l=i,r=i;
            while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1 > resultLength){
                    resultLength=r-l+1;
                    result = s.substring(l,r+1);
                }
                l--;
                r++;
            }
            //Even length
            l=i;
            r=i+1;
            while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1 > resultLength){
                    resultLength=r-l+1;
                    result = s.substring(l,r+1);
                }
                l--;
                r++;
            }
        }
        return result;
    }
}
