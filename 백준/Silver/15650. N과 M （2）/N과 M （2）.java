import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (2)
public class Main {
    public static int N, M;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        dfs(0, 1);
        System.out.println(sb);

    }

    public static void dfs(int depth, int start) {
        // M개가 되면 그 수열 sb에 저장
        if(depth == M) {
            for(int a: arr){
                if(a == 0)
                    continue;
                sb.append(a+" ");
            }
            sb.append("\n");
            return;
        }

        // 수열 찾기
        for(int i=start; i<=N; i++) {
            // 중복 허용x 방문하지않은 수로만 수열 찾기
            if(!visited[i-1]) {
                visited[i-1] = true;
                arr[depth] = i;
                // 수열을 만드는 반복문의 시작을 시작 수부터로 변경
                dfs(depth + 1, i);

                // 새로운 숫자로 수열을 시작하기 전에 방문표시 초기화
                visited[i-1] = false;
            }
        }
    }

}