import java.io.*;
import java.util.ArrayList;

public class Main {
    static int N, R, Q;
    static int[] Querys, DP;
    static ArrayList<Integer>[] adj;
    static StringBuilder sb;

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void print() {
        for (int targetNode : Querys) {
            sb.append(DP[targetNode]).append("\n");
        }
        System.out.println(sb);
    }

    static void solve() {
        dfs(R, -1);
    }

    static void dfs(int node, int prev) {
        DP[node] = 1;

        for (int child : adj[node]) {
            if (child == prev) continue;
            dfs(child, node);
            DP[node] += DP[child];
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        R = Integer.parseInt(split[1]);
        Q = Integer.parseInt(split[2]);
        adj = new ArrayList[N+1];
        DP = new int[N+1];
        Querys = new int[Q];
        sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i=1; i<N; i++) {
            split = br.readLine().split(" ");
            adj[Integer.parseInt(split[1])].add(Integer.parseInt(split[0]));
            adj[Integer.parseInt(split[0])].add(Integer.parseInt(split[1]));
        }
        for (int i=0; i<Q; i++) {
            Querys[i] = Integer.parseInt(br.readLine());
        }
    }
}
