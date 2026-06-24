class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> countMap = new HashMap<>();
        int longestPalindromeLength = 0;

        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            countMap.put(c,countMap.getOrDefault(c,0)+1);
            if(countMap.get(c) % 2 ==0){
                longestPalindromeLength+=2;
            }
        }
        if(longestPalindromeLength < s.length()){
            longestPalindromeLength+=1;
        }

        return longestPalindromeLength;

        
    }
}