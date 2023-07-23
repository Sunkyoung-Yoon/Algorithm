import java.io.*;
import java.util.*;

// N과 M (9)
public class Main {
    public static int N, M;
    public static int[] nums;
    public static int[] arr;
    public static HashSet<String> set;
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        nums = new int[N];
        set = new HashSet<>();
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0);

        System.out.println(sb);

    }

    public static void dfs(int depth) {
        // 수열이 M개가 되고 중복되지 않으면 sb에 저장
        String s = "";
        if(depth == M) {
            for(int a: arr){
                if(a == 0)
                    continue;
                s += a + " ";
            }

            if(!set.contains(s)) {
                set.add(s);
                sb.append(s+"\n");
            }

            return;
        }

        // 수열 찾기
        for(int i=0; i<N; i++) {
            // 중복 허용x 방문하지않은 수로만 수열 만들기
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = nums[i];
                dfs(depth + 1);

                // 새로운 숫자로 수열을 시작하기 전에 방문표시 초기화
                visited[i] = false;
            }
        }
    }

}