class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }else if(s.length() ==1){
            return 1;
        }
        int l=0,r=0;
        int length=0,maxLength=0;
        Set<Character> charSet = new HashSet<>();

        while (r<s.length()){
            if(!charSet.contains(s.charAt(r))){
                charSet.add(s.charAt(r));
                 maxLength=Math.max(maxLength,r-l+1);
                 r++;
           }else{
                charSet.remove(s.charAt(l));
                l++;
            }
        }
        return maxLength;
    }
}
