class Solution {
    public boolean isValid(String s) {
        Stack<Character> bracketStack = new Stack<>();
        Map<Character,Character> closeToOpen = new HashMap<>();

        closeToOpen.put(')','(');
        closeToOpen.put(']','[');
        closeToOpen.put('}','{');

        //({[]})

        for(char c: s.toCharArray()){
            if(closeToOpen.containsKey(c)){
                if(!bracketStack.isEmpty() && bracketStack.peek()==closeToOpen.get(c)){
                    bracketStack.pop();
                }else{
                    return false;
                }
            }else{
                bracketStack.push(c);
            }

        }
        return bracketStack.isEmpty();
    }
}
