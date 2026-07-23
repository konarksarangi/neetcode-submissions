class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> charMap = new HashMap<>();
        charMap.put(')','(');
        charMap.put('}','{');
        charMap.put(']','[');

        Stack<Character> charStack = new Stack<>();
        
        for(char c:s.toCharArray()){
            if(charMap.containsKey(c)){
                if(!charStack.isEmpty() && charStack.peek()==charMap.get(c)){
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
