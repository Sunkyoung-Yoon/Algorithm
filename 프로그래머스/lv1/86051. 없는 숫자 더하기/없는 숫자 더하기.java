class Solution {
    public int solution(int[] numbers) {
        int[] counting_arr = new int[10];
        int sum = 0;
        
        for(int i=0; i<numbers.length; i++){
            counting_arr[numbers[i]]++;
        }
        
        for(int i=0; i<counting_arr.length; i++){
            if(counting_arr[i]!=0) continue;
            
            sum+=i;
        }
        
        return sum;
    }
}