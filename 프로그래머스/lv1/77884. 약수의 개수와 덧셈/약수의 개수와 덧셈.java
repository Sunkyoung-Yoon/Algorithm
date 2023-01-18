class Solution {
    public int solution(int left, int right) {
        int answer = 0;
       
        for(int i=left; i<=right; i++){
            if(i%Math.sqrt(i)==0) //제곱수가 약수라면 홀수 ex)4 -1,2,4
                answer-=i;
            else
                answer+=i;
        }
        
        return answer;
    }
}