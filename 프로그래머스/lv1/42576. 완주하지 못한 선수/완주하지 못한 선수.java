import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String answer = "";
        //동명이인이 있으므로 value에 이름 저장
        HashMap<String,Integer> map = new HashMap<>();
        
        //찹여자 명단 해시맵에 저장
        for(String s : participant){
            //이미 있는 선수이름(=동명이인)이라면 value는 +1
            map.put(s, map.getOrDefault(s,0)+1);
        }
        
        //완주자 명단 확인
        for(String s : completion){
            //완주자 명단에 있다면 value는 -1
            map.put(s, map.getOrDefault(s,0)-1);
        }
        
        for(String key : map.keySet()){
            //value가 0이 아니라면 완주자명단에 없는 선수
            if(map.get(key)!=0){
                answer = key;
                break;
            }
        }
        return answer;
            
    }
}