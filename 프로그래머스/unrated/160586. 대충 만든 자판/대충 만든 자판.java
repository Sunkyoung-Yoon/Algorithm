import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        //최소로 눌러야하는 키횟수만 체크 필요, 같은 키 중 더 많이 눌러야 하는 쪽은 필요x
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<keymap.length; i++){
            for(int j=0; j<keymap[i].length(); j++){
                char ch = keymap[i].charAt(j);
                
                //이미 map에 있는 ch라면 입력횟수가 더 적은쪽으로 value 변경
                if(map.containsKey(ch)){
                    map.put(ch, map.get(ch)>(j+1)?(j+1):map.get(ch));
                }
                else{
                    map.put(ch, j+1);
                }
            }
        }
        
        for(int i=0; i<targets.length; i++){
            for(int j=0; j<targets[i].length(); j++){
                char ch = targets[i].charAt(j);
                //map에 있다면 입력횟수 더하기
                if(map.containsKey(ch)){
                    answer[i] += map.get(ch);
                }
                //map에 없는 문자가 있다면 -1저장 후 다음 문자열로
                else{
                    answer[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}