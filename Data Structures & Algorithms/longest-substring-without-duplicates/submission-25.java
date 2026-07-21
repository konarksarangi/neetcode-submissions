class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        else if(s.isBlank() || s.length()==1){
            return 1;
        }

        int l=0,r=0;
        Set<Character> charSet = new HashSet<>();
        int maxLength=0;

        
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
