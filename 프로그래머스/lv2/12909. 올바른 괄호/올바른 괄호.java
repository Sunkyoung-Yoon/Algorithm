import java.util.Stack;
class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<Character>();
        
        //짝을 이루기 전에 모두 
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch=='('){
                stack.push(ch);
            }
            // '(' 다음에 ')'이 나오면 짝을 이룸 -> pop()
            else{
                // '(' 다음에 ')'가 나와야 올바른 괄호
                // '((('이라면 스택이 빈상태에서 pop -> 올바르지 않은 괄호
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        
        if(!stack.isEmpty()) return false;
        
        return true;

        
    }
}