class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> braceMap = new HashMap<>();
        braceMap.put(')','(');
        braceMap.put('}','{');
        braceMap.put(']','[');
        Stack<Character> charStack = new Stack<>();

        for(Character c:s.toCharArray()){
            if(braceMap.containsKey(c)){
                if(!charStack.isEmpty() && charStack.peek()==braceMap.get(c)){
                    charStack.pop();
                }else{
                    return false;
                }
            }else{
                charStack.push(c);
            }
        }
        return charStack.isEmpty();
    }
}
