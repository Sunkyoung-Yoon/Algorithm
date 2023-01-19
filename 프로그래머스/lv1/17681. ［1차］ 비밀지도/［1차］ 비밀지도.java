class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++){
            //이진수로 변경 및 비트논리연산 or 실행 -> 하나라도 1이면 1
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            //n길이보다 작은 경우 앞에 0을 붙여서 n길이로 만들기
            answer[i] = String.format("%"+n+"s", answer[i]);
            
            //1은 #, 0은 공백으로 대체
            answer[i] = answer[i].replace("1","#");
            answer[i] = answer[i].replace("0"," ");
            
        }
    
        
        return answer;
    }
}