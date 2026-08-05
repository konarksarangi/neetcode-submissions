class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }else if(s.length()==1){
            return 1;
        }

        Set<Character> charSet = new HashSet<>();
        int l=0,r=0;
        int length=0,maxLength=0;

        while(r<s.length()){
            char c = s.charAt(r);
            if(!charSet.contains(c)){
                charSet.add(c);
                maxLength=Math.max(r-l+1,maxLength);
                r++;
            }else{
                charSet.remove(s.charAt(l));
                l++;
            }
        }

        return maxLength;

    }
}
