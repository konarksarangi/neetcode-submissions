class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<1){
            return 0;
        }
        Set<Character> stringSet = new HashSet<>();
        int l=0,r=0;
        int maxLength=0;
        while(r<s.length()){
            char c=s.charAt(r);
            if(!stringSet.contains(c)){
                stringSet.add(c);
                maxLength=Math.max(maxLength,r-l+1);
                r++;
            }else{
                stringSet.remove(s.charAt(l));
                l++;
            }
        }
        return maxLength;
    }
}
