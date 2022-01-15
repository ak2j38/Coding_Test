import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {
    static final int INF = 987_654_321;
    static int N, M, min, answer;
    static int[][] adj;
    static boolean[][] visit;

    public static void main(String[] args) {
        try {
            input();
            solve();
            print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void solve() {
        // 플로이드 워셜 알고리즘
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    adj[j][k] = Math.min(adj[j][k], adj[j][i] + adj[i][k]);
                }
            }
        }

        // 최솟값 찾기
        for (int i = 1; i <= N; i++) {
            int eachSum = Arrays.stream(adj[i])
                                .sum();
            if (min > eachSum) {
                min = eachSum;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    static void print() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void input() throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        min = Integer.MAX_VALUE;
        adj = new int[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                adj[i][j] = INF;
                if (i == j) adj[i][j] = 0;
            }
        }

        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }
}
