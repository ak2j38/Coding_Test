import java.io.*;

public class Main2 {
    static int T, n, m, MAX;
    static int[][] goldmine, DP;

    public static void main(String[] args) {
        try {
            input();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                int leftup, left, leftdown;
                // 왼쪽 위
                if (i == 0) leftup = 0;
                else leftup = DP[i - 1][j - 1];

                // 왼쪽
                left = DP[i][j - 1];

                // 왼쪽아래
                if (i == n - 1) leftdown = 0;
                else leftdown = DP[i + 1][j - 1];

                DP[i][j] += Math.max(leftdown, Math.max(left, leftup));
            }
        }
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            MAX = Math.max(MAX, DP[i][m - 1]);
        }
        System.out.println(MAX);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/woo-jinpark/Desktop/Park/05_Test/input/input.txt")));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] split = br.readLine().split(" ");
            n = Integer.parseInt(split[0]);
            m = Integer.parseInt(split[1]);
            goldmine = new int[n][m];
            DP = new int[n][m];
            MAX = Integer.MIN_VALUE;

            split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    goldmine[j][k] = Integer.parseInt(split[(j * 4) + k]);
                    DP[j][k] = Integer.parseInt(split[(j * 4) + k]);
                }
            }
            solve();
            print();
        }
    }
}
