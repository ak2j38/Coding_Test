import java.io.*;
import java.util.ArrayList;

public class Main {
    static int N;
    static int[][] DP;
    static ArrayList<Integer>[] adj;
    static int[] peoples;

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
        System.out.println(Math.max(DP[1][0], DP[1][1]));
    }

    static void dfs(int x, int prev) {
        DP[x][0] = 0;
        DP[x][1] = peoples[x];

        for (int y : adj[x]) {
            // 부모노드면 컨티뉴
            if (y == prev) continue;
            dfs(y ,x);
            DP[x][0] += Math.max(DP[y][0], DP[y][1]);
            DP[x][1] += DP[y][0];
        }
    }

    static void solve() {
        dfs(1, -1);
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        N = Integer.parseInt(br.readLine());
        peoples = new int[N+1];
        DP = new int[N+1][2];
        adj = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            adj[i] = new ArrayList<>();
        }
        String[] split = br.readLine().split(" ");
        for (int i=0; i<N; i++) {
            peoples[i+1] = Integer.parseInt(split[i]);
        }
        for (int i=0; i<N-1; i++) {
            split = br.readLine().split(" ");
            adj[Integer.parseInt(split[0])].add(Integer.parseInt(split[1]));
            adj[Integer.parseInt(split[1])].add(Integer.parseInt(split[0]));
        }
    }
}
