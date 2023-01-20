import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            //잘라서 숫자 저장할 배열의 크기 ex(2,5,3) 5-2=3
            int[] result = new int[commands[i][1]-commands[i][0]+1];
            int index=0;
            
            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
                //지정한 번째 사이의 숫자 저장
                result[index] = array[j];
                index++;
                
            }
            //오름차순 정렬
            Arrays.sort(result);
            
            answer[i] = result[commands[i][2]-1];
        }
        return answer;
    }
}