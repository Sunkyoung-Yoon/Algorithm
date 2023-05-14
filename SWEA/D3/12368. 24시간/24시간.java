import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringBuilder sb = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine());
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            int result = A + B;
            
            sb.append("#"+test_case+" ");
            if(result > 24){
                sb.append(result%24).append("\n");
            }
            else if(result < 24){
                sb.append(result).append("\n");
            }
            else sb.append(0).append("\n");
		}
        
        System.out.println(sb);
	}
}