class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0,length=0;

        Set<Character> characterSet = new HashSet<>();

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
