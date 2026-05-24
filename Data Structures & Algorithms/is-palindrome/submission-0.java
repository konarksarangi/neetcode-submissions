class Solution {
    public boolean isPalindrome(String s) {
        String modifiedS = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int l=0,r=modifiedS.length()-1;

        while (l<r){
            if (modifiedS.charAt(l) != modifiedS.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
        
    }
}
