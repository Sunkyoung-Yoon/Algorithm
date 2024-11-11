import java.util.*;
class Solution {
    // skill: 선행 스킬 순서, skill_trees : 유저들이 만든 스킬트리
    // answer: 가능한 스킬트리 개수
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // 이미 배운 스킬이라면 선행 스킬 순서에서 제거
        // -> skill 가장 앞에 있는 문자만 배울 수 있음
        for(int i=0; i<skill_trees.length; i++) {
            boolean flag = true; // 불가능 판단 변수
            String s = skill; // 새로운 스킬트리 확인할 때마다 초기화
            
            for(int j=0; j<skill_trees[i].length(); j++) {
                String s_tree = skill_trees[i].substring(j,j+1);
                                
                // 선행 스킬에 없다면 -> 바로 배움 -> 가능
                if(!s.contains(s_tree)) {
                    continue;
                }
                                
                // 현재 먼저 배워야 하는 스킬 = 배울 스킬 -> 가능
                if(s.substring(0,1).equals(s_tree)) {
                    s = s.replace(s_tree,""); // 배운 스킬 제거
                }
                else { // 불가능
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                answer++;
            }
        }
        
        return answer;
    }
}