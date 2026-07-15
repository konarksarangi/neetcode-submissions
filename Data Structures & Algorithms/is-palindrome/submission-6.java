class Solution {
    public boolean isPalindrome(String s) {
        String standardized = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        int l=0,r=standardized.length()-1;
        while(l<r){
            if(standardized.charAt(l)!=standardized.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
