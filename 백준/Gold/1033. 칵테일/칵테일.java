import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<cNode>[] A; //인접리스트
	static long lcm; //최소공배수
	static boolean visited[]; //방문체크
	static long D[]; //각 노드의 비율에 따른 값을 저장할 배열
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		A = new ArrayList[N];
		visited = new boolean[N];
		D = new long[N];
		lcm = 1;
		for(int i=0; i<N; i++) {
			A[i] = new ArrayList<cNode>();
		}
		
		//리스트에 각 재료의 비율 저장
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			A[a].add(new cNode(b,p,q));
			A[b].add(new cNode(a,q,p));
			
			//주어진 p,q의 최소 공배수를 계속 업데이트하며 최대 공배수 값을 저장
			lcm *= (p*q/GCD(p,q));
		}
		
		//임의의 시작점에 최대공배수 lcm 저장
		D[0] = lcm;
		//임의로 0부터 탐색 시작
		DFS(0);
		
		long mgcd = D[0];
		//배열 D에 저장된 값들의 최대공약수 mgcd 구하기
		for(int i=1; i<N; i++) {
			mgcd = GCD(mgcd, D[i]);
		}
		
		//각 노드의 값을 최대공약수로 나누어서 질량값 구하기
		/*
		필요한 재료의 길양을 모두 더한 값이 최소가 되어야 하기 때문에,
		비율을 유지한 채 가장 최소가 되는 값을 출력
		*/
		for(int i=0; i<N; i++) {
			System.out.print(D[i]/mgcd+" ");
		}
	}
	
	//최대공약수
	public static long GCD(long a, long b) {
		if(a%b==0)
			return b;
		else
			return GCD(b,a%b);
	}
	
	//dfs
	public static void DFS(int Node) {
		visited[Node] = true;
		
		//A[Node]와 연결된 재료가 있다면
		for(cNode i: A[Node]) {
			//연결된 b를 가져온다.
			int next = i.getB();
			//D[b]에 지금 노드인 D[Node]와 비율에 따른 값을 계산후 저장
			if(!visited[next]) {
				D[next] = D[Node]*i.getQ()/i.getP();
				//b와 연결된 노드로 다음 탐색 진행
				DFS(next);
			}
		}
	}
		
}
// b,p,q를 담을 노드 클래스
class cNode{
	int b,p,q;
	
	public cNode(int b, int p, int q) {
		super();
		this.b=b;
		this.p=p;
		this.q=q;
	}
	
	public int getB() {
		return b;
	}
	public int getP() {
		return p;
	}
	public int getQ() {
		return q;
	}
}