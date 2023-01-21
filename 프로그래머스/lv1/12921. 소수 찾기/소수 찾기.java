class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] check = new boolean[n+1];
        
        //0과 1은 소수가 아님
        check[0] = true;
        check[1] = true;
        //소수가 아닌수는 true
        for(int i=2; i<Math.sqrt(n+1); i++){
            for(int j=i+i; j<n+1; j+=i){
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