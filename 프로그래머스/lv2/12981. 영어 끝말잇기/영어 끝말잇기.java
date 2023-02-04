import java.util.HashMap;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        int number = 0; //번호
        int turn = 1; //차례
        boolean flag = true; //끝말잇기 성공여부
        HashMap<String, Integer> map = new HashMap<>();
        
        //처음 단어 첫 글자 미리 저장
        char prev = words[0].charAt(0); 
        for(int i=0; i<words.length; i++){
            number++;
            
            //현재 단어 첫번째 글자
            char ch = words[i].charAt(0);
            
            //이미 있거나 이전 단어의 마지막글자와 지금 단어의 첫글자가 다르다면
            if(map.containsKey(words[i]) || prev!=ch) {
                answer[0] = number;
                answer[1] = turn;
                flag = false;
                break;
            }
            
            map.put(words[i],0);
            prev = words[i].charAt(words[i].length()-1); //이전 단어 마지막글자 저장
            
            //모든사람 차례 다 돌았다면
            if(number%n==0){
                number = 0;
                turn++;
            }
        }
        
        
        //true라면 배열 기본값인 0,0그대로 있음
        return answer;
    }
}