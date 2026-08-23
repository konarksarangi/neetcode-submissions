class Solution {
    private final char delimiter='#';

    public String encode(List<String> strs) {
        StringBuilder strbuild = new StringBuilder();
        for(String str:strs){
            strbuild.append(str.length());
            strbuild.append(String.valueOf(delimiter));
            strbuild.append(str);
        }
        return strbuild.toString();
    }
    //10#HelloHello3#How
    public List<String> decode(String str) {
        int i=0,j=0;
        int stringLength=0;
        List<String> result = new ArrayList<>();
        while(i<str.length()){
            char c=str.charAt(i);
            if(c==delimiter){
                stringLength = Integer.parseInt(str.substring(j,i));
                result.add(str.substring(i+1,i+1+stringLength));
                j=i+1+stringLength;
                i=i+stringLength;
            }
            i++;
        }
        return result;
    }
}
