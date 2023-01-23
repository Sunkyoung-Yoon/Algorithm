import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[][] rate = new double[N][2];
        double player = stages.length; //다음 스테이지로 넘어간 플레이어 수
        
        //각 스테이지별 머무르는 플레이어 수 저장
        for(int j=0; j<stages.length; j++){
            //마지막 스테이지 도달한 경우는 실패율 구할 대상이 아님
            if(stages[j]==(N+1)) continue;
            
            rate[stages[j]-1][1] +=1.0;
        }
        
        //스테이지와 스테이지별 실패율 배열fail에 저장
        for(int i=0; i<N; i++){
            rate[i][0] = i; //스테이지 번호 저장
            double loser = rate[i][1]; //스테이지에 머무르는 플레이어 수
            
            //ex) N=3 [1,1,1,1,1,1] fail[5,0,0] 0/0의 경우 실패율 0으로 처리해줘야 함
            if(player==0) rate[i][1]=0;
            
            else rate[i][1] = rate[i][1]/player; //스테이지 실패율 저장
            player = player-loser; //다음 스테이지 플레이어 수
            
        }
        
        Arrays.sort(rate, (o1, o2) -> { //o1과 o2는 배열의 각열을 의미
            if(o1[1]==o2[1]){ //실패율 같다면
                //스테이지 번호 오름차순
                //o1[0]이 크다면 자리변경을 위해 1리턴, 아니라면 -1리턴
                return (o1[0]-o2[0])>0?1:-1;
            }
            else{
                //실패율 내림차순
                //o1[1]이 크다면 -1리턴, 작다면 자리변경을 위해 1리턴
                return (o1[1]-o2[1])>0?-1:1; 
            }
        });
        
        //스테이지는 1부터 -> +1을 해줌
        for(int i=0; i<answer.length; i++){
            answer[i] = (int)rate[i][0]+1;
        }
        
        return answer;
    }
}