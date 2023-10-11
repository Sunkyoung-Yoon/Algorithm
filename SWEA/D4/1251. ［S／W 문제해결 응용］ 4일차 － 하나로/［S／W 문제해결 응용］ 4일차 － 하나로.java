import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static double E;
	static int[][] land;
	static ArrayList<Edge> edgeList; //도시에서 도시로 시작,도착,비용
	static int parents[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for(int tc=1; tc<=T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			// 각 섬의 좌표 정보 저장
			land = new int[N][2];
			
			// x 좌표 저장
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				land[i][0] = Integer.parseInt(st.nextToken());
			}
			// y 좌표 저장
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				land[i][1] = Integer.parseInt(st.nextToken());
			}
			
			//printLand();
			
			E = Double.parseDouble(br.readLine()); // 환경 부담 세율
			
			// 도시 간 거리(비용) 저장 
			// 최소 환경 부담금 계산이 E*L^2이므로 L^2부분을 비용에 저장, 루트씌운 결과를 구할 필요x
			edgeList = new ArrayList<>();
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) { // i==j가 되어 A->A를 제외하기 위해 j=i+1
					int start = i;
					int end = j;
					double x = Math.abs(land[start][0] - land[end][0]); //x좌표간 거리
					double y = Math.abs(land[start][1] - land[end][1]); //y좌표간 거리
					
					edgeList.add(new Edge(start, end, x*x+y*y));
				}
			}
			
			edgeList.sort(null); // 재정의한 조건으로 리스트 정렬한다는 의미
			
			//printEdgeList();
			
			make();
			int cnt = 1; // 선택한 간선의 개수
			long result = 0; //결과값
			for(int i=0; i<edgeList.size(); i++) {
				Edge now = edgeList.get(i);
				if(union(now.start, now.end)) { // union 가능하면
//					System.out.println("union 실행");
					result += now.weight; // 간선 추가(섬 잇기)
//					System.out.println("start: "+now.start+" end: "+now.end);
//					System.out.println("result: "+result);
					if(cnt == N-1) break; // 간선을 모두 골랐다면 종료
					
					cnt++;
				}
			}
			
			sb.append("#"+tc+" "+Math.round(E*result)).append("\n");
		} // 테스트케이스 종료
		
		System.out.println(sb);
	}
	
	private static void make() {
		parents = new int[N];
		for(int i=0; i<N; i++) {
			parents[i] = i; // 모든 요소 자기가 대표자가 되도록 초기 설정
		}
	}
	
	// 대표자 찾기
	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	// 부모가 같은지 -> 싸이클이 있는지 체크
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false; // 싸이클 존재 -> union 불가능
		
		parents[bRoot]= aRoot; // a밑에 b를 붙임
		return true;
	}
	
	// 정렬 기준 재정의 - 가중치 작은거 먼저 선택하기 위해서
	private static class Edge implements Comparable<Edge>{
		int start; //시작섬
		int end; // 도착섬
		double weight; // 가중치(거리)
		public Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return (int)(this.weight - o.weight);
		}
	}
	
	// 가중치(다리 길이) 기준으로 정렬 되었는지 체크
	private static void printEdgeList() {
		for (int i = 0; i < edgeList.size(); i++) {
			Edge now = edgeList.get(i);
			System.out.println("start: "+now.start+" end: "+now.end);
			System.out.println("weight: "+now.weight);
			System.out.println();
		}
	}
	
	// 좌표 제대로 저장되었는지 페크
	private static void printLand() {
		for(int i=0; i<N; i++) {
			System.out.print(land[i][0]+" ");
			System.out.print(land[i][1]+" ");
			System.out.println();
		}
	}
	
}