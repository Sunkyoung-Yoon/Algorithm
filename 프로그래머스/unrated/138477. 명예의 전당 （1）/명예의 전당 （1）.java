import java.util.Arrays;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int min_score = score[0];
        //명예의 전당에 있는 점수 저장할 배열
        int[] arr = Arrays.copyOfRange(score, 0, k);
        
        //k가 더 길다면 배열 score의 값들 비교만 하면됨
        if(k>score.length) k=score.length;
        
        //k일까지 최하위 점수 저장
        for(int i=0; i<k; i++){
            //최하위 점수보다 큰 점수 나오면 최하위 점수는 동일함
            if(min_score < score[i]){
                answer[i] = min_score;
            } 
            //최하위 점수보다 작은 점수 나오면 최하위 점수 변경
            else{
                answer[i] = score[i];
                min_score = score[i];  
            } 
        }
        
        
        //arr 오름차순 정렬 최하위 점수는 arr[0]
        Arrays.sort(arr);
        
        //k일 이후 최하위 점수 저장
        for(int i=k; i<score.length; i++){
            //최하위 점수보다 큰 점수 나오면 최하위점수 변경
            if(min_score < score[i]){
                //최하위 점수자리에 score[i]로 변경
                arr[0] = score[i];
                //점수 오름차순으로 정렬 맨앞이 최하위 점수
                Arrays.sort(arr);
                
                answer[i] = arr[0];
                min_score = arr[0];
            }
            else answer[i] = min_score;
        }
        return answer;
    }
}