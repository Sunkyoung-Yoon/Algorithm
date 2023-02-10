public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        //n에서부터 0으로 top-bottom으로 접근
        while(n!=0){
            //짝수라면 절반으로 나눔
            if(n%2==0) n=n/2;
            
            //홀수라면 가기위해 점프 사용 필수
            else{
                n--; //1을 빼주면서 n을 다시 짝수로
                ans++; //1은 점프해야하므로 건전지 사용량 1증가
            }
        }

        return ans;
    }
}