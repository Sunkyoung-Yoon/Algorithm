class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0; // 총 얻은 병수
        
        while(n>=a){
            answer += (n/a)*b; 
            n = (n/a)*b + n%a; //얻은 병수 + 가게에 주고 남은 병수
           
        }
        return answer;
    }
}