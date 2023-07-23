import java.util.Scanner;

// N과 M (3)
public class Main {
    public static int N, M;
    public static int[] arr;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        visited = new boolean[N];

        dfs(0);
        System.out.println(sb);

        sc.close();

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