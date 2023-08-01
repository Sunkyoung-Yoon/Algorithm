import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int[] switchs = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
        	switchs[i] = Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int gender = Integer.parseInt(st.nextToken());
        	int num = Integer.parseInt(st.nextToken());
        	
        	// 남학생
        	if(gender == 1) {
        		// num의 배수일 경우 스위치 끄고 켜기
        		for(int j=num; j<=n; j+=num) {
            		switchs[j] = switchs[j] == 1? 0:1;
            	}
        	}
        	// 여학생
        	else {
        		// num번째 스위치 끄고 켜기
        		switchs[num] = switchs[num] == 1? 0:1;
            	int idx = 1;
            	// num번째 스위치를 기준으로 가장 큰 대칭 범위 모두 스위치 끄고 켜기
            	while(true) {
            		if((num-idx)<1 || (num+idx) > n)
        				break;
            		
            		if(switchs[num-idx] == switchs[num+idx]) {
            			switchs[num-idx] = switchs[num-idx] == 1? 0:1; 
            			switchs[num+idx] = switchs[num+idx] == 1? 0:1; 
            		}
            		else {
            			break;
            		}
            		idx++;
            	}
        	}
        }
       
    	
    	for(int i=1; i<=n; i++) {
    		sb.append(switchs[i]+" ");
    		if(i%20 ==0)
    			sb.append("\n");
    	}
        System.out.println(sb);
	}
}