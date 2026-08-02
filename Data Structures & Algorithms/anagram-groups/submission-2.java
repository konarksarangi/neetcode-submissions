class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> stringMap= new HashMap<>();

        for(String str:strs){
            char[] charKey = new char[26];
            for(char c:str.toCharArray()){
                charKey[c-'a']++;
            }
            String charString = Arrays.toString(charKey);
            stringMap.putIfAbsent(charString,new ArrayList<>());
            stringMap.get(charString).add(str);
        }

        return new ArrayList<>(stringMap.values());
        
    }
}
