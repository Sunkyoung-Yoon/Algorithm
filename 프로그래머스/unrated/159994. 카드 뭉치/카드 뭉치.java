class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        //다음에 사용될 카드 인덱스
        int check1 = 0;
        int check2 = 0;
        
        for(int i=0; i<goal.length; i++){
            //인덱스 범위 벗어나는 경우 조정
            if(check1 > cards1.length-1) check1 = cards1.length-1;
            if(check2 > cards2.length-1) check2 = cards2.length-1;
            
            //첫번째 카드 뭉치에서 카드뽑을때
            if(cards1[check1].equals(goal[i])){
                check1++;
            } 
            //두번째 카드 뭉치에서 카드뽑을때
            else if(cards2[check2].equals(goal[i])){
                check2++;
            }
            //단어 배열 만들기 불가능
            else{
                answer = "No";
                break;
            }
        } 
        return answer;
    }
}