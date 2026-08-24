class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0;
        int maxLength=0;

        Map<Character,Integer> charMap = new HashMap<>();

        while(r<s.length()){
            charMap.put(s.charAt(r),charMap.getOrDefault(s.charAt(r),0)+1);
            if((r-l+1)-Collections.max(charMap.values()) <=k){
                maxLength=Math.max(maxLength,r-l+1);
            }else{
                charMap.put(s.charAt(l),charMap.get(s.charAt(l))-1);
                l++;
            }
            r++;
        }
        return maxLength;
    }
}
