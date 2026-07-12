class Solution {
    public int countSubstrings(String s) {
        int resultLength=0;
        String result="";
        int count=0;

        for (int i=0;i<s.length();i++){
            //Odd length
            int l=i,r=i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                count++;
                l--;
                r++;
            }

            //Even length
            l=i;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                count++;
                l--;
                r++;
            }
        }
        return count;
    }
}
