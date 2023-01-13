import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		//key값에 중복 허용한하는 해시맵 이용
		HashMap<String, Integer> map = new HashMap<>(); //서로 다른 문자열
		
		
		String str = br.readLine();
		
		//str을 끊어서 저장한다. 중복값 제외
		for(int i=0; i<str.length(); i++) {
			for(int j=i+1; j<=str.length(); j++) {
				map.put(str.substring(i,j),0);
			}
		}
		
		System.out.println(map.size());
		
	}
}