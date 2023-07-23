import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (3)
public class Main {
    public static int N, M;
    public static int[] arr;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        dfs(0);
        System.out.println(sb);

    }

    public static void dfs(int depth) {
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
        for(int i=1; i<=N; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
    }
}