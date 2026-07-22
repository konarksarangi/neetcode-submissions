class Solution {
    private final char delimiter='#';

    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str:strs){
            stringBuilder.append(str.length());
            stringBuilder.append(String.valueOf(delimiter));
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
        //["Hello","World"] -> "5#Hello5#World"
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int length = str.length();
        int i=0,j=0;
        while (i<length){
            if(str.charAt(i)==delimiter){
                int currStringLength=Integer.parseInt(str.substring(j,i));
                String sub = str.substring(i+1,i+1+currStringLength);
                result.add(sub);
                j=i+1+currStringLength;
                i=i+currStringLength;
            }
            i++;
        }
        return result;
    }
}
