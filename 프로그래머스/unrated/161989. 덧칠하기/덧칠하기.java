class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        //칠하기
        //가장 작은 번호의 벽을 먼저 칠한다.
        int prev = section[0];
        answer++;
        for(int i=1; i<section.length; i++){
            //이전에 칠한 범위 내라면
            if(prev < section[i] && section[i] < prev+m){
                continue;
            }
            //새로 칠해야 한다면
            prev = section[i];
            answer++;
        }
        
        return answer;
    }
}