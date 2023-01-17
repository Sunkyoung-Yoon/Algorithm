class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String str = String.valueOf(x);
        int sum = 0;
        
        //각 자릿수의 합 구하기
        for(int i=0; i<str.length(); i++){
            sum+=str.charAt(i)-'0';
        }
        //하샤드 수 판별
        if(x%sum!=0) answer = false;
        
        return answer;
    }
}