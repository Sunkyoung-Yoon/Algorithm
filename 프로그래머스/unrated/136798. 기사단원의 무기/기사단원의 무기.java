class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        //약수 개수 구하기
        for(int i=1; i<=number; i++){
            int count=0; //선수번호별 약수개수
            for(int j=1; j<=Math.sqrt(i); j++){
                if(i%j==0){
                    //제곱근은 짝을 이루는 수가 없음
                    if(j==Math.sqrt(i)) count++;
                    //약수의 짝을 이루는 수가 있는 경우는 2개씩 더함
                    else count+=2;
                } 
            }
            //제한 수치초과한 경우는 power
            if(count>limit) answer+=power;
            else answer+=count;
        }
        
        return answer;
    }
}