class Solution {
    public long solution(int price, int money, int count) {
        long answer = money;
        for(int i=1; i<=count; i++){
            answer -=price*i;
        }
        
        if(answer<0) //부족한 금액 양수로 표현
            answer *= -1;
        else //금액 부족하지 않은 경우 0으로 변경
            answer = 0;

        return answer;
    }
}