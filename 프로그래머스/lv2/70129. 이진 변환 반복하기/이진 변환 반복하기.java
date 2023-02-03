class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        //"1"이 되면 길이는 1
        while(!s.equals("1")){
            answer[1] += s.length(); //s 길이 더함
            //0 제거
            s = s.replace("0","");
            answer[1] -= s.length(); //s 길이(0을 제외한 1만 있을 때) 빼기
            
            s = Integer.toBinaryString(s.length());
            answer[0]++; //이진변환 횟수증가
        }
        return answer;
    }
}