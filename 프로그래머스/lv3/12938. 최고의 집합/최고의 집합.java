class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        // 나눠 떨어지면 원소의 곱이 최대 ex) 4 4
        for(int i=0; i<n; i++){
                answer[i] = s/n;
        }
        
        // 나눠 떨어지지 않으면 나머지를 다른 원소에 더해주면 합이 s이면서 가장 큰 곱 ex) 4 5
        if(s%n != 0){
            for(int i=0; i<(s%n); i++){
                // 오름차순으로 나와야 하기 때문에 뒤에서부터 더하기
                answer[n-1-i]++;
            }
        }
        
        
        if(answer[0] == 0) return new int[] {-1};
        else return answer;
    }
}