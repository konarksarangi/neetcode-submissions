class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for (String str:strs){
            int[] chars = new int[26];
            for(char c:str.toCharArray()){
                chars[c-'a']++;
            }
            String finalChars = Arrays.toString(chars);
            map.putIfAbsent(finalChars,new ArrayList<>());
            map.get(finalChars).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
