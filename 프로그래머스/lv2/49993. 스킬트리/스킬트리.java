import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0; i<skill_trees.length; i++){
            //가능한 스킬트리인지 체크
            boolean flag = true;
            String s = skill; 
            
            
            for(int j=0; j<skill_trees[i].length(); j++){
                String s_tree = skill_trees[i].substring(j,j+1);
                
                //선행스킬에 없다면 바로 다음으로
                if(!s.contains(s_tree)) continue;
                
                //선행스킬 순서에 있고 배울 수 있다면
                if(s.substring(0,1).equals(s_tree)){
                    s = s.replace(s_tree,""); //배운 선행스킬은 ""으로 변경
                }
                //배울 수 없는 기술
                else{
                    flag = false;
                    break;
                }
                
            }
            
            //true라면 가능한 스킬트리
            if(flag) answer++;
        }
        return answer;
    }
}