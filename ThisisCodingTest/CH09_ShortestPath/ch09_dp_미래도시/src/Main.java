import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static int N, M, X, K;
    static int[][] dist;

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
        int iDist = (dist[1][K] + dist[K][X] == Integer.MAX_VALUE) ? -1 : dist[1][K] + dist[K][X];
        System.out.println(iDist);
    }

    private static void solve() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][X] + dist[X][j]);
                }
            }
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\k2j38\\OneDrive\\Desktop\\Park\\99.ETC\\input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 1; i <= M; i++) {
            split = br.readLine().split(" ");
            dist[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = 1;
            dist[Integer.parseInt(split[1])][Integer.parseInt(split[0])] = 1;
        }

        split = br.readLine().split(" ");
        X = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);
    }
}
