class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] check = new boolean[1000001];
        
        //0과 1은 소수가 아님
        check[0] = true;
        check[1] = true;
        //n의 최대범위까지 소수가 아닌 수는 true로 변경
        for(int i=2; i<Math.sqrt(1000001); i++){
            for(int j=i+i; j<1000001; j+=i){
                check[j] = true;
            }
        }
        //n까지 소수인 수 세기
        for(int i=2; i<=n; i++){
            if(check[i]==false) answer++;
        }
        return answer;
    }
}