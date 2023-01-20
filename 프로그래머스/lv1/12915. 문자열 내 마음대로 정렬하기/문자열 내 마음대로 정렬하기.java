import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer;
        ArrayList<String> list = new ArrayList<>();
        
        //리스트에 n번째 문자 + 원래 문자열 저장
        for(int i=0; i<strings.length; i++){
            list.add(strings[i].charAt(n)+strings[i]);
        }
        //n번째 글자를 기준으로 비교, 같다면 원래 문자열 비교 (사전순)
        Collections.sort(list);
        
        answer = new String[strings.length];
        //리스트에서 첫 글자 제외한 원래 문장 저장
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i).substring(1, list.get(i).length());
        }
        return answer;
    }
}