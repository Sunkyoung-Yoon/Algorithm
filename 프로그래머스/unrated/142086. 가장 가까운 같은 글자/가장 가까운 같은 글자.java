import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int index = -1;
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length();i++){
            String str = s.substring(i,i+1);
            //새로운 알파벳이 등장한 경우
            if(map.get(str)==null){
                map.put(str,i);
                answer[++index] = -1;
            }
            else{ //이전에 등장한 소문자인 경우
                //지금 소문자 등장위치 - 가장 최근 등장 위치
                answer[++index] = i-map.get(str);
                map.replace(str, i); //재등장한 소문자 위치 인덱스 변경
            }
            
        }
        return answer;
    }
}