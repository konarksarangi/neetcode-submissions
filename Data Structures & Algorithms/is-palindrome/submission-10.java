class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() < 2){
            return true;
        }
        String lowercaseS = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        int l=0,r=lowercaseS.length()-1;
        while (l<r){
            if(lowercaseS.charAt(l)!=lowercaseS.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
