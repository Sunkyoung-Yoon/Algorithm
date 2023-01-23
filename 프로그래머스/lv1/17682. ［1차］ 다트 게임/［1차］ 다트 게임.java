class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];
        
        int index=-1; //다트 시도 횟수
        int count=0; //숫자자릿수
        
        for(int i=0; i<dartResult.length(); i++){
            char ch = dartResult.charAt(i);
            if(ch=='S'){//1제곱
                //S 이전에 등장한 숫자부분을 int형으로 변경
                int n = Integer.parseInt(dartResult.substring(i-count,i));
                score[++index] = n*1;
                count=0;
            }
            else if(ch=='D'){//2제곱
                int n = Integer.parseInt(dartResult.substring(i-count,i));
                score[++index] = n*n;
                count=0;
            }
            else if(ch=='T'){ //3제곱
                int n = Integer.parseInt(dartResult.substring(i-count,i));
                score[++index] = n*n*n;
                count=0;
                
            }
            else if(ch=='#'){ //해당 점수 음수로 변경
                score[index] = score[index]*(-1);
            }

            else if(ch=='*'){
                if(index==0){ //첫번째 스타상 해당 점수만 2배
                    score[index] = score[index]*2;
                        
                }
                else{ //해당 점수와 바로 직전 점수 2배
                score[index] = score[index]*2;
                score[index-1] = score[index-1]*2;
                       
                }
            }
            else{ //S,T,D,,#,* 등장이전에 숫자 개수 확인 0~9는 1, 10일 때는 2가 됨
                count++;
            }
    
        }
        //점수의 합 저장
        for(int i=0; i<3; i++){
            answer += score[i];
        }
        return answer;
    }
}