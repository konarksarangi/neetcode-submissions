class Solution {

    public String encode(List<String> strs) {
        String encodeDelimiter="#";
        StringBuilder encodedString = new StringBuilder();
        for(String str:strs){
            encodedString.append(str.length());
            encodedString.append(encodeDelimiter);
            encodedString.append(str);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        final char delimiter='#';
        List<String> result = new ArrayList<>();
        int i=0;
        int j=0;
        while (i <str.length()){
            if(str.charAt(i) == delimiter){
                int length = Integer.parseInt(str.substring(j,i));
                String subStringPart = str.substring(i+1,i+1+length);
                j=i+1+length;
                result.add(subStringPart);
                i+=length;
            }
            i++;
        }
        return result;
    }
}
