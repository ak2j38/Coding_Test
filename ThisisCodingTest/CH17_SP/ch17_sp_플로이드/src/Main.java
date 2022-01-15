import java.io.*;

public class Main {
    static int n, m;
    static int[][] adj;

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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void solve() {
        // 플로이드 워셜 알고리즘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    adj[j][k] = Math.min(adj[j][k], adj[j][i] + adj[i][k]);
                }
            }
        }
    }

    private static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        adj = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = 987654321;
                if (i == j) {
                    adj[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            String[] split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]) - 1;
            int y = Integer.parseInt(split[1]) - 1;
            int cost = Integer.parseInt(split[2]);

            adj[x][y] = Math.min(cost, adj[x][y]);
        }
    }
}
