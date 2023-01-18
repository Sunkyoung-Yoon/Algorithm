class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = "";
        //3진수로 변환
        //ex) 45%3->0, 15%3->0, 5%3->2, 1%3->1
        //n=1/3->0으로 반복문 탈출 str=0021
        while(n>0){
            str += n%3;
            n /= 3;
        }
        //10진수로 변환
        answer = Integer.parseInt(str, 3);
        return answer;
    }
}