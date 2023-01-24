import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        int index = score.length;
        while(true){
            //m개씩 상자에 나눠 담을 때 가장 작은 점수
            index = index-m;
            //0보다 작다면 상자에 m개씩 담을 수 없음 - 반복문 종료
            if(index<0) break;
            //상자내에서 가장 작은 score*m을 저장
            answer +=score[index]*m;
        }
        
        return answer;
    }
}