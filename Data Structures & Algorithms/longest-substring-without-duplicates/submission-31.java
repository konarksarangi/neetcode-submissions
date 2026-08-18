class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength=0;
        int l=0,r=0;

        Set<Character> charSet = new HashSet<>();

        while(r<s.length()){
            char c=s.charAt(r);
            if(!charSet.contains(c)){
                charSet.add(c);
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
