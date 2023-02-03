import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
        
        Stack<Character> stack = new Stack<>();
        int index = 0;
        
        //스택이 빌 때까지 
        while(index<s.length()){
            char ch = s.charAt(index++);
            
            //빈 스택이거나 스택 top에 있는 값!=ch라면
            if(stack.isEmpty() || stack.peek()!=ch) {
                stack.push(ch);
            }
            //스택 top에 있는 값==ch라면 pop()
            else {
                stack.pop();
            }
            
        }
        
        //모두 pop()했다면 짝지어 제거하기 성공
        if(stack.isEmpty()) return 1;
        
        return 0;
    }
}