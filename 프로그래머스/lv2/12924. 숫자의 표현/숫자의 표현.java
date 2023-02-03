class Solution {
    public int solution(int n) {
        int answer = 1; //15인 경우 미리 카운트
        
        
        int start = 0;
        int end = 0;
        int sum = 0;
        
        while(end<n){
            //sum이 크다면 시작포인터 증가
            //sum = sum-start
            if(sum>n){
                sum-=start;
                start++;
            }
            //sum이 작다면 종료 포인터 증가
            //sum = sum+end
            else if(sum<n){
                end++;
                sum+=end;
            }
            else{
                end++;
                sum+=end;
                answer++;
            }
        }
        
        return answer;
    }
}