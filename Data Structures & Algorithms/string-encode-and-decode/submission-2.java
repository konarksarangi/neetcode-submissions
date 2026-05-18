class Solution {

    public String encode(List<String> strs) {
        String encodeDelimiter="#";
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs){
            encodedString.append(str.length());
            encodedString.append(encodeDelimiter);
            encodedString.append(str);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String>result= new ArrayList<>();
        int i = 0;
        int j=0;
        while (i<str.length()){
            j=i;
            while(str.charAt(j) != '#' ){
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            result.add(str.substring(j+1,j+length+1));
            i = j+length+1;
        }
        return result;
    }
}
