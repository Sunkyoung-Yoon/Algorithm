class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if(a>b){ //a가 더 크면 a와 b 값 서로 변경
            int temp = a;
            a = b;
            b = temp;
        }
       
        for(int i=a; i<=b; i++)
            answer+=i;
        
        return answer;
    }
}