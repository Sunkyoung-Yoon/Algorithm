class Solution {
    public String solution(int num) {
        //기본 세팅 홀수
        String answer = "Odd";
        
        //짝수이면 Even로 변경
        if(num%2==0) answer = "Even";
        
        return answer;
    }
}