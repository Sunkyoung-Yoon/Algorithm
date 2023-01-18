class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int min = Math.min(n,m);
        int max = Math.max(n,m);
        
        // 최대 공약수 찾기
        // 유클리드호제법 - n>m일 때, n와 m의 최대공약수는 m과 n%m의 최대공약수와 같다.
        // n>m일 때, n%m==0이 될 때, m이 최대공약수, 0이 아니라면 n대신 m을, m대신 n%m을 대입
        while(min>0){
            int r = max%min;
            max = min;
            min = r;
        }
        answer[0] = max;
        answer[1] = n*m/max;
        
        return answer;
    }
}