import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static int[][] result; // 그칸에 도달하는 최소 비용 저장할 배열
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = 0; // 문제번호
		while (true) {
			N = Integer.parseInt(br.readLine()); // 동굴의크기 NxN

			if (N == 0)
				break;

			T++;

			// 동굴 정보 저장
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = new int[N][N];
			// result 배열 초기세팅
			for(int i=0; i<N; i++) {
				Arrays.fill(result[i], 1000000007);

			}
			bfs();

			sb.append("Problem " + T + ": " + result[N-1][N-1]).append("\n");
		}

		System.out.println(sb);
	}

	static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				// 도둑루피가 적은 애부터 탐색하도록 정렬 기준 작성
				if(p1.weight-p2.weight > 0)
					return 1;
				else
					return -1;
			}
		});
		
		pq.add(new Point(0,0, map[0][0]));

		while(!pq.isEmpty()) {
			Point now= pq.poll();
			
			// 앞서 저장한 최소 비용보다 이미 비용이 크다면 더 볼필요없음 패스
			if(now.weight > result[now.i][now.j]) continue;
			
			for(int d=0; d<4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];
				
				if(nexti>=0 && nexti<N && nextj>=0 && nextj<N) {
					// 현재까지 거리 + 다음칸으로 새로 이동했을 때 비용
					int result_dis = now.weight+map[nexti][nextj];
					
					// result 배열의 값이 기본적으로 Integer.MAX_VALUE로 되어있음
					if(result[nexti][nextj] > result_dis) {
						result[nexti][nextj] = result_dis;
						pq.add(new Point(nexti, nextj, result_dis));
					}
				}
				
			}
		}
	}

	static class Point {
		int i;
		int j;
		int weight;

		public Point(int i, int j, int weight) {
			this.i = i;
			this.j = j;
			this.weight = weight;
		}
	}

	static void print(int[][] tmp) {
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp.length; j++) {
				System.out.print(tmp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}