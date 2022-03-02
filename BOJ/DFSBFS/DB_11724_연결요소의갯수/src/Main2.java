import java.io.*;

public class Main2 {

    static int N, M, connectionCount;
    static int[][] adj;
    static boolean[] visited;

    public static void main(String[] args) {

        try {
            input();
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                connectionCount++;
            }
        }

        System.out.println(connectionCount);
    }

    private static void dfs(int x) {
        visited[x] = true;

        for (int i = 1; i <= N; i++) {
            if (adj[x][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void input() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        adj = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        connectionCount = 0;

        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            adj[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = 1;
            adj[Integer.parseInt(split[1])][Integer.parseInt(split[0])] = 1;
        }
    }
}
