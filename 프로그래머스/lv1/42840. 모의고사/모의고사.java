import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        ArrayList<Integer> list = new ArrayList<>();
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        // 문제 맞춘 개수 저장
        for(int i=0; i<answers.length; i++){
            if(p1[i%5]==answers[i]) score1++;
            if(p2[i%8]==answers[i]) score2++;
            if(p3[i%10]==answers[i]) score3++;
        }
        
        int max = 0;
        max = Math.max(Math.max(score1,score2),score3);
        
        //max와 같은 수들만 list에 저장
        if(max==score1) list.add(1);
        if(max==score2) list.add(2);
        if(max==score3) list.add(3);
        
        //리턴할 배열에 저장
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}