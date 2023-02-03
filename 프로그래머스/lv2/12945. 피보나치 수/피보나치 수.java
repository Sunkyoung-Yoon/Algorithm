class Solution {
    public int solution(int n) {
        int[] arr = new int[n+1];
        
        arr[0] = 0;
        arr[1] = 1;
        //피보나치 수가 int형과 long형 범위를 넘게 되기 때문에 1234567로 매번 나눈 뒤, 수 저장
        for(int i=2; i<=n; i++){
            arr[i] = (arr[i-1]+arr[i-2])%1234567;
        }
         
        return arr[n];
    }
}