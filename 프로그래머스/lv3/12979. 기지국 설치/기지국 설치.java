class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        // 추가 기지국 
        int start=1; // 탐색 시작점
        int idx=0; // 기존 기지국 설치 인덱스
        while(true){
            if(start > n) break; 
            
            if(idx < stations.length && start >= stations[idx]-w){ // 기존 기지국 범위에 있는 곳이라면             
                start = stations[idx]+w+1; // 기지국의 범위 다음위치로 start 다시 설정
                idx++; // 기존 기지국도 다음 기지국으로 설정
            }
            
            else{ // 시작점이 기존 기지국 전파가 닿지 않는 곳이라면
                start += 2*w+1; // 새로 기지국 설치하고 전파가 안닿는 범위로 start 새로 설정
                answer++;
            }
        }

        return answer;
    }
}