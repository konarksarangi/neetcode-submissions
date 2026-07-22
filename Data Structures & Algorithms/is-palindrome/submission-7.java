class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()<2){
            return true;
        }
        String stripped = s.replaceAll("[^0-9A-Za-z]","").toLowerCase();
        int l=0,r=stripped.length()-1;
        while (l<r){
            if(stripped.charAt(l)!=stripped.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
