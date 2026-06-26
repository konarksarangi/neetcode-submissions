class Solution {
    public boolean isPalindrome(String s) {
        String formattedString = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int l=0,r=formattedString.length()-1;
        boolean isPalindrome=false;
        while(l<r){
            if(formattedString.charAt(l) != formattedString.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
