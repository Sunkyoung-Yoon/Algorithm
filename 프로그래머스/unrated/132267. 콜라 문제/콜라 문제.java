class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0; // 총 얻은 병수
        int bottle = 0; //가게에
        
        while(true){
            if(n<a) break;
            answer += (n/a)*b; 
            bottle = n%a; //가게에 주고 남은 병수
            n = (n/a)*b; //얻은 병수
            n += bottle; //총 갖고 있는 병수
           
        }
        return answer;
    }
}