class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty()){
            return 0;
        }else if(s.isBlank()){
            return 1;
        }
    
        Set <Character> characterSet = new HashSet<>();
        //abcabcbb
        int l=0,r=0,length=0;

        while (r<s.length()){
            if(characterSet.contains(s.charAt(r))){
                characterSet.remove(s.charAt(l));
                l++;
            }else{
                characterSet.add(s.charAt(r));
                length = Math.max(length,r-l+1);
                r++;
            }
        }
        return length;
    }
}
