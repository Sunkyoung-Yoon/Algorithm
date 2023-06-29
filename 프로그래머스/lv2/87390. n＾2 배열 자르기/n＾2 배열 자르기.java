import java.util.*;

class Solution {
    public List<Long> solution(int n, long left, long right) {
        //n이 10^7 이면, n^2 이 int범위를 넘어감 -> 2차원배열 없이 풀이해야한다.
        List<Long> answer = new ArrayList<>();
            
        //n x n 배열일 때, (i/n)+1과 (i%n)+1은 각각 행과 열의 값이 된다.
        for(long i=left; i<right+1; i++){
            answer.add(Math.max(i/n, i%n) + 1);
        }
        
        return answer;
    }
}