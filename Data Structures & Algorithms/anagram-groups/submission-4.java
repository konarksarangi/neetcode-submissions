class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagramMap = new HashMap<>();

        for(String str:strs){
            char[] charKey = new char[26];

            for(char c:str.toCharArray()){
                charKey[c-'a']++;
            }

            String charString = new String(charKey);
            anagramMap.putIfAbsent(charString,new ArrayList<>());
            anagramMap.get(charString).add(str);
        }
        return new ArrayList<>(anagramMap.values());
    }
}
