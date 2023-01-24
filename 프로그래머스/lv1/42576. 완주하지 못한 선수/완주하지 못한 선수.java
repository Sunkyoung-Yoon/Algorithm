import java.util.Arrays;
class Solution {
    public String solution(String[] participant, String[] completion) {
        
        //사전순으로 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i=0; i<completion.length; i++){
            if(!(participant[i].equals(completion[i]))){ 
               return participant[i];
            }   
        }
               
        //가장 마지막 선수가 미완주 선수
        return participant[participant.length-1];
            
    }
}