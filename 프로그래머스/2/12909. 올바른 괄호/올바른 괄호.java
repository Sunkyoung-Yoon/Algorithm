import java.util.Stack;
class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<Character>(); // 괄호를 담을 스택
        
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i); // 괄호 하나
            
            // ')'이 나오면 push
            if(ch == '(') 
                stack.push(ch);
            
            // ')' 나오고 stack이 안 비어있다면 pop
            else {
                if(!stack.isEmpty()) 
                    stack.pop();
                // 비어있는데, ')'가 나오면 올바르지 않은 괄호
                else
                    return false;
            }
        }
        
        // '('가 남아있는 경우 올바르지 않은 괄호
        if(!stack.isEmpty()) return false;
        
        return true;

        
    }
}