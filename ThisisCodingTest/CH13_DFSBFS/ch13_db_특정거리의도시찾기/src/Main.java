import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int N, M, K, X;
    static ArrayList<Integer>[] adj;
    static int[][] dist;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print() {
        int kDistCnt = (int)Arrays.stream(dist[X])
                .filter(d -> d == K)
                .count();

        if (kDistCnt == 0) {
            System.out.println(-1);
        } else {
            for (int i = 1; i <= N; i++) {
                if (dist[X][i] == K) {
                    sb.append(i).append("\n");
                }
            }
            System.out.println(sb);
        }
    }

    private static void solve() {
        // 찾아야 하는 거리정보 K
        // 시작점 X
        dfs(X, 0);
    }

    private static void dfs(int x, int depth) {
        depth++;
        for (int y : adj[x]) {
            if (dist[X][y] == 0) {
                dist[X][y] = depth;
            } else {
                dist[X][y] = Math.min(dist[X][y], depth);
            }
            dfs(y, depth);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        K = Integer.parseInt(split[2]);
        X = Integer.parseInt(split[3]);

        adj = new ArrayList[N + 1];
        dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            split = br.readLine().split(" ");
            adj[Integer.parseInt(split[0])].add(Integer.parseInt(split[1]));
        }
    }
}
