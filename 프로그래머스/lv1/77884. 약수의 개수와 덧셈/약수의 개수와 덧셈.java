class Solution {
    public int solution(int left, int right) {
        int answer = 0;
       
        
        for(int i=left; i<=right; i++){
            int count = 0;
            for(int j=1; j<=i; j++){ //약수 개수 확인
                if(i%j==0) count++;
            }
            
            if(count%2==0) answer+=i; //약수개수가 짝수라면
            else answer-=i; //약수개수가 홀수라면
        }
        
        return answer;
    }
}