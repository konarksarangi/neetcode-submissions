class Solution {
    private final char delimeter = '#';

    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();
        for(String str:strs){
            s.append(str.length());
            s.append(String.valueOf(delimeter));
            s.append(str);
        }
        return s.toString();
        //["Hello","World"] -> "5#Hello5#World"
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int j=0;
        int i=0;
        while (i<str.length()){
            if(str.charAt(i)==delimeter){
                int currentLength=Integer.parseInt(str.substring(j,i));
                String temp = str.substring(i+1,i+1+currentLength);
                result.add(temp);
                j=i+1+currentLength;
                i=i+currentLength;
            }
            i++;
        }
        return result;
    }
}
