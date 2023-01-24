import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        boolean[] check = new boolean[31];
        
        for(int i=0; i<reserve.length; i++){
            check[reserve[i]] = true;
        }
        
        for(int i=0; i<lost.length; i++){
            if(check[lost[i]]){
                //lost와 reserve 모두에 있는 학생은 옷을 빌려줄 수 없음
                check[lost[i]] = false; 
                //lost와 reserve 모두에 있는 학생은 본인의 여벌을 입는다.
                //참여가능한 학생은 0으로 변경
                lost[i]=0;
            }
            
        }
        
        //최대한 많은 학생 참여를 위해 오름차순으로 정렬 후 여벌확인
        Arrays.sort(lost);
        for(int i=0; i<lost.length; i++){
            
            if(lost[i]!=0){
                //바로 앞 번호가 여벌이 있다면
                if(check[lost[i]-1]){
                    //빌려주기 때문에 false로 변경
                    check[lost[i]-1] = false;
                    lost[i] = 0; //찹여가능한 사람 0으로 값 변경
                }
                //바로 뒷 번호가 여벌이 있다면
                else if(check[lost[i]+1]){
                    //빌려주기 때문에 false로 변경
                    check[lost[i]+1] = false;
                    lost[i] = 0;
                }
            }       
        }
        
        for(int i=0; i<lost.length; i++){
            //참여불가능한 학생 수 빼기
            if(lost[i]!=0) answer--;
        }
        return answer;
    }
}