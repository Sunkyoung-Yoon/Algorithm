import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int count = 0;
        int[] answer = {-1};
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor==0)
                count++;
        }
        //나누어 떨어지는 원소가 하나도 없는 경우
        if(count==0){
            return answer;   
        }
        
        else{
            answer = new int[count];
            count = 0;
            for(int i=0; i<arr.length; i++){
                if(arr[i]%divisor==0){
                    answer[count]=arr[i];
                    count++;
                }
            }
            Arrays.sort(answer);
            
        }
        
        return answer;
    
    }
}