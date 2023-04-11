import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        //리스트에 재료 정보 저장
        for(int i=0; i<ingredient.length; i++){
            stack.push(ingredient[i]);
            
            //스택의 4개이상 쌓이면
            if(stack.size() >=4){
                //햄버거 만드는 순서대로 쌓였다면
                if(stack.get(stack.size()-4)==1
                  && stack.get(stack.size()-3)==2
                  && stack.get(stack.size()-2)==3
                  && stack.get(stack.size()-1)==1){
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
                    
            }
        }
        
        return answer;
    }
}