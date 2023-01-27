class Solution {
    public String solution(String s) {
        String answer = "";
        //공백 기준으로 끊어서 문자열 배열로 저장
        String[] tokens = s.split(" ");
        
        int max = Integer.parseInt(tokens[0]);
        int min = Integer.parseInt(tokens[0]);
        
        //최댓값 최솟값 구하기
        for(int i=0; i<tokens.length; i++){
            max = Math.max(max, Integer.parseInt(tokens[i]));
            min = Math.min(min, Integer.parseInt(tokens[i]));
        }
        
        answer += String.valueOf(min)+" ";
        answer += String.valueOf(max);
        return answer;
    }
}