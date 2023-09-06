class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for(int i=1; i<triangle.length; i++){
            // 왼쪽만
            triangle[i][0] = triangle[i-1][0]+triangle[i][0];
            // 오른쪽만
            triangle[i][triangle[i].length-1] = 
                triangle[i-1][triangle[i-1].length-1]+triangle[i][triangle[i].length-1];
            
            // 가운데
            // 자기 위치에서 바로 전단계에서 오른쪽 선택과 왼쪽 선택중에 더 큰 쪽을 더해서 저장
            for(int j=1; j<triangle[i].length-1; j++){
                triangle[i][j] = triangle[i][j] + Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }
        
        for(int j=0; j<triangle[triangle.length-1].length; j++){
            answer = Math.max(answer, triangle[triangle.length-1][j]);
        }
        return answer;
    }
}