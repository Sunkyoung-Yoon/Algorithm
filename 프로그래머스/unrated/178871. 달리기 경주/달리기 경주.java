import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String,Integer> map = new HashMap<>();
        
        //선수와 처음 등수 저장
        for(int i=0; i<players.length; i++){
            map.put(players[i],i);
        }
       
        //등수 조정
        for(int i=0; i<callings.length; i++){
            //불린 사람 현재 등수
            int rank = map.get(callings[i]);
            
            //바로 앞 사람 등수 +1
            String front = players[rank-1];
            map.put(front, map.get(front)+1);
            
            //선수 등수맞춰서 위치 변경
            String temp = players[rank-1];
            players[rank-1] = players[rank];
            players[rank] = temp; 
            
            //불린 사람 등수-1
            map.put(callings[i], map.get(callings[i])-1);
            
        }
        
        //최종 등수 저장
        for(int i=0; i<players.length; i++){
            //선수의 등수 순서대로 선수이름 저장
            answer[map.get(players[i])] = players[i];
        }
        return answer;
    }
}