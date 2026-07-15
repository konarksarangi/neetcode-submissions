class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        Map<Character,Integer> sHashMap = new HashMap<>();
        Map<Character,Integer> tHashMap = new HashMap<>();

        for (int i=0;i<s.length();i++){
            sHashMap.put(s.charAt(i),sHashMap.getOrDefault(s.charAt(i),0)+1);
            tHashMap.put(t.charAt(i),tHashMap.getOrDefault(t.charAt(i),0)+1);
        }
        if(sHashMap.equals(tHashMap)){
            return true;
        }
        return false;
    }
}
