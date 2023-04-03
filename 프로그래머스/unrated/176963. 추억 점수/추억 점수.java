import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        //그리운 사람과 해당하는 점수 저장
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<yearning.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        //사진에 있는 그리운 사람확인
        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                //점수가 있는 사람이 있다면 
                if(map.get(photo[i][j])!=null)
                    //해당 추억사진에 점수 추가
                    answer[i] += map.get(photo[i][j]);
            }
        }
        return answer;
    }
}