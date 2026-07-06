class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> tokenStack = new Stack<>();

        for (String token : tokens){
            if(token.equals("+")){
                tokenStack.push(tokenStack.pop()+tokenStack.pop());
            }else if(token.equals("*")){
                tokenStack.push(tokenStack.pop()*tokenStack.pop());
            }else if(token.equals("-")){
                int a = tokenStack.pop();
                int b = tokenStack.pop();
                tokenStack.push(b-a);
            }else if(token.equals("/")){
                int a = tokenStack.pop();
                int b = tokenStack.pop();
                tokenStack.push(b/a);
            }else{
                tokenStack.push(Integer.parseInt(token));
            }
        }
        return tokenStack.pop();
    }
}
